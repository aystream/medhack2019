package ru.mts.medhack2019.service;

import ru.mts.medhack2019.dto.DoctorDTO;
import ru.mts.medhack2019.dto.PatientDTO;
import ru.mts.medhack2019.model.Doctor;
import ru.mts.medhack2019.model.Patient;

import java.util.List;

/**
 * Сервис для работы с пользователями.
 */
public interface PatientService {
    Patient findById(Long id);

    Patient create(PatientDTO patientDTO);

    Patient update(PatientDTO patientDTO);

    List<Patient> findAll();

    void delete(Long id);
}
