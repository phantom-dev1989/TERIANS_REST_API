package com.terians.neo4j.model;

import org.springframework.data.neo4j.annotation.*;

import java.util.Set;

/**
 * Created by stromero on 12/11/2014.
 */
@NodeEntity
public class Project {

    // Properties
    @GraphId
    private Long id;
    @Indexed(unique = true)
    private String name;
    @Indexed
    private String teriansId;

    // Relationships
    @Fetch
    @RelatedTo(type = "HAS_SCAN",elementClass = Scan.class)
    private Set<Scan> scans;

    // Getters and Setters
    public void setTeriansId(String teriansId) {
        this.teriansId = teriansId;
    }

    public String getTeriansId() {
        return teriansId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Scan> getScans() {
        return scans;
    }

    public void setScans(Set<Scan> scans) {
        this.scans = scans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (id != null ? !id.equals(project.id) : project.id != null) return false;
        if (name != null ? !name.equals(project.name) : project.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scans=" + scans +
                '}';
    }
}
