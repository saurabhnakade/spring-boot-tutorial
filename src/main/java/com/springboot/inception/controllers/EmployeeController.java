package com.springboot.inception.controllers;

import com.springboot.inception.dto.EmployeeDTO;
import com.springboot.inception.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<Page<EmployeeDTO>> getEmployeesSortedAndPaginated(@RequestParam(required = false, defaultValue = "id") String sortBy,
                                                          @RequestParam(required = false, defaultValue = "0") Integer pageNumber,
                                                          @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(employeeService.getEmployees(sortBy, pageNumber, pageSize));
    }

    @GetMapping("/age-greater-than/{employeeAge}")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesWithAgeGreaterThan(@PathVariable(name = "employeeAge") Integer age) {
        return ResponseEntity.ok(employeeService.getEmployeesWithAgeGreaterThan(age));
    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employeeDTO));
    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable(name = "employeeId") Long id, @RequestBody @Valid EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employeeDTO));
    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable(name = "employeeId") Long id) {
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }

    @PatchMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> patchEmployee(@PathVariable(name = "employeeId") Long id, @RequestBody Map<String, Object> updates) {
        return ResponseEntity.ok(employeeService.patchEmployee(id, updates));
    }
}
