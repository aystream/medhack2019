package ru.mts.medhack2019.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mts.medhack2019.model.Doctor;
import ru.mts.medhack2019.model.Patient;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
