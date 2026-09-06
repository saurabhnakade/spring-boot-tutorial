package com.springboot.inception;

import com.springboot.inception.persistence.DepartmentRepository;
import com.springboot.inception.persistence.entities.DepartmentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InceptionApplicationTests {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void repositoryTest() {
		DepartmentEntity departmentEntity = new DepartmentEntity(null, "Engineering", true, null);
		departmentRepository.save(departmentEntity);
	}

}
