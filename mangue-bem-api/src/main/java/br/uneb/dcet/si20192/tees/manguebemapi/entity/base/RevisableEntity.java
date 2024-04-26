package br.uneb.dcet.si20192.tees.manguebemapi.entity.base;

import br.uneb.dcet.si20192.tees.manguebemapi.entity.User;
import br.uneb.dcet.si20192.tees.manguebemapi.entity.enums.ApprovalStatus;
import jakarta.persistence.*;

@MappedSuperclass
public class RevisableEntity extends BaseEntity {

    public RevisableEntity() {
        this.approvalStatus = ApprovalStatus.PENDING;
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    protected ApprovalStatus approvalStatus;

    @OneToMany
    @JoinColumn
    protected User revisedBy;
}
