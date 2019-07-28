package ru.mts.medhack2019.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mts.medhack2019.model.Patient;
import ru.mts.medhack2019.model.User;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
