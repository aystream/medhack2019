package ru.mts.medhack2019.shared.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.mts.medhack2019.dto.DoctorDTO;
import ru.mts.medhack2019.dto.PatientDTO;
import ru.mts.medhack2019.dto.UserDTO;
import ru.mts.medhack2019.model.Doctor;
import ru.mts.medhack2019.model.Patient;
import ru.mts.medhack2019.model.User;

@Mapper(componentModel = "spring", uses = ConsultationMapper.class)
public interface DoctorMapper extends AbstractMapper<Doctor, DoctorDTO> {
    @Mapping(target = "user", ignore = true)
    @Override
    DoctorDTO toDTO(Doctor from);
}
