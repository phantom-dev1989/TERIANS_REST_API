package com.terians.neo4j.repository;

import com.terians.neo4j.model.Dependency;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by stromero on 1/4/2015.
 */
@Repository
public interface DependencyRepository extends GraphRepository<Dependency> {

    // Find all dependencies by Scan teriansId
    //@Cacheable("teriansCache")
    @Query("MATCH(s:Scan)-[:HAS_DEPENDENCY]->(d:Dependency) WHERE s.teriansId = {0} RETURN d")
    public Set<Dependency> findDependenciesByScan(String scanId);

    @Query("MATCH (d:Dependency) RETURN d")
    public Set<Dependency> findAllDependencies();

    @Query("MATCH (d:Dependency {teriansId:{0}}) RETURN d")
    public Dependency findDependencyById(String dependencyId);
}
