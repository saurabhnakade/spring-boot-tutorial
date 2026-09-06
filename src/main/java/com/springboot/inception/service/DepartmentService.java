package com.springboot.inception.service;

import com.springboot.inception.dto.DepartmentDTO;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    List<DepartmentDTO> getDepartments();

    DepartmentDTO getDepartmentById(Long id);

    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);

    DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentDTO);

    boolean deleteDepartment(Long id);

    DepartmentDTO patchDepartment(Long id, Map<String, Object> updates);
}
