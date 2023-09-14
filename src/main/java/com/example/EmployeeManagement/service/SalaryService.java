package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.payload.SalaryDto;

import java.util.List;

public interface SalaryService {

    public SalaryDto saveSalary(long jobId,SalaryDto salaryDto);

    public SalaryDto update(int jobId,SalaryDto salaryDto);

    public List<SalaryDto> getAllData();

    public void delete(int salId);

}
