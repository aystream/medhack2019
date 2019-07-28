package ru.mts.medhack2019.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_seq")
    @SequenceGenerator(name = "patient_seq", sequenceName = "patient_seq", allocationSize = 1)
    private Long id;

    @OneToOne
    private User user;

    /**
     * Консультации пользователя
     */
    @OneToMany(mappedBy = "patient", orphanRemoval = true)
    private List<Consultation> consultations;


    public Patient() {
        this.consultations = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public Patient setId(Long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Patient setUser(User user) {
        this.user = user;
        return this;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public Patient setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
        return this;
    }
}
