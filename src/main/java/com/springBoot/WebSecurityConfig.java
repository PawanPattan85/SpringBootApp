package com.springBoot;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;

import com.springBoot.service.EmployeeService;

//@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/").permitAll()
                .antMatchers("/", "/home").hasAnyRole("ADMIN","USER")
                .anyRequest().fullyAuthenticated()
                .and().csrf().and().cors().disable()
            .formLogin()
                .and()
            .logout()
                .permitAll();
                
    }
    
    @Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**").antMatchers("/css/**")
				.antMatchers("/js/**").antMatchers("/images/**").antMatchers("/angularjs/**"); // #3
	}

    @Autowired
    EmployeeService employeeService;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       // auth.getDefaultUserDetailsService().loadUserByUsername(username);
//    	auth.inMemoryAuthentication().withUser("ppattan@yahoo.co.in").password("pawan1234pattan").roles("ADMIN")
//    	.and().withUser("user1").password("pass1").roles("ADMIN");
    	auth.authenticationProvider(activeDirectoryLdapAuthenticationProvider());//.userDetailsService(employeeService);
    }
    
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return new ProviderManager(Arrays.asList(activeDirectoryLdapAuthenticationProvider()));
    }
    
    @Bean
    public ActiveDirectoryLdapAuthenticationProvider activeDirectoryLdapAuthenticationProvider() throws Exception{
        ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider("osius.com", "ldap://192.168.86.56:329");
        provider.setConvertSubErrorCodesToExceptions(true);
        provider.setUseAuthenticationRequestCredentials(false);
        provider.setUserDetailsContextMapper(employeeService);
        return provider;
    }
}
