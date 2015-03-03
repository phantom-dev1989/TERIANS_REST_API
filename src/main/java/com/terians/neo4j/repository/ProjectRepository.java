package com.terians.neo4j.repository;

import com.terians.neo4j.model.Project;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by stromero on 1/4/2015.
 */
@Repository
public interface ProjectRepository extends GraphRepository<Project> {

    @Query("MATCH (p:Project) RETURN p")
    public Set<Project> findAllProjects();

    @Query("MATCH (p:Project {teriansId:{0}}) RETURN p")
    public Project findProjectById(String teriansId);

}
