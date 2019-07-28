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
    date = "2019-07-28T13:37:54+0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class ConsultationMapperImpl implements ConsultationMapper {

    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private PatientMapper patientMapper;

    @Override
    public List<ConsultationDTO> toListDTOs(List<Consultation> from) {
        if ( from == null ) {
            return null;
        }

        List<ConsultationDTO> list = new ArrayList<ConsultationDTO>( from.size() );
        for ( Consultation consultation : from ) {
            list.add( toDTO( consultation ) );
        }

        return list;
    }

    @Override
    public Consultation toEntity(ConsultationDTO from) {
        if ( from == null ) {
            return null;
        }

        Consultation consultation = new Consultation();

        consultation.setId( from.getId() );
        consultation.setStatus( from.getStatus() );
        consultation.setDisease( diseaseDTOToDisease( from.getDisease() ) );
        consultation.setDoctor( userDTOToUser( from.getDoctor() ) );
        consultation.setPatient( userDTOToUser( from.getPatient() ) );
        consultation.setActive( from.isActive() );
        consultation.setReceptionStatus( from.getReceptionStatus() );

        return consultation;
    }

    @Override
    public List<Consultation> toListEntities(List<ConsultationDTO> from) {
        if ( from == null ) {
            return null;
        }

        List<Consultation> list = new ArrayList<Consultation>( from.size() );
        for ( ConsultationDTO consultationDTO : from ) {
            list.add( toEntity( consultationDTO ) );
        }

        return list;
    }

    @Override
    public ConsultationDTO toDTO(Consultation from) {
        if ( from == null ) {
            return null;
        }

        ConsultationDTO consultationDTO = new ConsultationDTO();

        consultationDTO.setDoctorId( fromDoctorId( from ) );
        consultationDTO.setPatientId( fromPatientId( from ) );
        consultationDTO.setId( from.getId() );
        consultationDTO.setStatus( from.getStatus() );
        consultationDTO.setDisease( diseaseToDiseaseDTO( from.getDisease() ) );
        consultationDTO.setDoctor( userToUserDTO( from.getDoctor() ) );
        consultationDTO.setPatient( userToUserDTO( from.getPatient() ) );
        consultationDTO.setReceptionStatus( from.getReceptionStatus() );
        consultationDTO.setActive( from.isActive() );

        return consultationDTO;
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

    protected Patient patientDTOToPatient(PatientDTO patientDTO) {
        if ( patientDTO == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setId( patientDTO.getId() );
        patient.setUser( userDTOToUser( patientDTO.getUser() ) );
        patient.setConsultations( toListEntities( patientDTO.getConsultations() ) );

        return patient;
    }

    protected Doctor doctorDTOToDoctor(DoctorDTO doctorDTO) {
        if ( doctorDTO == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setId( doctorDTO.getId() );
        doctor.setUser( userDTOToUser( doctorDTO.getUser() ) );
        doctor.setConsultations( toListEntities( doctorDTO.getConsultations() ) );

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

    private Long fromDoctorId(Consultation consultation) {
        if ( consultation == null ) {
            return null;
        }
        User doctor = consultation.getDoctor();
        if ( doctor == null ) {
            return null;
        }
        Long id = doctor.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long fromPatientId(Consultation consultation) {
        if ( consultation == null ) {
            return null;
        }
        User patient = consultation.getPatient();
        if ( patient == null ) {
            return null;
        }
        Long id = patient.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected DiseaseDTO diseaseToDiseaseDTO(Disease disease) {
        if ( disease == null ) {
            return null;
        }

        DiseaseDTO diseaseDTO = new DiseaseDTO();

        diseaseDTO.setId( disease.getId() );
        diseaseDTO.setName( disease.getName() );
        diseaseDTO.setDescription( disease.getDescription() );

        return diseaseDTO;
    }

    protected DoctorDTO doctorToDoctorDTO(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorDTO doctorDTO = new DoctorDTO();

        doctorDTO.setId( doctor.getId() );

        return doctorDTO;
    }

    protected UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setFirstName( user.getFirstName() );
        userDTO.setLastName( user.getLastName() );
        userDTO.setUserName( user.getUserName() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setPatient( patientMapper.toDTO( user.getPatient() ) );
        userDTO.setDoctor( doctorToDoctorDTO( user.getDoctor() ) );

        return userDTO;
    }

    protected PatientDTO patientToPatientDTO(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientDTO patientDTO = new PatientDTO();

        patientDTO.setId( patient.getId() );

        return patientDTO;
    }
}
