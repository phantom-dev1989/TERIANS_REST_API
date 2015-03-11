package com.terians.neo4j.model;

import org.springframework.data.neo4j.annotation.*;

import java.util.Set;

/**
 * Created by stromero on 12/11/2014.
 */
@NodeEntity
public class Dependency {

    // Properties
    @GraphId
    private Long id;
    @Indexed
    private String teriansId;
    @Indexed
    private String description;
    @Indexed
    private String fileName;
    @Indexed
    private String filePath;
    @Indexed
    private String license;

    // Relationships
    @Fetch
    @RelatedTo(type = "HAS_VULN", elementClass = Vulnerability.class)
    private Set<Vulnerability> vulnerabilities;
    @Fetch
    @RelatedTo(type = "HAS_ISSUE", elementClass = Issue.class)
    private Set<Issue> issues;
    @Fetch
    @RelatedTo(type = "RELATED_DEPENDENCIES", elementClass = Dependency.class)
    private Set<Dependency> dependencies;
    @Fetch
    @RelatedTo(type = "USED_BY", elementClass = Method.class)
    private Set<Method> methods;

    public String getTeriansId() {
        return teriansId;
    }

    // Getters and Setters
    public void setTeriansId(String teriansId) {
        this.teriansId = teriansId;
    }

    public Set<Dependency> getDependencies() {
        return dependencies;
    }

    public void setDependencies(Set<Dependency> dependencies) {
        this.dependencies = dependencies;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Set<Vulnerability> getVulnerabilities() {
        return vulnerabilities;
    }

    public void setVulnerabilities(Set<Vulnerability> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

    public Set<Method> getMethods() {
        return methods;
    }

    public void setMethods(Set<Method> methods) {
        this.methods = methods;
    }

    @Override
    public int hashCode() {
        int result = teriansId != null ? teriansId.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        result = 31 * result + (license != null ? license.hashCode() : 0);
        result = 31 * result + (vulnerabilities != null ? vulnerabilities.hashCode() : 0);
        result = 31 * result + (issues != null ? issues.hashCode() : 0);
        result = 31 * result + (dependencies != null ? dependencies.hashCode() : 0);
        result = 31 * result + (methods != null ? methods.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dependency that = (Dependency) o;

        if (dependencies != null ? !dependencies.equals(that.dependencies) : that.dependencies != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
        if (filePath != null ? !filePath.equals(that.filePath) : that.filePath != null) return false;
        if (issues != null ? !issues.equals(that.issues) : that.issues != null) return false;
        if (license != null ? !license.equals(that.license) : that.license != null) return false;
        if (methods != null ? !methods.equals(that.methods) : that.methods != null) return false;
        if (teriansId != null ? !teriansId.equals(that.teriansId) : that.teriansId != null) return false;
        if (vulnerabilities != null ? !vulnerabilities.equals(that.vulnerabilities) : that.vulnerabilities != null)
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Dependency{" +
                "dependencies=" + dependencies +
                ", id=" + id +
                ", teriansId='" + teriansId + '\'' +
                ", description='" + description + '\'' +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", license='" + license + '\'' +
                ", vulnerabilities=" + vulnerabilities +
                ", issues=" + issues +
                ", methods=" + methods +
                '}';
    }
}
