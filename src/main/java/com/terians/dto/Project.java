package com.terians.dto;

/**
 * Created by stromero on 12/11/2014.
 */
public class Project {

    // Properties
    private String name;
    private String teriansId;
    private Scans scans;

    public Project() {
    }

    public Project(String name, Scans scans, String teriansId) {
        this.name = name;
        this.scans = scans;
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

    public Scans getScans() {
        return scans;
    }

    public void setScans(Scans scans) {
        this.scans = scans;
    }
}
