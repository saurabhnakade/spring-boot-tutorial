package com.springboot.inception.persistence.entities.hospital;

import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;

public class AuditEntity {

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
