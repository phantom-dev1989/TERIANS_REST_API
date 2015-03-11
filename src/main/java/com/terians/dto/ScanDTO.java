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
    private int complexity;
    private int techdebt;
    private int abstractness;
    private int instability;
    private int methodCount;
    private int clazzCount;
    private int packageCount;
    private int issueCount;
    private Date date;
    private IssuesDTO issuesDTO;
    private DependenciesDTO dependenciesDTO;
    private PackagesDTO packagesDTO;

    public ScanDTO() {

    }

    public ScanDTO(int abstractness, int clazzCount, int complexity, Date date, DependenciesDTO dependenciesDTO, int instability, int issueCount,
                   IssuesDTO issuesDTO, int methodCount, int packageCount, PackagesDTO packagesDTO, String projectVersion, int techdebt, String teriansId) {
        this.abstractness = abstractness;
        this.clazzCount = clazzCount;
        this.complexity = complexity;
        this.date = date;
        this.dependenciesDTO = dependenciesDTO;
        this.instability = instability;
        this.issueCount = issueCount;
        this.issuesDTO = issuesDTO;
        this.methodCount = methodCount;
        this.packageCount = packageCount;
        this.packagesDTO = packagesDTO;
        this.projectVersion = projectVersion;
        this.techdebt = techdebt;
        this.teriansId = teriansId;
    }

    // Getters and Setters


    public int getIssueCount() {
        return issueCount;
    }

    public void setIssueCount(int issueCount) {
        this.issueCount = issueCount;
    }

    public int getClazzCount() {
        return clazzCount;
    }

    public void setClazzCount(int clazzCount) {
        this.clazzCount = clazzCount;
    }

    public int getMethodCount() {
        return methodCount;
    }

    public void setMethodCount(int methodCount) {
        this.methodCount = methodCount;
    }

    public int getPackageCount() {
        return packageCount;
    }

    public void setPackageCount(int packageCount) {
        this.packageCount = packageCount;
    }

    public int getAbstractness() {
        return abstractness;
    }

    public void setAbstractness(int abstractness) {
        this.abstractness = abstractness;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public int getInstability() {
        return instability;
    }

    public void setInstability(int instability) {
        this.instability = instability;
    }

    public int getTechdebt() {
        return techdebt;
    }

    public void setTechdebt(int techdebt) {
        this.techdebt = techdebt;
    }

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
