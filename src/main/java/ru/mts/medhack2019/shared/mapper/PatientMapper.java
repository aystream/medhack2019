package ru.mts.medhack2019.shared.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.mts.medhack2019.dto.DoctorDTO;
import ru.mts.medhack2019.dto.PatientDTO;
import ru.mts.medhack2019.model.Doctor;
import ru.mts.medhack2019.model.Patient;

@Mapper(componentModel = "spring", uses = ConsultationMapper.class)
public interface PatientMapper extends AbstractMapper<Patient, PatientDTO> {

    @Mapping(target = "user", ignore = true)
    @Override
    PatientDTO toDTO(Patient from);
}
