package com.terians.dto;

import java.util.Date;

/**
 * Created by stromero on 12/11/2014.
 */
public class Scan {

    // Properties
    private String teriansId;
    private String projectVersion;
    private Date date;
    private Issues issues;
    private Dependencies dependencies;
    private Packages packages;

    public Scan() {

    }

    public Scan(Date date, Dependencies dependencies, Issues issues, Packages packages, String projectVersion, String teriansId) {
        this.date = date;
        this.dependencies = dependencies;
        this.issues = issues;
        this.packages = packages;
        this.projectVersion = projectVersion;
        this.teriansId = teriansId;
    }

    // Getters and Setters
    public void setTeriansId(String teriansId) {
        this.teriansId = teriansId;
    }

    public String getTeriansId() {
        return teriansId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProjectVersion() {
        return projectVersion;
    }

    public void setProjectVersion(String projectVersion) {
        this.projectVersion = projectVersion;
    }

    public Dependencies getDependencies() {
        return dependencies;
    }

    public void setDependencies(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Issues getIssues() {
        return issues;
    }

    public void setIssues(Issues issues) {
        this.issues = issues;
    }

    public Packages getPackages() {
        return packages;
    }

    public void setPackages(Packages packages) {
        this.packages = packages;
    }
}
