package com.terians.neo4j.repository;

import com.terians.neo4j.model.Scan;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by stromero on 1/4/2015.
 */
@Repository
public interface ScanRepository extends GraphRepository<Scan> {

    // Find the latest Scan in a Project by date
    @Query("MATCH(s:Scan) RETURN s ORDER BY s.date DESC LIMIT 1")
    public Scan findLatestScanByMaxDate();

}
