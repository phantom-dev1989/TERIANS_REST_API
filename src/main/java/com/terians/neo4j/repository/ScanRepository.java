package com.terians.neo4j.repository;

import com.terians.neo4j.model.Scan;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by stromero on 1/4/2015.
 */
@Repository
public interface ScanRepository extends GraphRepository<Scan> {

    // Find the latest Scan in a Project by date
    @Query("MATCH (s:Scan) RETURN s ORDER BY s.date DESC LIMIT 1")
    public Scan findLatestScan();

    @Query("MATCH (s:Scan) RETURN s ORDER BY s.date ASC LIMIT 1")
    public Scan findOldestScan();

    @Query("MATCH (p:Project {teriansId:{0}})-[:HAS_SCAN]->(s:Scan) RETURN s")
    public Set<Scan> findAllScansByProject(String projectId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package)-[:HAS_CLAZZ]->(z:Clazz)-[:HAS_METHOD]->(m:Method) RETURN count(m)")
    public Integer findMethodCountByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package)-[:HAS_CLAZZ]->(z:Clazz) RETURN count(z)")
    public Integer findClazzCountByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package) RETURN count(p)")
    public Integer findPackageCountByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) RETURN count(i)")
    public Integer findIssueCountByScan(String scanId);

    @Query("MATCH (s:Scan) RETURN s")
    public Set<Scan> findAllScans();

    @Query("MATCH (s:Scan {teriansId:{0}}) RETURN s")
    public Scan findScanById(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package) RETURN avg(toFloat(p.cyclomaticCom))")
    public Integer findComplexityByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) RETURN sum(toFloat(i.techDebtMinutes))")
    public Integer findTechDebtByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package) RETURN avg(toFloat(p.abstractness))")
    public Integer findAbstractnessByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_PACKAGE]->(p:Package) RETURN avg(toFloat(p.instability))")
    public Integer findInstabilityByScan(String scanId);

}
