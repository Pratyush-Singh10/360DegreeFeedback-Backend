package com.example.FeedBackProject.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccoliteEmployeeData {

    private String employee_id;
    private String company_email_id;
    private String direct_manager_employee_id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String business_unit;
    private String hod;
}
