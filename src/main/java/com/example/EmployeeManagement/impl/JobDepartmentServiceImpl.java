package com.example.EmployeeManagement.impl;

import com.example.EmployeeManagement.entity.JobDepartment;
import com.example.EmployeeManagement.payload.JobDepartmentDto;
import com.example.EmployeeManagement.repository.JobDepartmentRepository;
import com.example.EmployeeManagement.service.JobDepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobDepartmentServiceImpl implements JobDepartmentService {
    
    @Autowired
    private JobDepartmentRepository jobDepartmentRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public JobDepartmentDto jobData(JobDepartmentDto jobDepartmentDto) {
        JobDepartment jobDepartment = modelMapper.map(jobDepartmentDto, JobDepartment.class);
           JobDepartment jobDepartment1 =  jobDepartmentRepository.save(jobDepartment);
        return modelMapper.map(jobDepartment1,JobDepartmentDto.class);
    }
    @Override
    public List<JobDepartmentDto> getAllJob() {
        List<JobDepartment> jd = jobDepartmentRepository.findAll();
        return jd.stream()
            .map(details -> modelMapper.map(details,JobDepartmentDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public JobDepartmentDto getOneJob(Long jobId) {
       JobDepartment jobDepartment = jobDepartmentRepository.findById(jobId)
            .orElseThrow(()->new RuntimeException("The JobDepartmentId "+jobId+" is not found "));
        return modelMapper.map(jobDepartment,JobDepartmentDto.class);
    }

    @Override
    public JobDepartmentDto update(Long jobId,JobDepartmentDto jobDepartmentDto) {
            Optional<JobDepartment> jobDepartment = jobDepartmentRepository.findById(jobId);
            if (jobDepartment.isEmpty()){
                throw new RuntimeException("Jod Id is not present");
            }
           JobDepartment jobDepartment1 =  modelMapper.map(jobDepartmentDto,JobDepartment.class);
            jobDepartmentRepository.save(jobDepartment1);
           return modelMapper.map(jobDepartment1,JobDepartmentDto.class);
    }

    @Override
    public void deleteJob(Long jobId) {
        jobDepartmentRepository.deleteById(jobId);
    }
}
