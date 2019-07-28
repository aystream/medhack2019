package ru.mts.medhack2019.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mts.medhack2019.dto.DiseaseDTO;
import ru.mts.medhack2019.model.Disease;
import ru.mts.medhack2019.repository.DiseaseRepository;
import ru.mts.medhack2019.service.DiseaseService;

import java.util.List;

@Service
public class DiseaseServiceImpl implements DiseaseService {

    private DiseaseRepository diseaseRepository;

    @Autowired
    public DiseaseServiceImpl(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    @Override
    public Disease findById(Long id) {
        return diseaseRepository.findById(id != null ? id : -1L)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public Disease create(DiseaseDTO diseaseDTO) {
        Disease disease = diseaseRepository.findById(diseaseDTO.getId() != null ? diseaseDTO.getId() : -1L)
                .orElseGet(Disease::new);
        disease.setName(diseaseDTO.getName()).setDescription(diseaseDTO.getDescription());
        return diseaseRepository.save(disease);
    }

    @Override
    public Disease update(DiseaseDTO diseaseDTO) {
        return create(diseaseDTO);
    }

    @Override
    public List<Disease> findAll() {
        return diseaseRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        diseaseRepository.deleteById(id);
    }
}
