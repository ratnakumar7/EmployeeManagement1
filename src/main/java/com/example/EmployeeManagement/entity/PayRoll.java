package com.example.EmployeeManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pay_roll")
public class PayRoll {

    @Id
    @Column(name = "payroll_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payRollId;

    @Column(name = "date")
    private String date;

    @Column(name = "report")
    private String report;

    @Column(name = "total_amount")
    private Double totalAmount;

    @OneToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "job_id")
    private JobDepartment jobDepartment;

    @OneToOne
    @JoinColumn(name = "salary_id")
    private Salary salary;

}
