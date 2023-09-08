package org.example.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<Customer> customers = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
