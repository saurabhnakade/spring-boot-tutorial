package com.springboot.inception.persistence.entities.hospital;

import com.springboot.inception.enums.BloodGroup;
import com.springboot.inception.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Table(
        name = "patients",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"name", "gender", "bloodGroup", "birthDate"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    @OneToOne
    @JoinColumn(name = "insurance_id")
    // This side has JoinColumn , so it is the relationship owning side
    // By default, the column name is set as insurance_entity(name of entity in this class) + _ + id (id of insurance)
    // When we use a one to one mapping , automatically a UQ is created for this field by hibernate
    private InsuranceEntity insuranceEntity;

}
