package com.example.EmployeeManagement.impl;

import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.entity.Qualification;
import com.example.EmployeeManagement.exception.EmployeeNotFound;
import com.example.EmployeeManagement.payload.QualificationDto;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import com.example.EmployeeManagement.repository.QualificationRepository;
import com.example.EmployeeManagement.service.QualificationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QualificationServiceImpl implements QualificationService {
    @Autowired
    private QualificationRepository qualificationRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public QualificationDto saveQualification(int empId,QualificationDto qualificationDto) {
         Employee employee = employeeRepository.findById(empId)
                 .orElseThrow(()->new EmployeeNotFound("Employee "+empId+" is Not Found"));
         Qualification qualification = modelMapper.map(qualificationDto, Qualification.class);
         qualification.setEmployee(employee);// here setting the qualification to the user

         //after setting the qualification to the employee we are storing the DB
        qualificationRepository.save(qualification);
        return modelMapper.map(qualification,QualificationDto.class);
    }

    @Override
    public List<QualificationDto> getAllQualificationDetails() {
        List<Qualification> qualification = qualificationRepository.findAll();
        return qualification.stream()
                .map(details -> modelMapper.map(details, QualificationDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public QualificationDto updateQualification(int id, QualificationDto qualificationDto) {
            Optional<Qualification> qualification = qualificationRepository.findById(id);
            if (qualification.isEmpty()){
                throw new RuntimeException("Qualification Id is not present");
            }
          Qualification qualification1 = modelMapper.map(qualificationDto,Qualification.class);
            qualificationRepository.save(qualification1);
            return modelMapper.map(qualification1,QualificationDto.class);
    }

    @Override
    public void delete(int qualificationId) {
        qualificationRepository.deleteById(qualificationId);
    }
}
