package com.springboot.inception.persistence.entities.hospital;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Table(
        name = "medical_departments",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"name"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalDepartmentEntity extends AuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @Column(nullable = false)
    private String name;
}
