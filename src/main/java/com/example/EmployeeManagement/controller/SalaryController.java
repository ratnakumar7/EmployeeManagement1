package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.payload.SalaryDto;
import com.example.EmployeeManagement.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("salary")
public class SalaryController {

        @Autowired
        private SalaryService salaryService;

        @PostMapping("/{jobId}/save")
        public SalaryDto saveData(@PathVariable("jobId") int jobId,@RequestBody SalaryDto salaryDto){
            return salaryService.saveSalary(jobId,salaryDto);
        }

        @GetMapping("/getAll")
        public List<SalaryDto> getAll(){
            return salaryService.getAllData();
        }

        @PutMapping("/{salId}/salaryData")
        public SalaryDto update(@PathVariable("salId") int salId,@RequestBody SalaryDto salaryDto){
            return salaryService.update(salId,salaryDto);
        }

        @DeleteMapping("/{salId}")
        public void delete(@PathVariable("salId") int salId){
            salaryService.delete(salId);
        }

}
