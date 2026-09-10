package com.springboot.inception.persistence.entities.hospital;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

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

    @Column(unique = true, nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "head_doctor_id", nullable = false)
    // This is the owning side of relationship
    private DoctorEntity headDoctorEntity;

    @ManyToMany
    @JoinTable(
            name = "department_doctor",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    private Set<DoctorEntity> doctorEntitySet = new HashSet<>();
}
