package com.example.EmployeeManagement.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Integer empId;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private String contactAddress;
    private String empEmail;

    private String empPass;
}
