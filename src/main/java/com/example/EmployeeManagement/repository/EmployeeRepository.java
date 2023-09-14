package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@EnableJpaRepositories
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    public List<Employee> findByFirstName(String name);
}
