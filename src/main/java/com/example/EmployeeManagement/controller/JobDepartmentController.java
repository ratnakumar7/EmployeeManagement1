package com.example.EmployeeManagement.controller;

import com.example.EmployeeManagement.payload.JobDepartmentDto;
import com.example.EmployeeManagement.service.JobDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job")
public class JobDepartmentController {

    @Autowired
    private JobDepartmentService jobDepartmentService;

    @PostMapping("/add")
    public JobDepartmentDto jobData(@RequestBody JobDepartmentDto jobDepartmentDto) {
        return jobDepartmentService.jobData(jobDepartmentDto);
    }

    @GetMapping("/getAll")
    public List<JobDepartmentDto> getAll(){
        return jobDepartmentService.getAllJob();
    }

    @GetMapping("/{jobId}")
    public JobDepartmentDto getOne(@PathVariable("jobId") Long jobId){
        return jobDepartmentService.getOneJob(jobId);
    }

    @PutMapping("/{jobId}")
    public JobDepartmentDto updateData(@PathVariable("jobId") Long jobId,@RequestBody JobDepartmentDto jobDepartmentDto){
        return jobDepartmentService.update(jobId,jobDepartmentDto);
    }

    @DeleteMapping("/{jobId}")
    public void delete(@PathVariable("jobId") Long jobId){
        jobDepartmentService.deleteJob(jobId);
    }
}
