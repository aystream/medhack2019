package ru.mts.medhack2019.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsultationDTO {

    private Long id;

    private String status;

    /**
     * Диагноз
     */
    private DiseaseDTO disease;

    private UserDTO doctor;

    private UserDTO patient;

    private Long doctorId;

    private Long patientId;

    private String receptionStatus;

    private boolean isActive;

    public Long getId() {
        return id;
    }

    public ConsultationDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public ConsultationDTO setStatus(String status) {
        this.status = status;
        return this;
    }

    public DiseaseDTO getDisease() {
        return disease;
    }

    public ConsultationDTO setDisease(DiseaseDTO disease) {
        this.disease = disease;
        return this;
    }

    public Long getPatientId() {
        return patientId;
    }

    public ConsultationDTO setPatientId(Long patientId) {
        this.patientId = patientId;
        return this;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public ConsultationDTO setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
        return this;
    }

    public UserDTO getDoctor() {
        return doctor;
    }

    public ConsultationDTO setDoctor(UserDTO doctor) {
        this.doctor = doctor;
        return this;
    }

    public UserDTO getPatient() {
        return patient;
    }

    public ConsultationDTO setPatient(UserDTO patient) {
        this.patient = patient;
        return this;
    }

    public String getReceptionStatus() {
        return receptionStatus;
    }

    public ConsultationDTO setReceptionStatus(String receptionStatus) {
        this.receptionStatus = receptionStatus;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public ConsultationDTO setActive(boolean active) {
        isActive = active;
        return this;
    }
}
