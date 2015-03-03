package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Created by stromero on 12/11/2014.
 */
@JsonRootName("Dependency")
public class DependencyDTO {

    // Properties
    private String teriansId;
    private String description;
    private String fileName;
    private String filePath;
    private String license;
    private IssuesDTO issuesDTO;
    private DependenciesDTO dependenciesDTO;
    private VulnerabilitiesDTO vulnerabilitiesDTO;

    public DependencyDTO() {

    }

    public DependencyDTO(DependenciesDTO dependenciesDTO, String description, String fileName, String filePath,
                         IssuesDTO issuesDTO, String license, String teriansId, VulnerabilitiesDTO vulnerabilitiesDTO) {
        this.dependenciesDTO = dependenciesDTO;
        this.description = description;
        this.fileName = fileName;
        this.filePath = filePath;
        this.issuesDTO = issuesDTO;
        this.license = license;
        this.teriansId = teriansId;
        this.vulnerabilitiesDTO = vulnerabilitiesDTO;
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

    public DependenciesDTO getDependenciesDTO() {
        return dependenciesDTO;
    }

    public void setDependenciesDTO(DependenciesDTO dependenciesDTO) {
        this.dependenciesDTO = dependenciesDTO;
    }

    public IssuesDTO getIssuesDTO() {
        return issuesDTO;
    }

    public void setIssuesDTO(IssuesDTO issuesDTO) {
        this.issuesDTO = issuesDTO;
    }

    public VulnerabilitiesDTO getVulnerabilitiesDTO() {
        return vulnerabilitiesDTO;
    }

    public void setVulnerabilitiesDTO(VulnerabilitiesDTO vulnerabilitiesDTO) {
        this.vulnerabilitiesDTO = vulnerabilitiesDTO;
    }
}
