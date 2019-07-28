package ru.mts.medhack2019.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mts.medhack2019.dto.ConsultationDTO;
import ru.mts.medhack2019.model.Consultation;
import ru.mts.medhack2019.repository.ConsultationRepository;
import ru.mts.medhack2019.service.ConsultationService;
import ru.mts.medhack2019.service.DiseaseService;
import ru.mts.medhack2019.service.UserService;

import java.util.List;

@Service
public class ConsultationServiceImpl implements ConsultationService {

    private ConsultationRepository consultationRepository;

    private UserService userService;
    private DiseaseService diseaseService;

    @Autowired
    public ConsultationServiceImpl(ConsultationRepository consultationRepository, UserService userService, DiseaseService diseaseService) {
        this.consultationRepository = consultationRepository;
        this.userService = userService;
        this.diseaseService = diseaseService;
    }

    @Override
    public List<Consultation> findAllByPatientId(Long id) {
        return consultationRepository.findAllByPatientId(id);
    }

    @Override
    public List<Consultation> findAllByDoctorId(Long id) {
        return consultationRepository.findAllByDoctorId(id);
    }

    @Override
    public Consultation create(ConsultationDTO consultationDTO) {
        Consultation consultation = consultationRepository.findById(consultationDTO.getId() != null ? consultationDTO.getId() : -1L)
                .orElseGet(Consultation::new);
        consultation.setPatient(userService.findById(consultationDTO.getPatientId()))
                .setDoctor(userService.findById(consultationDTO.getDoctorId()))
                .setDisease(diseaseService.findById(consultationDTO.getDisease().getId()))
                .setReceptionStatus(consultationDTO.getReceptionStatus())
                .setStatus(consultationDTO.getStatus())
                .setActive(true);
        return consultationRepository.save(consultation);
    }
}
