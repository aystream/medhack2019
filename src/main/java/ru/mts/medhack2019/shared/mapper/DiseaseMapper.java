package ru.mts.medhack2019.shared.mapper;

import org.mapstruct.Mapper;
import ru.mts.medhack2019.dto.DiseaseDTO;
import ru.mts.medhack2019.dto.UserDTO;
import ru.mts.medhack2019.model.Disease;
import ru.mts.medhack2019.model.User;

@Mapper(componentModel = "spring")
public interface DiseaseMapper extends AbstractMapper<Disease, DiseaseDTO> {

}
