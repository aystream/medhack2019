package ru.mts.medhack2019.shared.mapper;

import org.mapstruct.Mapper;
import ru.mts.medhack2019.dto.UserDTO;
import ru.mts.medhack2019.model.User;

@Mapper(componentModel = "spring", uses = {DoctorMapper.class, PatientMapper.class})
public interface UserMapper extends AbstractMapper<User, UserDTO> {

}
