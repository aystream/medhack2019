package ru.mts.medhack2019.service;

import ru.mts.medhack2019.dto.DoctorDTO;
import ru.mts.medhack2019.dto.UserDTO;
import ru.mts.medhack2019.model.Doctor;
import ru.mts.medhack2019.model.User;

import java.util.List;

/**
 * Сервис для работы с пользователями.
 */
public interface DoctorService {
    Doctor findById(Long id);

    Doctor create(DoctorDTO doctorDTO);

    Doctor update(DoctorDTO doctorDTO);

    List<Doctor> findAll();

    void delete(Long id);
}
