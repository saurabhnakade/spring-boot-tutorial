package com.springboot.inception.controllers;

import com.springboot.inception.dto.EmployeeDTO;
import com.springboot.inception.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getEmployees(@RequestParam(required = false, defaultValue = "18") Integer age) {
        return employeeService.getEmployees(age);
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    @PutMapping(path = "/{employeeId}")
    public EmployeeDTO updateEmployee(@PathVariable(name = "employeeId") Long id, @RequestBody @Valid EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping(path = "/{employeeId}")
    public boolean deleteEmployee(@PathVariable(name = "employeeId") Long id) {
        return employeeService.deleteEmployee(id);
    }

    @PatchMapping(path = "/{employeeId}")
    public EmployeeDTO patchEmployee(@PathVariable(name = "employeeId") Long id, @RequestBody Map<String, Object> updates) {
        return employeeService.patchEmployee(id, updates);
    }
}
