package com.springboot.inception.service.impl;

import com.springboot.inception.dto.EmployeeDTO;
import com.springboot.inception.mappers.EmployeeMapper;
import com.springboot.inception.persistence.EmployeeRepository;
import com.springboot.inception.persistence.entities.EmployeeEntity;
import com.springboot.inception.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

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

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        if(employeeEntity.isEmpty()) return null;

        EmployeeEntity entityUpdates = modelMapper.map(employeeDTO, EmployeeEntity.class);
        entityUpdates.setId(id);
        EmployeeEntity employeeEntityUpdated = employeeRepository.save(entityUpdates);

        return modelMapper.map(employeeEntityUpdated, EmployeeDTO.class);
    }

    @Override
    public boolean deleteEmployee(Long id) {
        boolean exists = employeeRepository.existsById(id);
        if(!exists) return false;

        employeeRepository.deleteById(id);
        return true;
    }

    @Override
    public EmployeeDTO patchEmployee(Long id, Map<String, Object> updates) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        if(employeeEntity.isEmpty()) return null;

        EmployeeEntity employeeEntityToUpdate = employeeEntity.get();
        updates.forEach((field, value)-> {
            Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, employeeEntityToUpdate, value);
        });

        EmployeeEntity employeeEntityUpdated = employeeRepository.save(employeeEntityToUpdate);
        return modelMapper.map(employeeEntityUpdated, EmployeeDTO.class);
    }
}
