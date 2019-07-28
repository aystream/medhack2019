package ru.mts.medhack2019.shared.mapper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Named;

import java.util.List;

public interface AbstractMapper<E, D> {
    @Named("toDTO")
    D toDTO(E from);

    @IterableMapping(qualifiedByName = "toDTO")
    List<D> toListDTOs(List<E> from);

    @Named("toEntity")
    E toEntity(D from);

    @IterableMapping(qualifiedByName = "toEntity")
    List<E> toListEntities(List<D> from);
}
