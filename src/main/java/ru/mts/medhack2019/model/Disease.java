package ru.mts.medhack2019.model;


import javax.persistence.*;

/**
 * Заболевание
 */
@Entity
@Table(name = "disease")
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disease_seq")
    @SequenceGenerator(name = "disease_seq", sequenceName = "disease_seq", allocationSize = 1)
    private Long id;

    private String name;

    private String description;

    public Long getId() {
        return id;
    }

    public Disease setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Disease setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Disease setDescription(String description) {
        this.description = description;
        return this;
    }
}
