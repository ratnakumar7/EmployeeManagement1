package com.example.EmployeeManagement.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDepartmentDto {
    private Long jobId;
    private String jobDept;
    private String name;
    private String description;
    private Double salaryRange;
}
