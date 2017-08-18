package com.springBoot.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;

import com.springBoot.domain.OsiEmployeeDetails;
import com.springBoot.repo.EmployeeRepo;
@Configuration
public class EmployeeService implements UserDetailsContextMapper {

	@Autowired
	EmployeeRepo empRepo;
	

	@Override
	public UserDetails mapUserFromContext(DirContextOperations ctx,
			String username, Collection<? extends GrantedAuthority> authorities) {
		OsiEmployeeDetails osiEmployeeDetails = empRepo.findOne(username);
		Collection<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return new org.springframework.security.core.userdetails.User("ppattan@osius.com","Osi@4321", authList);
//		return new org.springframework.security.core.userdetails.User(username,"Osi@4321", authList);
	}

	@Override
	public void mapUserToContext(UserDetails user, DirContextAdapter ctx) {
		// TODO Auto-generated method stub
		
	}

}
