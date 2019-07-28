package ru.mts.medhack2019.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mts.medhack2019.dto.PatientDTO;
import ru.mts.medhack2019.dto.UserDTO;
import ru.mts.medhack2019.model.Patient;
import ru.mts.medhack2019.model.User;
import ru.mts.medhack2019.repository.PatientRepository;
import ru.mts.medhack2019.repository.UserRepository;
import ru.mts.medhack2019.service.PatientService;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient findById(Long id) {
        return patientRepository.findById(id != null ? id : -1L)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public Patient create(PatientDTO patientDTO) {
        Patient patient = patientRepository.findById(patientDTO.getId() != null ? patientDTO.getId() : -1L)
                .orElseGet(Patient::new);
        /*patient.ыуе(patientDTO.getFirstName())
                .setLastName(patientDTO.getLastName())
                .setUserName(patientDTO.getUserName())
                .setEmail(patientDTO.getEmail())
                .setDoctor();*/
        return patientRepository.save(patient);
    }

    @Override
    public Patient update(PatientDTO patientDTO) {
        return create(patientDTO);
    }


    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }


    @Override
    public void delete(Long id) {
        patientRepository.deleteById(id);
    }
}
