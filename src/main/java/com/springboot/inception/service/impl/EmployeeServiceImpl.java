package com.springboot.inception.service.impl;

import com.springboot.inception.dto.EmployeeDTO;
import com.springboot.inception.mappers.EmployeeMapper;
import com.springboot.inception.persistence.EmployeeRepository;
import com.springboot.inception.persistence.entities.EmployeeEntity;
import com.springboot.inception.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> getEmployees(Integer age) {
        List<EmployeeEntity> employeeEntities = employeeRepository.findByAge(age);
        return employeeEntities.stream()
                .map(EmployeeMapper::employeeEntityToEmployeeDTO)
                .toList();
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        return EmployeeMapper.employeeEntityToEmployeeDTO(employeeEntity);
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = EmployeeMapper.employeeDTOToEmployeeEntity(employeeDTO);
        EmployeeEntity employeeEntitySaved = employeeRepository.save(employeeEntity);
        return EmployeeMapper.employeeEntityToEmployeeDTO(employeeEntitySaved);
    }
}
