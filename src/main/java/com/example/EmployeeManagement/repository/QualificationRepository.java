package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.entity.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification,Integer> {
}
