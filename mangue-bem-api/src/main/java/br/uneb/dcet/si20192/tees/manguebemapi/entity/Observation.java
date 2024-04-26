package br.uneb.dcet.si20192.tees.manguebemapi.entity;

import br.uneb.dcet.si20192.tees.manguebemapi.entity.base.RevisableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "observations")
@Entity
@Getter
@Setter
public class Observation extends RevisableEntity {

    @OneToMany
    @JoinColumn(name = "specie_id")
    private Specie specie;

    @Column(name = "city_ibge_id", nullable = false)
    private String cityIBGEId;

    @Column(name = "state_ibge_id", nullable = false)
    private String stateIBGEId;


}
