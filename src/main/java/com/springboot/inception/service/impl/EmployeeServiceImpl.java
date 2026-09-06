package com.springboot.inception.service.impl;

import com.springboot.inception.dto.EmployeeDTO;
import com.springboot.inception.exceptions.BadRequestException;
import com.springboot.inception.exceptions.ResourceNotFoundException;
import com.springboot.inception.persistence.EmployeeRepository;
import com.springboot.inception.persistence.entities.EmployeeEntity;
import com.springboot.inception.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
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
    public List<EmployeeDTO> getEmployees(String sortBy) {
        Sort sort = Sort.by(Sort.Direction.ASC, sortBy);

        List<EmployeeEntity> employeeEntities = employeeRepository.findBy(sort);
        return employeeEntities.stream()
                .filter(Objects::nonNull)
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .toList();
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee with id " + id + " does not exist")
        );

        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        if (employeeDTO == null) throw new BadRequestException("Employee object cannot be null");

        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        EmployeeEntity employeeEntitySaved = employeeRepository.save(employeeEntity);
        return modelMapper.map(employeeEntitySaved, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        if (employeeEntity.isEmpty()) throw new ResourceNotFoundException("Employee with id " + id + " does not exist");

        EmployeeEntity entityUpdates = modelMapper.map(employeeDTO, EmployeeEntity.class);
        entityUpdates.setId(id);
        EmployeeEntity employeeEntityUpdated = employeeRepository.save(entityUpdates);

        return modelMapper.map(employeeEntityUpdated, EmployeeDTO.class);
    }

    @Override
    public boolean deleteEmployee(Long id) {
        boolean exists = employeeRepository.existsById(id);
        if (!exists) throw new ResourceNotFoundException("Employee with id " + id + " does not exist");

        employeeRepository.deleteById(id);
        return true;
    }

    @Override
    public EmployeeDTO patchEmployee(Long id, Map<String, Object> updates) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        if (employeeEntity.isEmpty()) throw new ResourceNotFoundException("Employee with id " + id + " does not exist");

        EmployeeEntity employeeEntityToUpdate = employeeEntity.get();
        updates.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, employeeEntityToUpdate, value);
        });

        EmployeeEntity employeeEntityUpdated = employeeRepository.save(employeeEntityToUpdate);
        return modelMapper.map(employeeEntityUpdated, EmployeeDTO.class);
    }

    @Override
    public List<EmployeeDTO> getEmployeesWithAgeGreaterThan(Integer age) {
        return employeeRepository.findByAgeGreaterThanEqual(age)
                .stream()
                .filter(Objects::nonNull)
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .toList();
    }
}
