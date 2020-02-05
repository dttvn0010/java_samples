package com.example.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	Map<String, List<String>> users = Map.of(
	            "admin", List.of("USER", "ADMIN"),
	            "test", List.of("USER")
	        );
	
	String password = "$2a$10$Lp6eay3fKk9PcRUuDJ9CAedXtd9g6voBsdULDDyfWOiOPy1J1Xtqe";  // test
    
    @Override
    public UserDetails loadUserByUsername(String username) {
        var roles = users.get(username);
        if(roles != null) {
            var grantedAuthorities = new HashSet<GrantedAuthority>();
            for(var role : roles) {
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role));            
            }

            return new org.springframework.security.core.userdetails.User(username, password, grantedAuthorities);            
        }        
        
        throw new UsernameNotFoundException(username);
    }
}
