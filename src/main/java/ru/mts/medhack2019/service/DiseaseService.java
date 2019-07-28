package ru.mts.medhack2019.service;

import ru.mts.medhack2019.dto.DiseaseDTO;
import ru.mts.medhack2019.dto.DoctorDTO;
import ru.mts.medhack2019.dto.PatientDTO;
import ru.mts.medhack2019.model.Disease;
import ru.mts.medhack2019.model.Doctor;
import ru.mts.medhack2019.model.Patient;

import java.util.List;

public interface DiseaseService {

    Disease create(DiseaseDTO diseaseDTO);

    Disease findById(Long id);


    Disease update(DiseaseDTO diseaseDTO);

    List<Disease> findAll();

    void delete(Long id);
}
