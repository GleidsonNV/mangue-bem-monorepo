package br.uneb.dcet.si20192.tees.manguebemapi.entity;

import br.uneb.dcet.si20192.tees.manguebemapi.entity.base.BaseEntity;
import br.uneb.dcet.si20192.tees.manguebemapi.entity.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "users")
@Entity
@Getter
@Setter
public class User extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String encryptedPassword;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
