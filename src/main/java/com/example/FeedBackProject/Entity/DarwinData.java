package com.example.FeedBackProject.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DarwinData {

    @Id
    private String empId;

    private String emailId;

    private String name;

    private String managerEmpId;

    private String buName;

    private String hod;
}
