package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.payload.PayRollDto;

import java.util.List;

public interface PayRollService {

    public PayRollDto save(int empId,long jobId,int salId,PayRollDto payRollDto);

    public PayRollDto getById(int empId);

    public PayRollDto updateData(int empId, PayRollDto payRollDto);

     public void delete(int empId);

   public List<PayRollDto> getAll();
}
