package com.terians.neo4j.repository;

import com.terians.dto.IssueDTO;
import com.terians.neo4j.model.*;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by stromero on 1/4/2015.
 */
@Repository
public interface IssueRepository extends GraphRepository<Issue> {

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) RETURN count(i)")
    public Integer findIssueCountByScan(String scanId);

    @Query("MATCH (i:Issue {teriansId:{0}}) RETURN i")
    public IssueDTO findIssueById(String issueId);

    // Queries for All Issues

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) RETURN i")
    public Set<Issue> findAllIssuesByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) WHERE HAS(i.issue) with distinct i.issue as dissue, count(*) as cissue " +
            "order by cissue desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issue: dissue}) return i2")
    public Set<Issue> findIssuesByScanOrderedByIssueCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) WHERE HAS(i.category) with distinct i.category as dcategory, count(*) as ccategory " +
            "order by ccategory desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {category: dcategory}) return i2")
    public Set<Issue> findIssuesByScanOrderedByCategoryCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) WHERE HAS(i.fileName) with distinct i.fileName as dfileName, count(*) as cfileName " +
            "order by cfileName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {fileName: dfileName}) return i2")
    public Set<Issue> findIssuesByScanOrderedByFileNameCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) WHERE HAS(i.packageName) with distinct i.packageName as dpackageName, count(*) as cpackageName " +
            "order by cpackageName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {packageName: dpackageName}) return i2")
    public Set<Issue> findIssuesByScanOrderedByPackageCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) WHERE HAS(i.className) with distinct i.className as dclassName, count(*) as cclassName " +
            "order by cclassName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {className: dclassName}) return i2")
    public Set<Issue> findIssuesByScanOrderedByClazzCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) WHERE HAS(i.issueType) with distinct i.issueType as dissueType, count(*) as cissueType " +
            "order by cissueType desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issueType: dissueType}) return i2")
    public Set<Issue> findIssuesByScanOrderedByIssueTypeDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) WHERE HAS(i.techDebtMinutes) with distinct i.techDebtMinutes as dtechDebtMinutes, count(*) as ctechDebtMinutes " +
            "order by ctechDebtMinutes desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {techDebtMinutes: dtechDebtMinutes}) return i2")
    public Set<Issue> findIssuesByScanOrderedByTechDebtDesc(String scanId, int limit);

    // Queries for Critical Issues

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) " +
            "WHERE (i.category = \"PERFORMANCE\" OR i.category = \"MALICIOUS CODE VULNERABILITY\" OR i.category = \"SECURITY\") RETURN i")
    public Set<Issue> findAllCriticalIssuesByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.issue) AND (i.category = \"PERFORMANCE\" " +
            "OR i.category = \"MALICIOUS CODE VULNERABILITY\" OR i.category = \"SECURITY\") with distinct i.issue as dissue, count(*) as cissue " +
            "order by cissue desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issue: dissue, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"PERFORMANCE\" OR i2.category = \"MALICIOUS CODE VULNERABILITY\" OR i2.category = \"SECURITY\") return i2")
    public Set<Issue> findCriticalIssuesByScanOrderedByIssueCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.category) AND (i.category = \"PERFORMANCE\" " +
            "OR i.category = \"MALICIOUS CODE VULNERABILITY\" OR i.category = \"SECURITY\") with distinct i.category as dcategory, count(*) as ccategory " +
            "order by ccategory desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {category: dcategory, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"PERFORMANCE\" OR i2.category = \"MALICIOUS CODE VULNERABILITY\" OR i2.category = \"SECURITY\") return i2")
    public Set<Issue> findCriticalIssuesByScanOrderedByCategoryCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.fileName)AND (i.category = \"PERFORMANCE\" " +
            "OR i.category = \"MALICIOUS CODE VULNERABILITY\" OR i.category = \"SECURITY\") with distinct i.fileName as dfileName, count(*) as cfileName " +
            "order by cfileName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {fileName: dfileName, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"PERFORMANCE\" OR i2.category = \"MALICIOUS CODE VULNERABILITY\" OR i2.category = \"SECURITY\") return i2")
    public Set<Issue> findCriticalIssuesByScanOrderedByFileNameCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.packageName) AND (i.category = \"PERFORMANCE\" " +
            "OR i.category = \"MALICIOUS CODE VULNERABILITY\" OR i.category = \"SECURITY\") with distinct i.packageName as dpackageName, count(*) as cpackageName " +
            "order by cpackageName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {packageName: dpackageName, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"PERFORMANCE\" OR i2.category = \"MALICIOUS CODE VULNERABILITY\" OR i2.category = \"SECURITY\") return i2")
    public Set<Issue> findCriticalIssuesByScanOrderedByPackageCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:\"e20e1bb9-8ff9-45ba-bcd2-90ca81f7ef04\"})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) " +
            "WHERE HAS(i.className) AND (i.category = \"PERFORMANCE\" OR i.category = \"MALICIOUS CODE VULNERABILITY\" " +
            "OR i.category = \"SECURITY\") with distinct i.className as dclassName, count(*) as cclassName " +
            "order by cclassName desc Limit {1} MATCH (s:Scan {teriansId:\"e20e1bb9-8ff9-45ba-bcd2-90ca81f7ef04\"}) [:HAS_ISSUE]->(i2:Issue {className: dclassName, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"PERFORMANCE\" OR i2.category = \"MALICIOUS CODE VULNERABILITY\" OR i2.category = \"SECURITY\") return i2")
    public Set<Issue> findCriticalIssuesByScanOrderedByClazzCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.issueType) AND (i.category = \"PERFORMANCE\" " +
            "OR i.category = \"MALICIOUS CODE VULNERABILITY\" OR i.category = \"SECURITY\") with distinct i.issueType as dissueType, count(*) as cissueType " +
            "order by cissueType desc Limit 5{1}MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issueType: dissueType, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"PERFORMANCE\" OR i2.category = \"MALICIOUS CODE VULNERABILITY\" OR i2.category = \"SECURITY\") return i2")
    public Set<Issue> findCriticalIssuesByScanOrderedByIssueTypeDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.techDebtMinutes) AND (i.category = \"PERFORMANCE\" " +
            "OR i.category = \"MALICIOUS CODE VULNERABILITY\" OR i.category = \"SECURITY\") with distinct i.techDebtMinutes as dtechDebtMinutes, count(*) " +
            "as ctechDebtMinutes order by ctechDebtMinutes desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {techDebtMinutes: dtechDebtMinutes, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"PERFORMANCE\" OR i2.category = \"MALICIOUS CODE VULNERABILITY\" OR i2.category = \"SECURITY\") return i2")
    public Set<Issue> findCriticalIssuesByScanOrderedByTechDebtDesc(String scanId, int limit);

    // Queries for High Issues

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE (i.category = \"CORRECTNESS\" " +
            "OR i.category = \"MULTITHREADED CORRECTNESS\") RETURN i")
    public Set<Issue> findAllHighIssuesByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.issue) AND (i.category = \"CORRECTNESS\" " +
            "OR i.category = \"MULTITHREADED CORRECTNESS\") with distinct i.issue as dissue, count(*) as cissue " +
            "order by cissue desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issue: dissue, scanTool:\"FINDBUGS\"}) WHERE (i2.category = \"CORRECTNESS\" " +
            "OR i2.category = \"MULTITHREADED CORRECTNESS\") return i2")
    public Set<Issue> findHighIssuesByScanOrderedByIssueCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.category)  AND (i.category = \"CORRECTNESS\" " +
            "OR i.category = \"MULTITHREADED CORRECTNESS\") with distinct i.category as dcategory, count(*) as ccategory order by ccategory desc Limit {1} " +
            "MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {category: dcategory, scanTool:\"FINDBUGS\"}) WHERE (i2.category = \"CORRECTNESS\" " +
            "OR i2.category = \"MULTITHREADED CORRECTNESS\") return i2")
    public Set<Issue> findHighIssuesByScanOrderedByCategoryCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.fileName) AND (i.category = \"CORRECTNESS\" " +
            "OR i.category = \"MULTITHREADED CORRECTNESS\") with distinct i.fileName as dfileName, count(*) as cfileName order by cfileName desc Limit {1} " +
            "MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {fileName: dfileName, scanTool:\"FINDBUGS\"}) WHERE (i2.category = \"CORRECTNESS\" " +
            "OR i2.category = \"MULTITHREADED CORRECTNESS\") return i2")
    public Set<Issue> findHighIssuesByScanOrderedByFileNameCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.packageName) AND (i.category = \"CORRECTNESS\" " +
            "OR i.category = \"MULTITHREADED CORRECTNESS\") with distinct i.packageName as dpackageName, count(*) as cpackageName " +
            "order by cpackageName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {packageName: dpackageName, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"CORRECTNESS\" OR i2.category = \"MULTITHREADED CORRECTNESS\") return i2")
    public Set<Issue> findHighIssuesByScanOrderedByPackageCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.className) AND (i.category = \"CORRECTNESS\" " +
            "OR i.category = \"MULTITHREADED CORRECTNESS\") with distinct i.className as dclassName, count(*) as cclassName " +
            "order by cclassName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {className: dclassName, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"CORRECTNESS\" OR i2.category = \"MULTITHREADED CORRECTNESS\") return i2")
    public Set<Issue> findHighIssuesByScanOrderedByClazzCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.issueType) AND (i.category = \"CORRECTNESS\" " +
            "OR i.category = \"MULTITHREADED CORRECTNESS\") with distinct i.issueType as dissueType, count(*) as cissueType order by cissueType desc Limit {1} " +
            "MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issueType: dissueType, scanTool:\"FINDBUGS\"}) WHERE (i2.category = \"CORRECTNESS\" " +
            "OR i2.category = \"MULTITHREADED CORRECTNESS\") return i2")
    public Set<Issue> findHighIssuesByScanOrderedByIssueTypeDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.techDebtMinutes) AND (i.category = \"CORRECTNESS\" " +
            "OR i.category = \"MULTITHREADED CORRECTNESS\") with distinct i.techDebtMinutes as dtechDebtMinutes, count(*) as ctechDebtMinutes order by " +
            "ctechDebtMinutes desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {techDebtMinutes: dtechDebtMinutes, " +
            "scanTool:\"FINDBUGS\"}) WHERE (i2.category = \"CORRECTNESS\" OR i2.category = \"MULTITHREADED CORRECTNESS\") return i2")
    public Set<Issue> findHighIssuesByScanOrderedByTechDebtDesc(String scanId, int limit);

    // Queries for Medium Issues

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE (i.category = \"INTERNATIONALIZATION\" " +
            "OR i.category = \"STYLE\" OR i.category = \"DODGY CODE\" OR i.category = \"EXPERIMENTAL\") RETURN i")
    public Set<Issue> findAllMediumIssuesByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.issue) AND (i.category = \"INTERNATIONALIZATION\" " +
            "OR i.category = \"STYLE\" OR i.category = \"DODGY CODE\" OR i.category = \"EXPERIMENTAL\" ) with distinct i.issue as dissue, count(*) as cissue " +
            "order by cissue desc Limit {1}} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issue: dissue, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"INTERNATIONALIZATION\" OR i2.category = \"STYLE\" OR i2.category = \"DODGY CODE\" OR i2.category = \"EXPERIMENTAL\") return i2")
    public Set<Issue> findMediumIssuesByScanOrderedByIssueCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.category)  AND (i.category = \"INTERNATIONALIZATION\" " +
            "OR i.category = \"STYLE\" OR i.category = \"DODGY CODE\" OR i.category = \"EXPERIMENTAL\") with distinct i.category as dcategory, " +
            "count(*) as ccategory order by ccategory desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {category: dcategory, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"INTERNATIONALIZATION\" OR i2.category = \"STYLE\" OR i2.category = \"DODGY CODE\" OR i2.category = \"EXPERIMENTAL\") return i2")
    public Set<Issue> findMediumIssuesByScanOrderedByCategoryCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.fileName) AND (i.category = \"INTERNATIONALIZATION\" " +
            "OR i.category = \"STYLE\" OR i.category = \"DODGY CODE\" OR i.category = \"EXPERIMENTAL\") with distinct i.fileName as dfileName, count(*) as cfileName " +
            "order by cfileName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {fileName: dfileName, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"INTERNATIONALIZATION\" OR i2.category = \"STYLE\" OR i2.category = \"DODGY CODE\" OR i2.category = \"EXPERIMENTAL\") return i2")
    public Set<Issue> findMediumIssuesByScanOrderedByFileNameCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.packageName) AND (i.category = \"INTERNATIONALIZATION\" " +
            "OR i.category = \"STYLE\" OR i.category = \"DODGY CODE\" OR i.category = \"EXPERIMENTAL\") with distinct i.packageName as dpackageName, count(*) as cpackageName " +
            "order by cpackageName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {packageName: dpackageName, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"INTERNATIONALIZATION\" OR i2.category = \"STYLE\" OR i2.category = \"DODGY CODE\" OR i2.category = \"EXPERIMENTAL\") return i2")
    public Set<Issue> findMediumIssuesByScanOrderedByPackageCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.className) AND (i.category = \"INTERNATIONALIZATION\" " +
            "OR i.category = \"STYLE\" OR i.category = \"DODGY CODE\" OR i.category = \"EXPERIMENTAL\") with distinct i.className as dclassName, count(*) as cclassName " +
            "order by cclassName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {className: dclassName, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"INTERNATIONALIZATION\" OR i2.category = \"STYLE\" OR i2.category = \"DODGY CODE\" OR i2.category = \"EXPERIMENTAL\") return i2")
    public Set<Issue> findMediumIssuesByScanOrderedByClazzCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.issueType) AND (i.category = \"INTERNATIONALIZATION\" " +
            "OR i.category = \"STYLE\" OR i.category = \"DODGY CODE\" OR i.category = \"EXPERIMENTAL\") with distinct i.issueType as dissueType, count(*) as cissueType " +
            "order by cissueType desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issueType: dissueType, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"INTERNATIONALIZATION\" OR i2.category = \"STYLE\" OR i2.category = \"DODGY CODE\" OR i2.category = \"EXPERIMENTAL\") return i2")
    public Set<Issue> findMediumIssuesByScanOrderedByIssueTypeDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.techDebtMinutes) AND (i.category = \"INTERNATIONALIZATION\" " +
            "OR i.category = \"STYLE\" OR i.category = \"DODGY CODE\" OR i.category = \"EXPERIMENTAL\") with distinct i.techDebtMinutes as dtechDebtMinutes, count(*) as ctechDebtMinutes " +
            "order by ctechDebtMinutes desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {techDebtMinutes: dtechDebtMinutes, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"INTERNATIONALIZATION\" OR i2.category = \"STYLE\" OR i2.category = \"DODGY CODE\" OR i2.category = \"EXPERIMENTAL\") return i2")
    public Set<Issue> findMediumIssuesByScanOrderedByTechDebtDesc(String scanId, int limit);

    // Queries for Low Issues

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"PMD\"}) RETURN i")
    public Set<Issue> findAllLowIssuesByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"PMD\"}) WHERE HAS(i.issue) with distinct i.issue as dissue, " +
            "count(*) as cissue order by cissue desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issue: dissue, scanTool:\"PMD\"}) return i2")
    public Set<Issue> findLowIssuesByScanOrderedByIssueCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"PMD\"}) WHERE HAS(i.category) with distinct i.category as dcategory, count(*) as ccategory " +
            "order by ccategory desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {category: dcategory, scanTool:\"PMD\"}) return i2")
    public Set<Issue> findMLowIssuesByScanOrderedByCategoryCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"PMD\"}) WHERE HAS(i.fileName) with distinct i.fileName as dfileName, count(*) as cfileName " +
            "order by cfileName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {fileName: dfileName, scanTool:\"PMD\"}) return i2")
    public Set<Issue> findLowIssuesByScanOrderedByFileNameCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"PMD\"}) WHERE HAS(i.packageName) with distinct i.packageName as dpackageName, count(*) as cpackageName " +
            "order by cpackageName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {packageName: dpackageName, scanTool:\"PMD\"}) return i2")
    public Set<Issue> findLowIssuesByScanOrderedByPackageCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"PMD\"}) WHERE HAS(i.className) with distinct i.className as dclassName, count(*) as cclassName " +
            "order by cclassName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {className: dclassName, scanTool:\"PMD\"}) return i2")
    public Set<Issue> findLowIssuesByScanOrderedByClazzCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"PMD\"}) WHERE HAS(i.issueType) with distinct i.issueType as dissueType, count(*) as cissueType " +
            "order by cissueType desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issueType: dissueType, scanTool:\"PMD\"}) return i2")
    public Set<Issue> findLowIssuesByScanOrderedByIssueTypeDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"PMD\"}) WHERE HAS(i.techDebtMinutes) with distinct i.techDebtMinutes as dtechDebtMinutes, " +
            "count(*) as ctechDebtMinutes order by ctechDebtMinutes desc Limit {1} " +
            "MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {techDebtMinutes: dtechDebtMinutes, scanTool:\"PMD\"}) return i2")
    public Set<Issue> findLowIssuesByScanOrderedByTechDebtDesc(String scanId, int limit);

    // Queries for Best Practices Issues

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"CHECKSTYLE\"}) RETURN i")
    public Set<Issue> findAllBestPracticesIssuesByScan(String scanId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"CHECKSTYLE\"}) WHERE HAS(i.issue) with distinct i.issue as dissue, count(*) as cissue " +
            "order by cissue desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issue: dissue, scanTool:\"CHECKSTYLE\"}) return i2")
    public Set<Issue> findBestPracticesIssuesByScanOrderedByIssueCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"CHECKSTYLE\"}) WHERE HAS(i.category) with distinct i.category as dcategory, count(*) as ccategory " +
            "order by ccategory desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {category: dcategory, scanTool:\"CHECKSTYLE\"}) return i2")
    public Set<Issue> findBestPracticesIssuesByScanOrderedByCategoryCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"CHECKSTYLE\"}) WHERE HAS(i.fileName) with distinct i.fileName as dfileName, count(*) as cfileName " +
            "order by cfileName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {fileName: dfileName, scanTool:\"CHECKSTYLE\"}) return i2")
    public Set<Issue> findBestPracticesIssuesByScanOrderedByFileNameCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"CHECKSTYLE\"}) WHERE HAS(i.packageName) with distinct i.packageName as dpackageName, " +
            "count(*) as cpackageName order by cpackageName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {packageName: dpackageName, scanTool:\"CHECKSTYLE\"}) return i2")
    public Set<Issue> findBestPracticesIssuesByScanOrderedByPackageCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"CHECKSTYLE\"}) WHERE HAS(i.className) with distinct i.className as dclassName, count(*) as cclassName " +
            "order by cclassName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {className: dclassName, scanTool:\"CHECKSTYLE\"}) return i2")
    public Set<Issue> findBestPracticesIssuesByScanOrderedByClazzCountDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"CHECKSTYLE\"}) WHERE HAS(i.issueType) with distinct i.issueType as dissueType, count(*) as cissueType " +
            "order by cissueType desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issueType: dissueType, scanTool:\"CHECKSTYLE\"}) return i2")
    public Set<Issue> findBestPracticesIssuesByScanOrderedByIssueTypeDesc(String scanId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"CHECKSTYLE\"}) WHERE HAS(i.techDebtMinutes) with distinct i.techDebtMinutes as dtechDebtMinutes, " +
            "count(*) as ctechDebtMinutes order by ctechDebtMinutes desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue " +
            "{techDebtMinutes: dtechDebtMinutes, scanTool:\"CHECKSTYLE\"}) return i2")
    public Set<Issue> findBestPracticesIssuesByScanOrderedByTechDebtDesc(String scanId, int limit);

}
