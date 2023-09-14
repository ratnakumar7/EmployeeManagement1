package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.payload.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    public EmployeeDto saveEmpData(EmployeeDto employeeDto);
    public List<EmployeeDto> getAllDetails();
    public EmployeeDto getById(Integer empId);
    public EmployeeDto updateData(Integer empId,EmployeeDto employeeDto);
    public void delete(Integer empId);
    public List<EmployeeDto> findEmployeeName(String name);

}
