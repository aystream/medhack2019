package ru.mts.medhack2019.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoctorDTO {

    private Long id;

    private UserDTO user;

    /**
     * Консультации доктора
     */
    private List<ConsultationDTO> consultations;

    public DoctorDTO() {
        this.consultations = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public DoctorDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public UserDTO getUser() {
        return user;
    }

    public DoctorDTO setUser(UserDTO user) {
        this.user = user;
        return this;
    }

    public List<ConsultationDTO> getConsultations() {
        return consultations;
    }

    public DoctorDTO setConsultations(List<ConsultationDTO> consultations) {
        this.consultations = consultations;
        return this;
    }
}
