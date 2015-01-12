package com.terians.neo4j.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by stromero on 12/1/2014.
 */
@Repository
public interface Neo4JSampleRepository extends GraphRepository<Object> {


    @Query("START root=node:User(login = 'root') MATCH root-[:knows]->friends RETURN friends")
    public List<Object> findAllObjects(String string);


}
