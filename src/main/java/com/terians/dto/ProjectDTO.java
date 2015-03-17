package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;

/**
 * Created by stromero on 12/11/2014.
 */
@ApiModel("Project")
public class ProjectDTO {

    // Properties
    private String name;
    private String teriansId;
    @JsonProperty("scans")
    private ScansDTO scansDTO;

    public ProjectDTO() {
    }

    public String getTeriansId() {
        return teriansId;
    }

    // Getters and Setters
    public void setTeriansId(String teriansId) {
        this.teriansId = teriansId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ScansDTO getScansDTO() {
        return scansDTO;
    }

    public void setScansDTO(ScansDTO scansDTO) {
        this.scansDTO = scansDTO;
    }
}
