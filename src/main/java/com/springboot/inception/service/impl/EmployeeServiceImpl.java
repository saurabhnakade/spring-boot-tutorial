package com.springboot.inception.service.impl;

import com.springboot.inception.dto.EmployeeDTO;
import com.springboot.inception.mappers.EmployeeMapper;
import com.springboot.inception.persistence.EmployeeRepository;
import com.springboot.inception.persistence.entities.EmployeeEntity;
import com.springboot.inception.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<EmployeeDTO> getEmployees(Integer age) {
        List<EmployeeEntity> employeeEntities = employeeRepository.findByAge(age);
        return employeeEntities.stream()
                .filter(Objects::nonNull)
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .toList();
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);

        if(employeeEntity == null) return null;

        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        if(employeeDTO == null) return null;

        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        EmployeeEntity employeeEntitySaved = employeeRepository.save(employeeEntity);
        return modelMapper.map(employeeEntitySaved, EmployeeDTO.class);
    }
}
