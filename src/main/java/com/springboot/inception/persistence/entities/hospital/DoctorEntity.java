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
        name = "doctors"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @Column(nullable = false)
    private String name;

    private String specialization;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "doctorEntity")
    private Set<AppointmentEntity> appointmentEntitySet = new HashSet<>();

}
