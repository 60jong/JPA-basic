package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member {

    @Id
    private Long id;
    private String name;

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Member() {

    }
}
