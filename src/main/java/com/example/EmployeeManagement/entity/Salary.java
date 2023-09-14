package com.example.EmployeeManagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "salary")
public class Salary {
    @Id
    @Column(name = "salary_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salaryId;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "annual_salary")
    private Double annual;

    @Column(name = "bonus")
    private Double bonus;

    @ManyToOne
    private JobDepartment jobDepartment;
}
