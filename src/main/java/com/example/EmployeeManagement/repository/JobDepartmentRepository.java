package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.entity.JobDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDepartmentRepository extends JpaRepository<JobDepartment,Long> {
}
