package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Created by stromero on 1/5/2015.
 */
@JsonRootName("Package")
public class PackageDTO {

    // Properties
    private String teriansId;
    private String name;
    private Double afferent;
    private Double efferent;
    private Double cyclomaticCom;
    private Double instability;
    private Double abstractness;
    private ClazzesDTO clazzesDTO;

    public PackageDTO() {

    }

    public PackageDTO(Double abstractness, Double afferent, ClazzesDTO clazzesDTO, Double cyclomaticCom, Double efferent, Double instability, String name, String teriansId) {
        this.abstractness = abstractness;
        this.afferent = afferent;
        this.clazzesDTO = clazzesDTO;
        this.cyclomaticCom = cyclomaticCom;
        this.efferent = efferent;
        this.instability = instability;
        this.name = name;
        this.teriansId = teriansId;
    }

    // Getters and Setters
    public Double getAbstractness() {
        return abstractness;
    }

    public void setAbstractness(Double abstractness) {
        this.abstractness = abstractness;
    }

    public Double getInstability() {
        return instability;
    }

    public void setInstability(Double instability) {
        this.instability = instability;
    }

    public void setTeriansId(String teriansId) {
        this.teriansId = teriansId;
    }

    public String getTeriansId() {
        return teriansId;
    }

    public Double getAfferent() {
        return afferent;
    }

    public void setAfferent(Double afferent) {
        this.afferent = afferent;
    }

    public Double getCyclomaticCom() {
        return cyclomaticCom;
    }

    public void setCyclomaticCom(Double cyclomaticCom) {
        this.cyclomaticCom = cyclomaticCom;
    }

    public Double getEfferent() {
        return efferent;
    }

    public void setEfferent(Double efferent) {
        this.efferent = efferent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClazzesDTO getClazzesDTO() {
        return clazzesDTO;
    }

    public void setClazzesDTO(ClazzesDTO clazzesDTO) {
        this.clazzesDTO = clazzesDTO;
    }
}
