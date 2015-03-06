package com.terians.neo4j.repository;

import com.terians.neo4j.model.Clazz;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by stromero on 1/4/2015.
 */
@Repository
public interface ClazzRepository extends GraphRepository<Clazz> {

    @Query("MATCH (c:Clazz) RETURN c")
    public Set<Clazz> findAllClazzes();

    @Query("MATCH (c:Clazz {teriansId:{0}}) RETURN c")
    public Clazz findClazzById(String clazzId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package)-[:HAS_CLAZZ]->(z:Clazz) RETURN count(z)")
    public Integer findClazzCountByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package)-[:HAS_CLAZZ]->(c:Clazz) RETURN order by c.afferent desc Limit {1}")
    public Set<Clazz> findClazzesByScanOrderedByAfferentCount(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package)-[:HAS_CLAZZ]->(c:Clazz) RETURN order by c.efferent desc Limit {1}")
    public Set<Clazz> findClazzesByScanOrderedByEfferentCount(String scanId, int limit);

}
