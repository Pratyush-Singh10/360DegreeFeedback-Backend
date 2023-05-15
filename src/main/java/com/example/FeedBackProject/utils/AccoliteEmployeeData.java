package com.example.FeedBackProject.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccoliteEmployeeData {

    private String employee_id;
    private String company_email_id;
    private String direct_manager_employee_id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String business_unit;
    private String hod;

    @Override
    public String toString() {
        return "AccoliteEmployeeData{" +
                "employee_id='" + employee_id + '\'' +
                ", company_email_id='" + company_email_id + '\'' +
                ", direct_manager_employee_id='" + direct_manager_employee_id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", business_unit='" + business_unit + '\'' +
                ", hod='" + hod + '\'' +
                '}';
    }
}
