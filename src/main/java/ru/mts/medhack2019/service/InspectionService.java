package ru.mts.medhack2019.service;

import ru.mts.medhack2019.dto.PatientDTO;
import ru.mts.medhack2019.model.Inspection;
import ru.mts.medhack2019.model.Patient;

import java.util.List;

/**
 * Сервис для работы с пользователями.
 */
public interface InspectionService {

    Inspection create(Inspection inspection);
}
