package com.springboot.inception.controllers;

import com.springboot.inception.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @GetMapping
    public List<EmployeeDTO> getEmployees(@RequestParam(required = false, defaultValue = "18") Integer age) {
        return List.of(
                new EmployeeDTO(1L, "John Doe", age, LocalDate.of(2001, 9, 23), true),
                new EmployeeDTO(2L, "Jane Smith", age, LocalDate.of(1995, 5, 15), false)
        );
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return new EmployeeDTO(id, "John Doe", 30, LocalDate.of(2001, 9, 23), true);
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeDTO;
    }
}
