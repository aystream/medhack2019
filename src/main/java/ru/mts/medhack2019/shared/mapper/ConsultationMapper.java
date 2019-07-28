package ru.mts.medhack2019.shared.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.mts.medhack2019.dto.ConsultationDTO;
import ru.mts.medhack2019.dto.PatientDTO;
import ru.mts.medhack2019.model.Consultation;
import ru.mts.medhack2019.model.Patient;

@Mapper(componentModel = "spring", uses = {DoctorMapper.class, PatientMapper.class})
public interface ConsultationMapper extends AbstractMapper<Consultation, ConsultationDTO> {
    @Mappings(
            {
                    @Mapping(target = "doctor.doctor.consultations", ignore = true),
                    @Mapping(target = "doctor.doctor.user", ignore = true),
                    @Mapping(target = "patient.patient.consultations", ignore = true),
                    @Mapping(target = "patient.patient.user", ignore = true),
                    @Mapping(target = "doctorId", source = "doctor.id"),
                    @Mapping(target = "patientId", source = "patient.id")
            }
    )
    @Override
    ConsultationDTO toDTO(Consultation from);
}
