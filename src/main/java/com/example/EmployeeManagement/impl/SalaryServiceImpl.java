package com.example.EmployeeManagement.impl;

import com.example.EmployeeManagement.entity.JobDepartment;
import com.example.EmployeeManagement.entity.Salary;
import com.example.EmployeeManagement.payload.SalaryDto;
import com.example.EmployeeManagement.repository.JobDepartmentRepository;
import com.example.EmployeeManagement.repository.SalaryRepository;
import com.example.EmployeeManagement.service.SalaryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private  SalaryRepository salaryRepository;

    @Autowired
    private  JobDepartmentRepository jobDepartmentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SalaryDto saveSalary(long jobId, SalaryDto salaryDto) {
       JobDepartment jobDepartment = jobDepartmentRepository.findById(jobId)
               .orElseThrow(()->new RuntimeException("JobId is Not found"));
        Salary salary  = modelMapper.map(salaryDto, Salary.class);
       salary.setJobDepartment(jobDepartment);
        salaryRepository.save(salary);
        return modelMapper.map(salary,SalaryDto.class);
    }

    @Override
    public SalaryDto update(int salId, SalaryDto salaryDto) {
        Optional<Salary> salary = salaryRepository.findById(salId);
        if (salary.isEmpty()){
            throw new RuntimeException("Invalid Id"+salId);
        }
          Salary salary1 = modelMapper.map(salaryDto,Salary.class);
            salaryRepository.save(salary1);
            return modelMapper.map(salary1,SalaryDto.class);
    }

    @Override
    public List<SalaryDto> getAllData() {
      List<Salary> salary =  salaryRepository.findAll();
        return salary.stream()
                .map(details ->modelMapper.map(details,SalaryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int salId) {
        salaryRepository.deleteById(salId);
    }
}
