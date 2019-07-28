package ru.mts.medhack2019.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Заболевание
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiseaseDTO {
    private Long id;

    private String name;

    private String description;

    public Long getId() {
        return id;
    }

    public DiseaseDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DiseaseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DiseaseDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
