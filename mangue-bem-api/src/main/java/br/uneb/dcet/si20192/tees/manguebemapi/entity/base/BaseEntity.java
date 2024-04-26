package br.uneb.dcet.si20192.tees.manguebemapi.entity.base;

import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {
    protected Long id;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
    protected boolean deleted;
}
