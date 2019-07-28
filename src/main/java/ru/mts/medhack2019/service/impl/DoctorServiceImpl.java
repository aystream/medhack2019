package ru.mts.medhack2019.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mts.medhack2019.dto.DoctorDTO;
import ru.mts.medhack2019.dto.UserDTO;
import ru.mts.medhack2019.model.Doctor;
import ru.mts.medhack2019.model.User;
import ru.mts.medhack2019.repository.DoctorRepository;
import ru.mts.medhack2019.repository.UserRepository;
import ru.mts.medhack2019.service.DoctorService;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor findById(Long id) {
        return doctorRepository.findById(id != null ? id : -1L)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public Doctor create(DoctorDTO doctorDTO) {
        Doctor doctor = doctorRepository.findById(doctorDTO.getId() != null ? doctorDTO.getId() : -1L)
                .orElseGet(Doctor::new);
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor update(DoctorDTO doctorDTO) {
        return create(doctorDTO);
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }
}
