package com.springboot.inception.persistence.entities.hospital;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Table(
        name = "insurances",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"policyNumber"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @Column(nullable = false)
    private String policyNumber;

    @Column(nullable = false)
    private String provider;

    @Column(nullable = false)
    private LocalDate validUntil;

}
