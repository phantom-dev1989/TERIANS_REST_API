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
    private String sourceCode;
    private String lineNumbers;
    private Double cyclomaticCom;
    private MethodsDTO methodsDTO;

    public ClazzDTO() {
    }

    public ClazzDTO(Double afferent, Double cyclomaticCom, Double efferent, String lineNumbers, MethodsDTO methodsDTO, String name, String sourceCode, String teriansId) {
        this.afferent = afferent;
        this.cyclomaticCom = cyclomaticCom;
        this.efferent = efferent;
        this.lineNumbers = lineNumbers;
        this.methodsDTO = methodsDTO;
        this.name = name;
        this.sourceCode = sourceCode;
        this.teriansId = teriansId;
    }

    // Getters and Setters
    public String getLineNumbers() {
        return lineNumbers;
    }

    public void setLineNumbers(String lineNumbers) {
        this.lineNumbers = lineNumbers;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
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
