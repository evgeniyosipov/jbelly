package ru.evgeniyosipov.jbelly.entity;

import javax.persistence.*;

/**
 * Created by Evgeniy Osipov on 15.04.2017.
 */
@Entity
@Table(name = "roles")
public class Role {
    private Integer id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
