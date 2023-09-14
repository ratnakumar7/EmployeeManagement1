package com.example.EmployeeManagement.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QualificationDto {

    private String position;

    private String requirements;

    private String dateIn;
}
