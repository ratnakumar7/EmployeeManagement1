package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.payload.EmployeeDto;
import com.example.EmployeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/save")//save
    public EmployeeDto saveDetails(@RequestBody EmployeeDto employeeDto){
         return employeeService.saveEmpData(employeeDto);
    }
    @GetMapping("/fetchAll")
    public List<EmployeeDto> getAllDetails(){
        return employeeService.getAllDetails();
    }
    @GetMapping("/{empId}")
    public EmployeeDto getSingleData(@PathVariable("empId") Integer empId){
        return employeeService.getById(empId);
    }
    @PutMapping("/{empId}/update")
    public EmployeeDto updateData(@PathVariable("empId") Integer empId, @RequestBody EmployeeDto employeeDto){
        return employeeService.updateData(empId,employeeDto);
    }
    @DeleteMapping("/{empId}")
    public void deleteRecord(@PathVariable("empId")Integer empId){
        employeeService.delete(empId);
    }
    @GetMapping("/name/{empName}")
    public List<EmployeeDto> findByEmpName(@PathVariable("empName") String name){
        return employeeService.findEmployeeName(name);
    }
}
