package ru.mts.medhack2019.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mts.medhack2019.model.Consultation;

import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    List<Consultation> findAllByPatientId(Long id);

    List<Consultation> findAllByDoctorId(Long id);
}
