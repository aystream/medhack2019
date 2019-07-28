package ru.mts.medhack2019.shared.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mts.medhack2019.dto.ConsultationDTO;
import ru.mts.medhack2019.dto.DiseaseDTO;
import ru.mts.medhack2019.dto.DoctorDTO;
import ru.mts.medhack2019.dto.PatientDTO;
import ru.mts.medhack2019.dto.UserDTO;
import ru.mts.medhack2019.model.Consultation;
import ru.mts.medhack2019.model.Disease;
import ru.mts.medhack2019.model.Doctor;
import ru.mts.medhack2019.model.Patient;
import ru.mts.medhack2019.model.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-07-28T12:57:13+0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private PatientMapper patientMapper;

    @Override
    public UserDTO toDTO(User from) {
        if ( from == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( from.getId() );
        userDTO.setFirstName( from.getFirstName() );
        userDTO.setLastName( from.getLastName() );
        userDTO.setUserName( from.getUserName() );
        userDTO.setEmail( from.getEmail() );
        userDTO.setPatient( patientMapper.toDTO( from.getPatient() ) );
        userDTO.setDoctor( doctorMapper.toDTO( from.getDoctor() ) );

        return userDTO;
    }

    @Override
    public List<UserDTO> toListDTOs(List<User> from) {
        if ( from == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( from.size() );
        for ( User user : from ) {
            list.add( toDTO( user ) );
        }

        return list;
    }

    @Override
    public User toEntity(UserDTO from) {
        if ( from == null ) {
            return null;
        }

        User user = new User();

        user.setId( from.getId() );
        user.setFirstName( from.getFirstName() );
        user.setLastName( from.getLastName() );
        user.setUserName( from.getUserName() );
        user.setEmail( from.getEmail() );
        user.setPatient( patientDTOToPatient( from.getPatient() ) );
        user.setDoctor( doctorDTOToDoctor( from.getDoctor() ) );

        return user;
    }

    @Override
    public List<User> toListEntities(List<UserDTO> from) {
        if ( from == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( from.size() );
        for ( UserDTO userDTO : from ) {
            list.add( toEntity( userDTO ) );
        }

        return list;
    }

    protected Disease diseaseDTOToDisease(DiseaseDTO diseaseDTO) {
        if ( diseaseDTO == null ) {
            return null;
        }

        Disease disease = new Disease();

        disease.setId( diseaseDTO.getId() );
        disease.setName( diseaseDTO.getName() );
        disease.setDescription( diseaseDTO.getDescription() );

        return disease;
    }

    protected Consultation consultationDTOToConsultation(ConsultationDTO consultationDTO) {
        if ( consultationDTO == null ) {
            return null;
        }

        Consultation consultation = new Consultation();

        consultation.setId( consultationDTO.getId() );
        consultation.setStatus( consultationDTO.getStatus() );
        consultation.setDisease( diseaseDTOToDisease( consultationDTO.getDisease() ) );
        consultation.setDoctor( userDTOToUser( consultationDTO.getDoctor() ) );
        consultation.setPatient( userDTOToUser( consultationDTO.getPatient() ) );
        consultation.setActive( consultationDTO.isActive() );
        consultation.setReceptionStatus( consultationDTO.getReceptionStatus() );

        return consultation;
    }

    protected List<Consultation> consultationDTOListToConsultationList(List<ConsultationDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Consultation> list1 = new ArrayList<Consultation>( list.size() );
        for ( ConsultationDTO consultationDTO : list ) {
            list1.add( consultationDTOToConsultation( consultationDTO ) );
        }

        return list1;
    }

    protected Doctor doctorDTOToDoctor(DoctorDTO doctorDTO) {
        if ( doctorDTO == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setId( doctorDTO.getId() );
        doctor.setUser( userDTOToUser( doctorDTO.getUser() ) );
        doctor.setConsultations( consultationDTOListToConsultationList( doctorDTO.getConsultations() ) );

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

    protected Patient patientDTOToPatient(PatientDTO patientDTO) {
        if ( patientDTO == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setId( patientDTO.getId() );
        patient.setUser( userDTOToUser( patientDTO.getUser() ) );
        patient.setConsultations( consultationDTOListToConsultationList( patientDTO.getConsultations() ) );

        return patient;
    }
}
