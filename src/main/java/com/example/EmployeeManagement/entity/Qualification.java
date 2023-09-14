package com.example.EmployeeManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "qualification")
public class Qualification {
    @Id
    @Column(name = "qualification_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer qualificationId;

    @Column(name = "position")
    private String position;

    @Column(name = "requirements")
    private String requirements;

    @Column(name = "date_in")
    private String dateIn;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id")
    private Employee employee;
}
