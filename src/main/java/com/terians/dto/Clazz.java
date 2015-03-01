package com.terians.dto;

/**
 * Created by stromero on 1/5/2015.
 */
public class Clazz {

    private String teriansId;
    private String name;
    private Double afferent;
    private Double efferent;
    private Double cyclomaticCom;
    private Methods methods;

    public Clazz() {
    }

    public Clazz(Double afferent, Double cyclomaticCom, Double efferent, Methods methods, String name, String teriansId) {
        this.afferent = afferent;
        this.cyclomaticCom = cyclomaticCom;
        this.efferent = efferent;
        this.methods = methods;
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

    public Methods getMethods() {
        return methods;
    }

    public void setMethods(Methods methods) {
        this.methods = methods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
