package ru.mts.medhack2019.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsultationCardDTO {
    private String name;
    private String address;
    private String addressComment;
    private String diagnose;
    private String simptoms;
    private String resultsDtae;
    private String results;
    private String secondDate;
    private String second ;
    private List<String> checkboxes;

    public ConsultationCardDTO() {
        this.checkboxes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ConsultationCardDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ConsultationCardDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAddressComment() {
        return addressComment;
    }

    public ConsultationCardDTO setAddressComment(String addressComment) {
        this.addressComment = addressComment;
        return this;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public ConsultationCardDTO setDiagnose(String diagnose) {
        this.diagnose = diagnose;
        return this;
    }

    public String getSimptoms() {
        return simptoms;
    }

    public ConsultationCardDTO setSimptoms(String simptoms) {
        this.simptoms = simptoms;
        return this;
    }

    public String getResultsDtae() {
        return resultsDtae;
    }

    public ConsultationCardDTO setResultsDtae(String resultsDtae) {
        this.resultsDtae = resultsDtae;
        return this;
    }

    public String getResults() {
        return results;
    }

    public ConsultationCardDTO setResults(String results) {
        this.results = results;
        return this;
    }

    public String getSecondDate() {
        return secondDate;
    }

    public ConsultationCardDTO setSecondDate(String secondDate) {
        this.secondDate = secondDate;
        return this;
    }

    public String getSecond() {
        return second;
    }

    public ConsultationCardDTO setSecond(String second) {
        this.second = second;
        return this;
    }

    public List<String> getCheckboxes() {
        return checkboxes;
    }

    public ConsultationCardDTO setCheckboxes(List<String> checkboxes) {
        this.checkboxes = checkboxes;
        return this;
    }
}
