package ru.mts.medhack2019.dto;

import java.util.ArrayList;
import java.util.List;

public class PatientDTO {

    private Long id;

    private UserDTO user;

    private List<ConsultationDTO> consultations;


    public PatientDTO() {
        this.consultations = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public PatientDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public UserDTO getUser() {
        return user;
    }

    public PatientDTO setUser(UserDTO user) {
        this.user = user;
        return this;
    }

    public List<ConsultationDTO> getConsultations() {
        return consultations;
    }

    public PatientDTO setConsultations(List<ConsultationDTO> consultations) {
        this.consultations = consultations;
        return this;
    }
}
