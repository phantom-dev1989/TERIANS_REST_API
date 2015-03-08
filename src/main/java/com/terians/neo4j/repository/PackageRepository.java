package com.terians.neo4j.repository;

import com.terians.neo4j.model.Package;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by stromero on 1/4/2015.
 */
@Repository
public interface PackageRepository extends GraphRepository<Package> {

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package) RETURN count(p)")
    public Integer findPackageCountByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package) RETURN order by p.afferent desc Limit {1}")
    public Set<Package> findPackagesByScanOrderedByAfferentCount(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package) RETURN order by p.efferent desc Limit {1}")
    public Set<Package> findPackagesByScanOrderedByEfferentCount(String scanId, int limit);

}
