package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Created by stromero on 1/5/2015.
 */
@JsonRootName("Clazz")
public class ClazzDTO {

    private String teriansId;
    private String name;
    private Double afferent;
    private Double efferent;
    private Double cyclomaticCom;
    private MethodsDTO methodsDTO;

    public ClazzDTO() {
    }

    public ClazzDTO(Double afferent, Double cyclomaticCom, Double efferent, MethodsDTO methodsDTO, String name, String teriansId) {
        this.afferent = afferent;
        this.cyclomaticCom = cyclomaticCom;
        this.efferent = efferent;
        this.methodsDTO = methodsDTO;
        this.name = name;
        this.teriansId = teriansId;
    }

    // Getters and Setters
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

    public MethodsDTO getMethodsDTO() {
        return methodsDTO;
    }

    public void setMethodsDTO(MethodsDTO methodsDTO) {
        this.methodsDTO = methodsDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
