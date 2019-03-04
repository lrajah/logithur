/**
 * 
 */
package com.formation.logithur.secure.utils;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.formation.logithur.persistence.entity.User;



/**
 * @author Dell
 *
 */
@Component
public class AuthChecker {
	public User isUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean isUser = SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"));
		if (principal != null && principal instanceof User && isUser) {
			return (User)principal;
		} else {
			return null;
		}
	}
}
