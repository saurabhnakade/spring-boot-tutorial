package com.springboot.inception.controllers;

import com.springboot.inception.dto.EmployeeDTO;
import com.springboot.inception.mappers.EmployeeMapper;
import com.springboot.inception.persistence.EmployeeRepository;
import com.springboot.inception.persistence.entities.EmployeeEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<EmployeeDTO> getEmployees(@RequestParam(required = false, defaultValue = "18") Integer age) {
        List<EmployeeEntity> employeeEntities = employeeRepository.findByAge(age);
        return employeeEntities.stream()
                .map(EmployeeMapper::employeeEntityToEmployeeDTO)
                .toList();
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        return EmployeeMapper.employeeEntityToEmployeeDTO(employeeEntity);
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = EmployeeMapper.employeeDTOToEmployeeEntity(employeeDTO);
        EmployeeEntity employeeEntitySaved = employeeRepository.save(employeeEntity);
        return EmployeeMapper.employeeEntityToEmployeeDTO(employeeEntitySaved);
    }
}
