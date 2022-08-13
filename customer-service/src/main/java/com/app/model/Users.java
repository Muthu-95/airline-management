package com.app.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table (name = "Users")
public class Users {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name= "UserId")
    private Integer userId;

    @Column (name= "RoleId")
    private Integer roleId;

    @Column (name= "FirstName")
    private String firstName;

    @Column (name= "LastName")
    private String lastName;

    @Column (name= "Email")
    private String email;

    @Column (name= "Password")
    private String password;

    @Column (name= "MobileNumber")
    private String mobileNumber;

    @Column (name= "IsDeleted")
    private Boolean isDeleted;

    @Column (name= "CreatedOn")
    private LocalDateTime createdOn;

    @Column (name= "ModifiedOn")
    private LocalDateTime modifiedOn;

}
