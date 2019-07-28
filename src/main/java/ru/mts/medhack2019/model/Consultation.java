package ru.mts.medhack2019.model;

import javax.persistence.*;

@Entity
@Table(name = "consultation")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consultation_seq")
    @SequenceGenerator(name = "consultation_seq", sequenceName = "consultation_seq", allocationSize = 1)
    private Long id;

    // TODO потом когда нибудь поправить это
    private String status;

    /**
     * Диагноз
     */
    @OneToOne
    @JoinColumn(name = "disease_id")
    private Disease disease;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private User doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private User patient;


    /**
     * Вид приема( повторный, консультация)
     */
    @Column(name = "reception_status")
    private String receptionStatus;

    /**
     * Консультация уже прошла или нет
     */
    @Column(name = "is_active")
    private boolean isActive;


    public Long getId() {
        return id;
    }

    public Consultation setId(Long id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Consultation setStatus(String status) {
        this.status = status;
        return this;
    }

    public Disease getDisease() {
        return disease;
    }

    public Consultation setDisease(Disease disease) {
        this.disease = disease;
        return this;
    }

    public User getDoctor() {
        return doctor;
    }

    public Consultation setDoctor(User doctor) {
        this.doctor = doctor;
        return this;
    }

    public User getPatient() {
        return patient;
    }

    public Consultation setPatient(User patient) {
        this.patient = patient;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public Consultation setActive(boolean active) {
        isActive = active;
        return this;
    }

    public String getReceptionStatus() {
        return receptionStatus;
    }

    public Consultation setReceptionStatus(String receptionStatus) {
        this.receptionStatus = receptionStatus;
        return this;
    }
}
