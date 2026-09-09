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
                @UniqueConstraint(columnNames = {"appointmentTime"})
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

}
