package com.springboot.inception.dto;

import com.springboot.inception.annotations.IsActiveValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    private String name;

    @Min(value = 18, message = "Age cannot be less than 18")
    @Max(value = 60, message = "Age cannot be greater than 60")
    private Integer age;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @IsActiveValidation
    private Boolean isActive;
}
