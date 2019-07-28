package ru.mts.medhack2019.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mts.medhack2019.dto.ConsultationDTO;
import ru.mts.medhack2019.service.ConsultationService;
import ru.mts.medhack2019.shared.mapper.ConsultationMapper;

import java.util.List;

@RestController
@RequestMapping("/api/consultations")
public class ConsultationController {
    private ConsultationService
            consultationService;

    private ConsultationMapper
            consultationMapper;

    @Autowired
    public ConsultationController(ConsultationService consultationService, ConsultationMapper consultationMapper) {
        this.consultationService = consultationService;
        this.consultationMapper = consultationMapper;
    }

    @GetMapping("/doctor/{id}")
    public List<ConsultationDTO> findAllByDoctorId(@PathVariable("id") Long id) {
        return consultationMapper.toListDTOs(consultationService.findAllByDoctorId(id));
    }

    @GetMapping("/patient/{id}")
    public List<ConsultationDTO> findAllByPatientId(@PathVariable("id") Long id) {
        return consultationMapper.toListDTOs(consultationService.findAllByPatientId(id));
    }

    @PostMapping
    public ConsultationDTO create(@RequestBody ConsultationDTO consultationDTO) {
        return consultationMapper.toDTO(consultationService.create(consultationDTO));
    }

}
