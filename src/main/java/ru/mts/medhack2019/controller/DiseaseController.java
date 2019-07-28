package ru.mts.medhack2019.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mts.medhack2019.dto.ConsultationDTO;
import ru.mts.medhack2019.dto.DiseaseDTO;
import ru.mts.medhack2019.dto.UserDTO;
import ru.mts.medhack2019.service.DiseaseService;
import ru.mts.medhack2019.shared.mapper.ConsultationMapper;
import ru.mts.medhack2019.shared.mapper.DiseaseMapper;

import java.util.List;

@RestController
@RequestMapping("/api/diseases")
public class DiseaseController {
    private DiseaseService
            diseaseService;

    private DiseaseMapper
            diseaseMapper;

    @Autowired
    public DiseaseController(DiseaseService diseaseService, DiseaseMapper diseaseMapper) {
        this.diseaseService = diseaseService;
        this.diseaseMapper = diseaseMapper;
    }

    @GetMapping
    public List<DiseaseDTO> findAll() {
        return diseaseMapper.toListDTOs(diseaseService.findAll());
    }

    @GetMapping("/{id}")
    public DiseaseDTO read(@PathVariable("id") Long id) {
        return diseaseMapper.toDTO(diseaseService.findById(id));
    }

    @PostMapping
    public DiseaseDTO createClient(@RequestBody @Validated DiseaseDTO diseaseDTO) {
        return diseaseMapper.toDTO(diseaseService.create(diseaseDTO));
    }

    @PutMapping
    public DiseaseDTO update(@RequestBody DiseaseDTO diseaseDTO) {
        return diseaseMapper.toDTO(diseaseService.update(diseaseDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        diseaseService.delete(id);
    }


}
