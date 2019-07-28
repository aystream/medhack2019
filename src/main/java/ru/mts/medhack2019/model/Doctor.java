package ru.mts.medhack2019.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_seq")
    @SequenceGenerator(name = "doctor_seq", sequenceName = "doctor_seq", allocationSize = 1)
    private Long id;

    @OneToOne
    private User user;

    /**
     * Консультации доктора
     */
    @OneToMany(mappedBy = "doctor", orphanRemoval = true)
    private List<Consultation> consultations;

    public Doctor() {
        this.consultations = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public Doctor setId(Long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Doctor setUser(User user) {
        this.user = user;
        return this;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public Doctor setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
        return this;
    }
}
