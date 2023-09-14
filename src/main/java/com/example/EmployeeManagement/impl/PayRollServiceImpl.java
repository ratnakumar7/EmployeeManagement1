package com.example.EmployeeManagement.impl;

import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.entity.JobDepartment;
import com.example.EmployeeManagement.entity.PayRoll;
import com.example.EmployeeManagement.entity.Salary;
import com.example.EmployeeManagement.payload.PayRollDto;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import com.example.EmployeeManagement.repository.JobDepartmentRepository;
import com.example.EmployeeManagement.repository.PayRollRepository;
import com.example.EmployeeManagement.repository.SalaryRepository;
import com.example.EmployeeManagement.service.PayRollService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PayRollServiceImpl implements PayRollService {

    @Autowired
    private  PayRollRepository payRollRepository;
    @Autowired
    private  EmployeeRepository employeeRepository;
    @Autowired
    private  JobDepartmentRepository jobDepartmentRepository;
    @Autowired
    private  SalaryRepository salaryRepository;
    @Autowired
   private ModelMapper modelMapper;

    @Override
    public PayRollDto save(int empId, long jobId, int salId, PayRollDto payRollDto) {
        Employee employee = employeeRepository.findById(empId).get();
        JobDepartment jobDepartment = jobDepartmentRepository.findById(jobId).get();
        Salary salary = salaryRepository.findById(salId).get();
        PayRoll payRoll = modelMapper.map(payRollDto, PayRoll.class);
        payRoll.setEmployee(employee);
        payRoll.setJobDepartment(jobDepartment);
        payRoll.setSalary(salary);
        payRollRepository.save(payRoll);
        return modelMapper.map(payRoll, PayRollDto.class);
    }

    @Override
    public PayRollDto getById(int payroll_id) {
        Optional<PayRoll> payRoll = payRollRepository.findById(payroll_id);
        if (payRoll.isEmpty()) {
            throw new RuntimeException("User does not exits");
        }
        return modelMapper.map(payRoll, PayRollDto.class);
    }

    @Override
    public PayRollDto updateData(int payroll_id, PayRollDto payRollDto) {
        Optional<PayRoll> payRoll = payRollRepository.findById(payroll_id);
        if (payRoll.isEmpty()) {
            throw new RuntimeException("Invalid PayrollId or PayrollId does not Exits");
        }
        PayRoll payRoll1 = modelMapper.map(payRollDto,PayRoll.class);
        payRollRepository.save(payRoll1);
        return modelMapper.map(payRoll1,PayRollDto.class);
    }

    @Override
    public void delete(int payroll_id) {
        payRollRepository.deleteById(payroll_id);
    }

    @Override
    public List<PayRollDto> getAll() {
        List<PayRoll> payRolls = payRollRepository.findAll();
        return payRolls.stream()
                .map(details->modelMapper.map(details, PayRollDto.class))
                .collect(Collectors.toList());
    }
}
