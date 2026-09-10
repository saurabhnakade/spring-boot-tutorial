package com.springboot.inception.persistence.entities.hospital;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "appointments",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"appointment_time"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    private String reason;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    // This is the owning side of relationship
    // nullable = false , creates a not nullable constraint on this column , so we cannot have appointment without a patient linked to it
    private PatientEntity patientEntity;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    // This is the owning side of relationship
    private DoctorEntity doctorEntity;

}
