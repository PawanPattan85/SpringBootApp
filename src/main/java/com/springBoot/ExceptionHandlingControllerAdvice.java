/*package com.springBoot;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ldap.CommunicationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { CommunicationException.class,java.net.NoRouteToHostException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		System.err.println("--------------------------------->>>>>");
        return new ResponseEntity<Object>(
                "Access denied message here", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
	
	@ExceptionHandler(value = { CommunicationException.class,java.net.NoRouteToHostException.class})
    public ModelAndView  handleLdapCommunicationException(Exception ex) {
		System.err.println("--------------------------------->>>>>");
		ModelAndView asd = new ModelAndView ();
		asd.setViewName("error");
		return asd; 
	}
}*/