package ru.mts.medhack2019.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;

    private String email;

    @Nullable
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Patient patient;

    @Nullable
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Doctor doctor;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    @Nullable
    public Patient getPatient() {
        return patient;
    }

    public User setPatient(@Nullable Patient patient) {
        this.patient = patient;
        return this;
    }

    @Nullable
    public Doctor getDoctor() {
        return doctor;
    }

    public User setDoctor(@Nullable Doctor doctor) {
        this.doctor = doctor;
        return this;
    }
}
