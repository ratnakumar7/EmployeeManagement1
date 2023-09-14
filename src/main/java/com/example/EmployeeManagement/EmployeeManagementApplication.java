package com.example.EmployeeManagement;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class EmployeeManagementApplication {
	private static final ModelMapper modelMapper = new ModelMapper();

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}
	//This is used to convert one class object to another class object with the help of map()
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
