package com.optimus.nnlt.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomUserDetail extends User implements UserDetails {
    CustomUserDetail(User user){
        super(user);
    }

    @Override
    Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (Role role: super.getRoles()) {
            authorityList.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorityList;
    }

    @Override
    String getUsername() {
        return super.getEmail();
    }
    @Override
    String getPassword() {
        return super.getPassword();
    }

    @Override
    boolean isAccountNonExpired() {
        return true;
    }

    @Override
    boolean isAccountNonLocked() {
        return true;
    }

    @Override
    boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    boolean isEnabled() {
        return true;
    }
}