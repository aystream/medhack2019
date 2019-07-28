package ru.mts.medhack2019.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mts.medhack2019.model.Disease;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {
}
