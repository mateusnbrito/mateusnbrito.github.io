package com.fareieumesmo.site.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fareieumesmo.site.dtos.UserDto;
import com.fareieumesmo.site.entities.User;
import com.fareieumesmo.site.repositories.UserRepository;

@Service
public class AuthenticationService {
  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  UserRepository userRepository;

  @Autowired
  private AuthenticationManager authenticationManager;

  private JwtService jwtService;

  public AuthenticationService(JwtService jwtService) {
    this.jwtService = jwtService;
  }

  public String authenticate(UserDto userDto) {
    try {
      return jwtService.generateToken(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getName(), userDto.getPassword())));
    } catch (Exception e) {
      System.out.println(e);

      return null;
    }
  }

  public void saveUser(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));

    try {
      userRepository.save(user);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
