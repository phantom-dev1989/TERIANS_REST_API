package com.terians.neo4j.model;

import org.springframework.data.neo4j.annotation.*;

import java.util.Set;

/**
 * Created by stromero on 1/5/2015.
 */
@NodeEntity
public class Package {

    // Properties
    @GraphId
    private Long id;
    @Indexed
    private String teriansId;
    @Indexed
    private String name;
    @Indexed
    private Integer afferent;
    @Indexed
    private Integer efferent;
    @Indexed
    private Integer cyclomaticCom;

    //Relationships
    @Fetch
    @RelatedTo(type = "HAS_CLAZZ",elementClass = Clazz.class)
    private Set<Clazz> clazzs;

    // Getters and Setters
    public void setTeriansId(String teriansId) {
        this.teriansId = teriansId;
    }

    public String getTeriansId() {
        return teriansId;
    }

    public Integer getAfferent() {
        return afferent;
    }

    public void setAfferent(Integer afferent) {
        this.afferent = afferent;
    }

    public Set<Clazz> getClazzs() {
        return clazzs;
    }

    public void setClazzs(Set<Clazz> clazzs) {
        this.clazzs = clazzs;
    }

    public Integer getCyclomaticCom() {
        return cyclomaticCom;
    }

    public void setCyclomaticCom(Integer cyclomaticCom) {
        this.cyclomaticCom = cyclomaticCom;
    }

    public Integer getEfferent() {
        return efferent;
    }

    public void setEfferent(Integer efferent) {
        this.efferent = efferent;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Package aPackage = (Package) o;

        if (afferent != null ? !afferent.equals(aPackage.afferent) : aPackage.afferent != null) return false;
        if (cyclomaticCom != null ? !cyclomaticCom.equals(aPackage.cyclomaticCom) : aPackage.cyclomaticCom != null)
            return false;
        if (efferent != null ? !efferent.equals(aPackage.efferent) : aPackage.efferent != null) return false;
        if (id != null ? !id.equals(aPackage.id) : aPackage.id != null) return false;
        if (name != null ? !name.equals(aPackage.name) : aPackage.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (afferent != null ? afferent.hashCode() : 0);
        result = 31 * result + (efferent != null ? efferent.hashCode() : 0);
        result = 31 * result + (cyclomaticCom != null ? cyclomaticCom.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Package{" +
                "afferent=" + afferent +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", efferent=" + efferent +
                ", cyclomaticCom=" + cyclomaticCom +
                ", clazzs=" + clazzs +
                '}';
    }
}
