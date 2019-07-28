package ru.mts.medhack2019.shared.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import ru.mts.medhack2019.dto.DiseaseDTO;
import ru.mts.medhack2019.model.Disease;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-07-28T04:28:43+0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class DiseaseMapperImpl implements DiseaseMapper {

    @Override
    public DiseaseDTO toDTO(Disease from) {
        if ( from == null ) {
            return null;
        }

        DiseaseDTO diseaseDTO = new DiseaseDTO();

        diseaseDTO.setId( from.getId() );
        diseaseDTO.setName( from.getName() );
        diseaseDTO.setDescription( from.getDescription() );

        return diseaseDTO;
    }

    @Override
    public List<DiseaseDTO> toListDTOs(List<Disease> from) {
        if ( from == null ) {
            return null;
        }

        List<DiseaseDTO> list = new ArrayList<DiseaseDTO>( from.size() );
        for ( Disease disease : from ) {
            list.add( toDTO( disease ) );
        }

        return list;
    }

    @Override
    public Disease toEntity(DiseaseDTO from) {
        if ( from == null ) {
            return null;
        }

        Disease disease = new Disease();

        disease.setId( from.getId() );
        disease.setName( from.getName() );
        disease.setDescription( from.getDescription() );

        return disease;
    }

    @Override
    public List<Disease> toListEntities(List<DiseaseDTO> from) {
        if ( from == null ) {
            return null;
        }

        List<Disease> list = new ArrayList<Disease>( from.size() );
        for ( DiseaseDTO diseaseDTO : from ) {
            list.add( toEntity( diseaseDTO ) );
        }

        return list;
    }
}
