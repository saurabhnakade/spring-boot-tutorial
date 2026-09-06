package com.springboot.inception.persistence;

import com.springboot.inception.persistence.entities.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    Page<EmployeeEntity> findBy(Pageable pageable);

    List<EmployeeEntity> findByAge(Integer age);

    List<EmployeeEntity> findByAgeGreaterThanEqual(Integer age);
}
