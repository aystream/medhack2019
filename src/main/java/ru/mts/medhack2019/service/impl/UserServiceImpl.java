package ru.mts.medhack2019.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mts.medhack2019.dto.UserDTO;
import ru.mts.medhack2019.model.User;
import ru.mts.medhack2019.repository.UserRepository;
import ru.mts.medhack2019.service.DoctorService;
import ru.mts.medhack2019.service.PatientService;
import ru.mts.medhack2019.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PatientService patientService;
    private DoctorService doctorService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PatientService patientService, DoctorService doctorService) {
        this.userRepository = userRepository;
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id != null ? id : -1L)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public User create(UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getId() != null ? userDTO.getId() : -1L)
                .orElseGet(User::new);
        user.setFirstName(userDTO.getFirstName())
                .setLastName(userDTO.getLastName())
                .setUserName(userDTO.getUserName())
                .setEmail(userDTO.getEmail());
        if (userDTO.getDoctor() != null) {
            user.setDoctor(doctorService.create(userDTO.getDoctor()).setUser(user));
        }
        if (userDTO.getPatient() != null) {
            user.setPatient(patientService.create(userDTO.getPatient()).setUser(user));
        }
        return userRepository.save(user);
    }

    @Override
    public User update(UserDTO userDTO) {
        return create(userDTO);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
