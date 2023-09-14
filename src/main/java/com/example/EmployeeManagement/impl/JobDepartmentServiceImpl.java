package com.example.EmployeeManagement.impl;

import com.example.EmployeeManagement.entity.JobDepartment;
import com.example.EmployeeManagement.payload.JobDepartmentDto;
import com.example.EmployeeManagement.repository.JobDepartmentRepository;
import com.example.EmployeeManagement.service.JobDepartmentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobDepartmentServiceImpl implements JobDepartmentService {
    private final JobDepartmentRepository jobDepartmentRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    public JobDepartmentServiceImpl(JobDepartmentRepository jobDepartmentRepository) {
        this.jobDepartmentRepository = jobDepartmentRepository;
    }
    @Override
    public JobDepartmentDto jobData(JobDepartmentDto jobDepartmentDto) {
        JobDepartment jobDepartment = modelMapper.map(jobDepartmentDto, JobDepartment.class);
           JobDepartment jobDepartment1 =  jobDepartmentRepository.save(jobDepartment);
        return modelMapper.map(jobDepartment1,JobDepartmentDto.class);
    }
    @Override
    public List<JobDepartmentDto> getAllJob() {
        List<JobDepartment> jd = jobDepartmentRepository.findAll();
        return modelMapper.map(jd,new TypeToken<List<JobDepartmentDto>>(){}.getType());
    }

    @Override
    public JobDepartmentDto getOneJob(Long jobId) {
        jobDepartmentRepository.findById(jobId).orElseThrow(()->new RuntimeException(""));
        return null;
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
