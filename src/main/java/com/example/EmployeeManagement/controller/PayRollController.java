package com.example.EmployeeManagement.controller;


import com.example.EmployeeManagement.payload.PayRollDto;
import com.example.EmployeeManagement.service.PayRollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pay")
public class PayRollController {

    @Autowired
    private  PayRollService payRollService;

    @PostMapping("/{empId}/{jobId}/{salId}/save")//save
    public PayRollDto saveDetails(@PathVariable("empId") int empId,
                                  @PathVariable("jobId") int jobId,
                                  @PathVariable("salId") int salId,
                                  @RequestBody PayRollDto payRollDto){
        return payRollService.save( empId, jobId, salId,payRollDto);
    }
    @GetMapping("/fetchAll")
    public List<PayRollDto> getAllDetails(){
        return payRollService.getAll();
    }
    @GetMapping("/{empId}")
    public PayRollDto getSingleData(@PathVariable("empId") Integer empId){
        return payRollService.getById(empId);
    }
    @PutMapping("/update/{empId}")
    public PayRollDto updateData(@PathVariable("empId") int empId, @RequestBody PayRollDto payRollDto){
        return payRollService.updateData(empId,payRollDto);
    }
    @DeleteMapping("/{empId}")
    public void deleteRecord(@PathVariable("empId")Integer empId){
        payRollService.delete(empId);
    }

}
