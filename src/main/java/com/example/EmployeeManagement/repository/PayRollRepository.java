package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.entity.PayRoll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayRollRepository extends JpaRepository<PayRoll,Integer> {
}
