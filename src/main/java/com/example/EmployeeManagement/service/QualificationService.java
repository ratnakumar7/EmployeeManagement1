package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.payload.QualificationDto;

import java.util.List;

public interface QualificationService {
    public QualificationDto saveQualification(int empId,QualificationDto qualificationDto);

    public List<QualificationDto> getAllQualificationDetails();

    public QualificationDto updateQualification(int id,QualificationDto qualificationDto);

    public void delete(int qualificationId);
}
