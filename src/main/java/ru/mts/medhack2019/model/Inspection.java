package ru.mts.medhack2019.model;


public class Inspection {
    private Long consultationId;
    private Long patientId;
    private Long doctorId;
    private String value;
    private String comment;
    private Boolean isNewReception;

    public Long getConsultationId() {
        return consultationId;
    }

    public Inspection setConsultationId(Long consultationId) {
        this.consultationId = consultationId;
        return this;
    }

    public Long getPatientId() {
        return patientId;
    }

    public Inspection setPatientId(Long patientId) {
        this.patientId = patientId;
        return this;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public Inspection setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Inspection setValue(String value) {
        this.value = value;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Inspection setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Boolean getNewReception() {
        return isNewReception;
    }

    public Inspection setNewReception(Boolean newReception) {
        isNewReception = newReception;
        return this;
    }
}
