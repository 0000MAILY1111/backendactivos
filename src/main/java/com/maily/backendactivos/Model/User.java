package com.maily.backendactivos.Model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;


import java.util.Optional;
import java.util.Random;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



@Document(collection = "users")
public class User {
  @Id
  private Long id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;
  private Role role;
  public User() {
	  this.id = new Random().nextLong();
  }

  public User(String username, String email, String password,Role role) {
	this.id = new Random().nextLong();
    this.username = username;
    this.email = email;
    this.password = password;
    this.role = role;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
  @Override
  public String toString() {
      return new ToStringBuilder(this)
              .append("id", id)
              .append("email", email)
              .append("role", role)
              .toString();
  }
  public User merge(User updateRequest) {
      Optional.ofNullable(updateRequest.getEmail()).ifPresent(this::setEmail);
      Optional.ofNullable(updateRequest.getPassword()).ifPresent(this::setPassword);
      Optional.ofNullable(updateRequest.getRole()).ifPresent(this::setRole);

      return this;
  }
  
  public enum Role implements GrantedAuthority {
      NORMAL,
      ADMIN;

      @Override
      public String getAuthority() {
          return "ROLE_" + this.name();
      }
  }
}