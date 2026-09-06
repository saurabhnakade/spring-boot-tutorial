package com.springboot.inception.service.impl;

import com.springboot.inception.dto.DepartmentDTO;
import com.springboot.inception.exceptions.BadRequestException;
import com.springboot.inception.exceptions.ResourceNotFoundException;
import com.springboot.inception.persistence.DepartmentRepository;
import com.springboot.inception.persistence.entities.DepartmentEntity;
import com.springboot.inception.service.DepartmentService;
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
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<DepartmentDTO> getDepartments() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        return departmentEntities.stream()
                .filter(Objects::nonNull)
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class))
                .toList();
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
        DepartmentEntity departmentEntity = departmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Department with id " + id + " does not exist")
        );

        return modelMapper.map(departmentEntity, DepartmentDTO.class);
    }

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        if(departmentDTO == null) throw new BadRequestException("Department object cannot be null");

        departmentRepository.findByTitle(departmentDTO.getTitle()).ifPresent(
                dE -> {
                    throw new BadRequestException("Department with title " + departmentDTO.getTitle() + " already exists");
                }
        );

        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        DepartmentEntity departmentEntitySaved = departmentRepository.save(departmentEntity);
        return modelMapper.map(departmentEntitySaved, DepartmentDTO.class);
    }

    @Override
    public DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentDTO) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(id);
        if(departmentEntity.isEmpty()) throw new ResourceNotFoundException("Department with id " + id + " does not exist");;

        DepartmentEntity entityUpdates = modelMapper.map(departmentDTO, DepartmentEntity.class);
        entityUpdates.setId(id);
        entityUpdates.setCreatedAt(departmentEntity.get().getCreatedAt());
        DepartmentEntity departmentEntityUpdated = departmentRepository.save(entityUpdates);

        return modelMapper.map(departmentEntityUpdated, DepartmentDTO.class);
    }

    @Override
    public boolean deleteDepartment(Long id) {
        boolean exists = departmentRepository.existsById(id);
        if(!exists) throw new ResourceNotFoundException("Department with id " + id + " does not exist");

        departmentRepository.deleteById(id);
        return true;
    }

    @Override
    public DepartmentDTO patchDepartment(Long id, Map<String, Object> updates) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(id);
        if(departmentEntity.isEmpty()) throw new ResourceNotFoundException("Department with id " + id + " does not exist");;

        DepartmentEntity departmentEntityToUpdate = departmentEntity.get();
        updates.forEach((field, value)-> {
            Field fieldToBeUpdated = ReflectionUtils.findField(DepartmentEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, departmentEntityToUpdate, value);
        });

        DepartmentEntity departmentEntityUpdated = departmentRepository.save(departmentEntityToUpdate);
        return modelMapper.map(departmentEntityUpdated, DepartmentDTO.class);
    }
}
