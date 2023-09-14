package com.example.EmployeeManagement.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayRollDto {

    private Integer payRollId;

    private String date;

    private String report;

    private Double totalAmount;

}
