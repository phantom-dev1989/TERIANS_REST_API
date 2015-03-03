package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Created by stromero on 12/11/2014.
 */
@JsonRootName("Project")
public class ProjectDTO {

    // Properties
    private String name;
    private String teriansId;
    private ScansDTO scansDTO;

    public ProjectDTO() {
    }

    public ProjectDTO(String name, ScansDTO scansDTO, String teriansId) {
        this.name = name;
        this.scansDTO = scansDTO;
        this.teriansId = teriansId;
    }

    // Getters and Setters
    public void setTeriansId(String teriansId) {
        this.teriansId = teriansId;
    }

    public String getTeriansId() {
        return teriansId;
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
