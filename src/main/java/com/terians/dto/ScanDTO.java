package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Date;

/**
 * Created by stromero on 12/11/2014.
 */
@JsonRootName("Scan")
public class ScanDTO {

    // Properties
    private String teriansId;
    private String projectVersion;
    private Date date;
    private IssuesDTO issuesDTO;
    private DependenciesDTO dependenciesDTO;
    private PackagesDTO packagesDTO;

    public ScanDTO() {

    }

    public ScanDTO(Date date, DependenciesDTO dependenciesDTO, IssuesDTO issuesDTO, PackagesDTO packagesDTO, String projectVersion, String teriansId) {
        this.date = date;
        this.dependenciesDTO = dependenciesDTO;
        this.issuesDTO = issuesDTO;
        this.packagesDTO = packagesDTO;
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

    public PackagesDTO getPackagesDTO() {
        return packagesDTO;
    }

    public void setPackagesDTO(PackagesDTO packagesDTO) {
        this.packagesDTO = packagesDTO;
    }
}
