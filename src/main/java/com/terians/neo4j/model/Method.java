package com.terians.neo4j.model;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

import java.util.UUID;

/**
 * Created by stromero on 1/5/2015.
 */
@NodeEntity
public class Method {

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
    @Indexed
    private String invokes;

    // Getters and Setters
    public void setTeriansId(String teriansId) {
        this.teriansId = teriansId;
    }

    public String getTeriansId() {
        return teriansId;
    }

    public String getInvokes() {
        return invokes;
    }

    public void setInvokes(String invokes) {
        this.invokes = invokes;
    }
    public Integer getAfferent() {
        return afferent;
    }

    public void setAfferent(Integer afferent) {
        this.afferent = afferent;
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

        Method method = (Method) o;

        if (afferent != null ? !afferent.equals(method.afferent) : method.afferent != null) return false;
        if (cyclomaticCom != null ? !cyclomaticCom.equals(method.cyclomaticCom) : method.cyclomaticCom != null)
            return false;
        if (efferent != null ? !efferent.equals(method.efferent) : method.efferent != null) return false;
        if (id != null ? !id.equals(method.id) : method.id != null) return false;
        if (name != null ? !name.equals(method.name) : method.name != null) return false;

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
        return "Method{" +
                "afferent=" + afferent +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", efferent=" + efferent +
                ", cyclomaticCom=" + cyclomaticCom +
                '}';
    }
}
