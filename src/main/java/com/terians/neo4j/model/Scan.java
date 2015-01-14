package com.terians.neo4j.model;

import org.springframework.data.neo4j.annotation.*;

import java.util.Date;
import java.util.Set;

/**
 * Created by stromero on 12/11/2014.
 */
@NodeEntity
public class Scan {

    // Properties
    @GraphId
    private Long id;
    @Indexed
    private String teriansId;
    @Indexed
    private String projectVersion;
    @Indexed
    private Date date;

    //Relationships
    @Fetch
    @RelatedTo(type = "NEXT_SCAN")
    private Scan scan;
    @Fetch
    @RelatedTo(type = "HAS_ISSUE",elementClass = Issue.class)
    private Set<Issue> issues;
    @Fetch
    @RelatedTo(type = "HAS_DEPENDENCY",elementClass = Dependency.class)
    private Set<Dependency> dependencies;
    @Fetch
    @RelatedTo(type = "HAS_PACKAGE",elementClass = Package.class)
    private Set<Package> packages;

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

    public Set<Dependency> getDependencies() {
        return dependencies;
    }

    public void setDependencies(Set<Dependency> dependencies) {
        this.dependencies = dependencies;
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

    public Set<Package> getPackages() {
        return packages;
    }

    public void setPackages(Set<Package> packages) {
        this.packages = packages;
    }

    public String getProjectVersion() {
        return projectVersion;
    }

    public void setProjectVersion(String projectVersion) {
        this.projectVersion = projectVersion;
    }

    public Scan getScan() {
        return scan;
    }

    public void setScan(Scan scan) {
        this.scan = scan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Scan scan = (Scan) o;

        if (date != null ? !date.equals(scan.date) : scan.date != null) return false;
        if (id != null ? !id.equals(scan.id) : scan.id != null) return false;
        if (projectVersion != null ? !projectVersion.equals(scan.projectVersion) : scan.projectVersion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (projectVersion != null ? projectVersion.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Scan{" +
                "date=" + date +
                ", id=" + id +
                ", projectVersion='" + projectVersion + '\'' +
                ", scan=" + scan +
                ", issues=" + issues +
                ", dependencies=" + dependencies +
                ", packages=" + packages +
                '}';
    }
}
