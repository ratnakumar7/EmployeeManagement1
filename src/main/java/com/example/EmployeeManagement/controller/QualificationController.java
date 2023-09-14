package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.payload.QualificationDto;
import com.example.EmployeeManagement.service.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("qualification")
public class QualificationController {

    @Autowired
    private QualificationService qualificationService;
    @PostMapping("/{empId}/save")
    public QualificationDto saveData(@PathVariable("empId") int empId, @RequestBody QualificationDto qualificationDto){
        return qualificationService.saveQualification(empId,qualificationDto);
    }
    @GetMapping("/getAll/qualifications")
    public List<QualificationDto> getAll(){
      return qualificationService.getAllQualificationDetails();
    }
    @PutMapping("/{qualificationId}/updateData")
    public QualificationDto updateQualificationData(@PathVariable("qualificationId") int qualificationId, @RequestBody QualificationDto qualificationDto){
      return qualificationService.updateQualification(qualificationId,qualificationDto);
    }
    @DeleteMapping("/delete")
    public void delete(int qualificationId){
        qualificationService.delete(qualificationId);
    }
}
