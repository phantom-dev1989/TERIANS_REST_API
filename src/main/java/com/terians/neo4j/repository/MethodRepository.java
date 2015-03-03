package com.terians.neo4j.repository;

import com.terians.neo4j.model.Method;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by stromero on 1/4/2015.
 */
@Repository
public interface MethodRepository extends GraphRepository<Method> {

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package)-[:HAS_CLAZZ]->(z:Clazz)-[:HAS_METHOD]->(m:Method) RETURN count(m)")
    public Integer findMethodCountByScan(String teriansId);

}
