package br.uneb.dcet.si20192.tees.manguebemapi.entity;

import br.uneb.dcet.si20192.tees.manguebemapi.entity.base.RevisableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "species")
@Entity
@Getter
@Setter
public class Specie extends RevisableEntity {

    @Column(nullable = false)
    private String popularName;

    @Column(nullable = false)
    private String description;

}