package com.springboot.inception.service;

import com.springboot.inception.dto.EmployeeDTO;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<EmployeeDTO> getEmployees(Integer age);

    EmployeeDTO getEmployeeById(Long id);

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);

    boolean deleteEmployee(Long id);

    EmployeeDTO patchEmployee(Long id, Map<String, Object> updates);

    List<EmployeeDTO> getEmployeesWithAgeGreaterThan(Integer age);
}
