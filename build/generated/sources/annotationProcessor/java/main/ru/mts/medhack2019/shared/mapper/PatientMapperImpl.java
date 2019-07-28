package ru.mts.medhack2019.shared.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mts.medhack2019.dto.DoctorDTO;
import ru.mts.medhack2019.dto.PatientDTO;
import ru.mts.medhack2019.dto.UserDTO;
import ru.mts.medhack2019.model.Doctor;
import ru.mts.medhack2019.model.Patient;
import ru.mts.medhack2019.model.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-07-28T13:37:54+0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class PatientMapperImpl implements PatientMapper {

    @Autowired
    private ConsultationMapper consultationMapper;

    @Override
    public List<PatientDTO> toListDTOs(List<Patient> from) {
        if ( from == null ) {
            return null;
        }

        List<PatientDTO> list = new ArrayList<PatientDTO>( from.size() );
        for ( Patient patient : from ) {
            list.add( toDTO( patient ) );
        }

        return list;
    }

    @Override
    public Patient toEntity(PatientDTO from) {
        if ( from == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setId( from.getId() );
        patient.setUser( userDTOToUser( from.getUser() ) );
        patient.setConsultations( consultationMapper.toListEntities( from.getConsultations() ) );

        return patient;
    }

    @Override
    public List<Patient> toListEntities(List<PatientDTO> from) {
        if ( from == null ) {
            return null;
        }

        List<Patient> list = new ArrayList<Patient>( from.size() );
        for ( PatientDTO patientDTO : from ) {
            list.add( toEntity( patientDTO ) );
        }

        return list;
    }

    @Override
    public PatientDTO toDTO(Patient from) {
        if ( from == null ) {
            return null;
        }

        PatientDTO patientDTO = new PatientDTO();

        patientDTO.setId( from.getId() );
        patientDTO.setConsultations( consultationMapper.toListDTOs( from.getConsultations() ) );

        return patientDTO;
    }

    protected Patient patientDTOToPatient(PatientDTO patientDTO) {
        if ( patientDTO == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setId( patientDTO.getId() );
        patient.setUser( userDTOToUser( patientDTO.getUser() ) );
        patient.setConsultations( consultationMapper.toListEntities( patientDTO.getConsultations() ) );

        return patient;
    }

    protected Doctor doctorDTOToDoctor(DoctorDTO doctorDTO) {
        if ( doctorDTO == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setId( doctorDTO.getId() );
        doctor.setUser( userDTOToUser( doctorDTO.getUser() ) );
        doctor.setConsultations( consultationMapper.toListEntities( doctorDTO.getConsultations() ) );

        return doctor;
    }

    protected User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setFirstName( userDTO.getFirstName() );
        user.setLastName( userDTO.getLastName() );
        user.setUserName( userDTO.getUserName() );
        user.setEmail( userDTO.getEmail() );
        user.setPatient( patientDTOToPatient( userDTO.getPatient() ) );
        user.setDoctor( doctorDTOToDoctor( userDTO.getDoctor() ) );

        return user;
    }
}
