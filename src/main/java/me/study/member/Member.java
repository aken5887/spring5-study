package me.study.member;

import java.util.Date;

public class Member {
  private Long id;
  private String email;
  private String password;
  private String name;
  private Date registerDate;

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getName() {
    return name;
  }

  public Date getRegisterDate() {
    return registerDate;
  }

  @Override
  public String toString() {
    return "Member{" +
        "id=" + id +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", name='" + name + '\'' +
        ", registerDate=" + registerDate +
        '}';
  }

  public Member(String email, String password, String name) {
    this.email = email;
    this.password = password;
    this.name = name;
  }
}
