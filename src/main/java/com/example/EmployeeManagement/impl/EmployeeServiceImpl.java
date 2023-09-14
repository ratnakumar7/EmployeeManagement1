package com.example.EmployeeManagement.impl;

import com.example.EmployeeManagement.entity.Employee;
import com.example.EmployeeManagement.exception.EmployeeNotFound;
import com.example.EmployeeManagement.payload.EmployeeDto;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import com.example.EmployeeManagement.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto saveEmpData(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employeeRepository.save(employee);
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAllDetails() {
        List<Employee> list = employeeRepository.findAll();
        return list.stream()
                .map(details->modelMapper.map(details, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getById(Integer empId) {
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new EmployeeNotFound("employee " + empId + " is not found "));
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateData(Integer empId, EmployeeDto employeeDto) {
        Optional<Employee> employee = employeeRepository.findById(empId);

        if (employee.isEmpty()){
            throw new RuntimeException("Employee" + empId + " is not found ");
        }
           Employee employee1 =  modelMapper.map(employeeDto,Employee.class);
            employeeRepository.save(employee1);
            return modelMapper.map(employee1, EmployeeDto.class);
    }

    @Override
    public void delete(Integer empId) {
        employeeRepository.deleteById(empId);
    }

    @Override
    public List<EmployeeDto> findEmployeeName(String name) {
        List<Employee> employee = employeeRepository.findByFirstName(name);
        return employee.stream()
                .map(details-> modelMapper.map(details,EmployeeDto.class))
                .collect(Collectors.toList());
    }

}
