package com.app.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
public class UserDto {

    private int roleId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String mobileNumber;

}
