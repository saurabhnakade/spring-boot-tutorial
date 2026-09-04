package com.springboot.inception.mappers;

import com.springboot.inception.dto.EmployeeDTO;
import com.springboot.inception.persistence.entities.EmployeeEntity;

public class EmployeeMapper {

    public static EmployeeDTO employeeEntityToEmployeeDTO(EmployeeEntity employee) {
        if (employee == null) {
            return null;
        }
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setAge(employee.getAge());
        employeeDTO.setDateOfBirth(employee.getDateOfBirth());
        employeeDTO.setIsActive(employee.getIsActive());
        return employeeDTO;
    }

    public static EmployeeEntity employeeDTOToEmployeeEntity(EmployeeDTO employeeDTO) {
        if (employeeDTO == null) {
            return null;
        }
        EmployeeEntity employee = new EmployeeEntity();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setAge(employeeDTO.getAge());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setIsActive(employeeDTO.getIsActive());
        return employee;
    }
}
