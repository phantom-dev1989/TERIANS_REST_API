package com.terians.neo4j.model;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

/**
 * Created by stromero on 12/11/2014.
 */
@NodeEntity
public class Scan {

    @GraphId
    private Long id;
    @Indexed
    @RelatedTo(type = "HAS")
    private Version version;
    @Indexed
    @RelatedTo(type = "NEXT", direction = Direction.OUTGOING)
    private Scan scan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Scan getScan() {
        return scan;
    }

    public void setScan(Scan scan) {
        this.scan = scan;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }
}
