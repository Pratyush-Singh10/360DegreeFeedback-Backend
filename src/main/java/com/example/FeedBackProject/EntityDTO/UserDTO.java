package com.example.FeedBackProject.EntityDTO;

import javax.persistence.Id;
import javax.validation.constraints.Email;

public class UserDTO {

    private String  EmpId;

    @Email
    private String emailId;

    private String name;

    private String role;

}
