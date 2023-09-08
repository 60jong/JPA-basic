package org.example.domain.mapping;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
