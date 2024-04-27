package com.fareieumesmo.site.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fareieumesmo.site.entities.User;

public class UserAuthenticated implements UserDetails {
  private final User user;

  public UserAuthenticated(User user) {
    this.user = user;
  }

  @Override
  public String getUsername() {
    return user.getName();
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  // TODO
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(() -> "read");
  }

  // TODO
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  // TODO
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  // TODO
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  // TODO
  @Override
  public boolean isEnabled() {
    return true;
  }

}
