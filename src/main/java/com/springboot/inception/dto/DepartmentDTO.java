package com.springboot.inception.dto;

import com.springboot.inception.annotations.CreatedAtValidation;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    @NotBlank(message = "Title cannot be blank")
    private String title;
    private Boolean isActive;
    @CreatedAtValidation
    private LocalDateTime createdAt;
}
