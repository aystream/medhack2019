package ru.mts.medhack2019.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String userName;

    private String email;


    private PatientDTO patient;

    private DoctorDTO doctor;

    public Long getId() {
        return id;
    }

    public UserDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserDTO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public UserDTO setPatient(PatientDTO patient) {
        this.patient = patient;
        return this;
    }

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public UserDTO setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
        return this;
    }
}
