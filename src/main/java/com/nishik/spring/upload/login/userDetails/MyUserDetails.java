package com.nishik.spring.upload.login.userDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.nishik.spring.upload.entity.UserLoginAccess;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
 

@SuppressWarnings("serial")
public class MyUserDetails implements UserDetails{
	
	private UserLoginAccess user;
    
    public MyUserDetails(UserLoginAccess user) {
        this.user = user;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        @SuppressWarnings("unchecked")
		Set<UserLoginAccess> roles = (Set<UserLoginAccess>) user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        for (UserLoginAccess role : roles) {
            authorities.add(new SimpleGrantedAuthority((String) role.getRoles()));
        }
         
        return authorities;
    }
 
    @Override
    public String getPassword() {
        return user.getPassword();
    }
 
    @Override
    public String getUsername() {
        return user.getUsername();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }
 
}
