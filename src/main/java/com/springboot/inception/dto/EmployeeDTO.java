package com.springboot.inception.dto;

import java.time.LocalDate;

public class EmployeeDTO {

    private Long id;
    private String name;
    private Integer age;
    private LocalDate dateOfBirth;
    private Boolean isActive;

    public EmployeeDTO() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Boolean getActive() {
        return isActive;
    }

    public EmployeeDTO(Long id, String name, Integer age, LocalDate dateOfBirth, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.isActive = isActive;
    }
}
