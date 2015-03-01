package com.terians.dto;

/**
 * Created by stromero on 12/11/2014.
 */
public class Dependency {

    // Properties
    private String teriansId;
    private String description;
    private String fileName;
    private String filePath;
    private String license;
    private Issues issues;
    private Dependencies dependencies;
    private Vulnerabilities vulnerabilities;

    public Dependency() {

    }

    public Dependency(Dependencies dependencies, String description, String fileName, String filePath, Issues issues, String license, String teriansId, Vulnerabilities vulnerabilities) {
        this.dependencies = dependencies;
        this.description = description;
        this.fileName = fileName;
        this.filePath = filePath;
        this.issues = issues;
        this.license = license;
        this.teriansId = teriansId;
        this.vulnerabilities = vulnerabilities;
    }

    // Getters and Setters
    public void setTeriansId(String teriansId) {
        this.teriansId = teriansId;
    }

    public String getTeriansId() {
        return teriansId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
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

    public Vulnerabilities getVulnerabilities() {
        return vulnerabilities;
    }

    public void setVulnerabilities(Vulnerabilities vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }
}
