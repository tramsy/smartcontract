package com.smartcontract.smartcontract.configuration;

import java.util.Collection;
import java.util.List;

import com.smartcontract.smartcontract.entities.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails 
{

    private static final long serialVersionUID = 7526472295622776147L;
    private User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }
    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() 
    {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(this.user.getRole());
        return List.of(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() 
    {   
        return this.user.getPassword();
    }

    @Override
    public String getUsername() 
    {
        
        return this.user.getEmail();
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
        
        return true;
    }

    
}
