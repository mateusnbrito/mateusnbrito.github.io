package com.fareieumesmo.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fareieumesmo.site.dtos.UserDto;
import com.fareieumesmo.site.entities.User;
import com.fareieumesmo.site.services.AuthenticationService;

@RestController
public class AuthenticationController {
  @Autowired
  private AuthenticationService authenticationService;

  private final String auth = "/auth";
  private final String login = "/login";
  private final String create = "/create";
  private final String user = "/user";

  @PostMapping(auth + login + user)
  public String authenticate(@RequestBody UserDto userDto) {
    return authenticationService.authenticate(userDto);
  }

  @PostMapping(auth + create + user)
  public ResponseEntity<String> postUser(@RequestBody User newUser) {
    try {
      authenticationService.saveUser(newUser);

      return ResponseEntity.status(HttpStatus.OK).body("User was created.");
    } catch (Exception e) {
      System.out.println(e);
    }

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User couldn't be created.");
  }
}
