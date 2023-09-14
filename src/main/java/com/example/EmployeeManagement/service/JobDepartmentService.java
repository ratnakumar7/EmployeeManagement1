package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.payload.JobDepartmentDto;

import java.util.List;

public interface JobDepartmentService {

    public JobDepartmentDto jobData(JobDepartmentDto jobDepartmentDto);

    public List<JobDepartmentDto> getAllJob();

    public JobDepartmentDto getOneJob(Long jobId);

    public JobDepartmentDto update(Long jobId,JobDepartmentDto jobDepartmentDto);

    public void deleteJob(Long jobId);

}
