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
    date = "2019-07-28T04:28:43+0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class DoctorMapperImpl implements DoctorMapper {

    @Autowired
    private ConsultationMapper consultationMapper;

    @Override
    public List<DoctorDTO> toListDTOs(List<Doctor> from) {
        if ( from == null ) {
            return null;
        }

        List<DoctorDTO> list = new ArrayList<DoctorDTO>( from.size() );
        for ( Doctor doctor : from ) {
            list.add( toDTO( doctor ) );
        }

        return list;
    }

    @Override
    public Doctor toEntity(DoctorDTO from) {
        if ( from == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setId( from.getId() );
        doctor.setUser( userDTOToUser( from.getUser() ) );
        doctor.setConsultations( consultationMapper.toListEntities( from.getConsultations() ) );

        return doctor;
    }

    @Override
    public List<Doctor> toListEntities(List<DoctorDTO> from) {
        if ( from == null ) {
            return null;
        }

        List<Doctor> list = new ArrayList<Doctor>( from.size() );
        for ( DoctorDTO doctorDTO : from ) {
            list.add( toEntity( doctorDTO ) );
        }

        return list;
    }

    @Override
    public DoctorDTO toDTO(Doctor from) {
        if ( from == null ) {
            return null;
        }

        DoctorDTO doctorDTO = new DoctorDTO();

        doctorDTO.setId( from.getId() );
        doctorDTO.setConsultations( consultationMapper.toListDTOs( from.getConsultations() ) );

        return doctorDTO;
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
