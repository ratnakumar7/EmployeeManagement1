package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary,Integer> {
}
