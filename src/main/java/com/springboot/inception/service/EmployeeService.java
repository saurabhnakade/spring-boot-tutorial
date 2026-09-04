package com.springboot.inception.service;

import com.springboot.inception.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getEmployees(Integer age);

    EmployeeDTO getEmployeeById(Long id);

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
}
