package ru.mts.medhack2019.service;

import ru.mts.medhack2019.dto.ConsultationDTO;
import ru.mts.medhack2019.model.Consultation;

import java.util.List;

public interface ConsultationService {
    List<Consultation> findAllByPatientId(Long id);

    List<Consultation> findAllByDoctorId(Long id);

    Consultation create(ConsultationDTO consultationDTO);
}
