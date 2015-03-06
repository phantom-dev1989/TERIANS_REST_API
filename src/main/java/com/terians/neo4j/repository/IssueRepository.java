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
    public Integer findIssueCountByScan(String teriansId);

    @Query("MATCH (i:Issue {teriansId:{0}}) RETURN i")
    public IssueDTO findIssueById(String issueId);

    // Queries for All Issues

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) RETURN i")
    public Set<Issue> findAllIssuesByScan(String teriansId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) WHERE HAS(i.issue) with distinct i.issue as dissue, count(*) as cissue " +
            "order by cissue desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issue: dissue}) return i2")
    public Set<Issue> findIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) WHERE HAS(i.category) with distinct i.category as dcategory, count(*) as ccategory " +
            "order by ccategory desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {category: dcategory}) return i2")
    public Set<Issue> findIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) WHERE HAS(i.fileName) with distinct i.fileName as dfileName, count(*) as cfileName " +
            "order by cfileName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {fileName: dfileName}) return i2")
    public Set<Issue> findIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) WHERE HAS(i.packageName) with distinct i.packageName as dpackageName, count(*) as cpackageName " +
            "order by cpackageName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {packageName: dpackageName}) return i2")
    public Set<Issue> findIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) WHERE HAS(i.className) with distinct i.className as dclassName, count(*) as cclassName " +
            "order by cclassName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {className: dclassName}) return i2")
    public Set<Issue> findIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) WHERE HAS(i.issueType) with distinct i.issueType as dissueType, count(*) as cissueType " +
            "order by cissueType desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issueType: dissueType}) return i2")
    public Set<Issue> findIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue) WHERE HAS(i.techDebtMinutes) with distinct i.techDebtMinutes as dtechDebtMinutes, count(*) as ctechDebtMinutes " +
            "order by ctechDebtMinutes desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {techDebtMinutes: dtechDebtMinutes}) return i2")
    public Set<Issue> findIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit);

    // Queries for Critical Issues

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) " +
            "WHERE (i.category = \"PERFORMANCE\" OR i.category = \"MALICIOUS CODE VULNERABILITY\" OR i.category = \"SECURITY\") RETURN i")
    public Set<Issue> findAllCriticalIssuesByScan(String teriansId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.issue) AND (i.category = \"PERFORMANCE\" " +
            "OR i.category = \"MALICIOUS CODE VULNERABILITY\" OR i.category = \"SECURITY\") with distinct i.issue as dissue, count(*) as cissue " +
            "order by cissue desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issue: dissue, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"PERFORMANCE\" OR i2.category = \"MALICIOUS CODE VULNERABILITY\" OR i2.category = \"SECURITY\") return i2")
    public Set<Issue> findCriticalIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.category) AND (i.category = \"PERFORMANCE\" " +
            "OR i.category = \"MALICIOUS CODE VULNERABILITY\" OR i.category = \"SECURITY\") with distinct i.category as dcategory, count(*) as ccategory " +
            "order by ccategory desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {category: dcategory, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"PERFORMANCE\" OR i2.category = \"MALICIOUS CODE VULNERABILITY\" OR i2.category = \"SECURITY\") return i2")
    public Set<Issue> findCriticalIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.fileName)AND (i.category = \"PERFORMANCE\" " +
            "OR i.category = \"MALICIOUS CODE VULNERABILITY\" OR i.category = \"SECURITY\") with distinct i.fileName as dfileName, count(*) as cfileName " +
            "order by cfileName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {fileName: dfileName, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"PERFORMANCE\" OR i2.category = \"MALICIOUS CODE VULNERABILITY\" OR i2.category = \"SECURITY\") return i2")
    public Set<Issue> findCriticalIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.packageName) AND (i.category = \"PERFORMANCE\" " +
            "OR i.category = \"MALICIOUS CODE VULNERABILITY\" OR i.category = \"SECURITY\") with distinct i.packageName as dpackageName, count(*) as cpackageName " +
            "order by cpackageName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {packageName: dpackageName, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"PERFORMANCE\" OR i2.category = \"MALICIOUS CODE VULNERABILITY\" OR i2.category = \"SECURITY\") return i2")
    public Set<Issue> findCriticalIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:\"e20e1bb9-8ff9-45ba-bcd2-90ca81f7ef04\"})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) " +
            "WHERE HAS(i.className) AND (i.category = \"PERFORMANCE\" OR i.category = \"MALICIOUS CODE VULNERABILITY\" " +
            "OR i.category = \"SECURITY\") with distinct i.className as dclassName, count(*) as cclassName " +
            "order by cclassName desc Limit {1} MATCH (s:Scan {teriansId:\"e20e1bb9-8ff9-45ba-bcd2-90ca81f7ef04\"}) [:HAS_ISSUE]->(i2:Issue {className: dclassName, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"PERFORMANCE\" OR i2.category = \"MALICIOUS CODE VULNERABILITY\" OR i2.category = \"SECURITY\") return i2")
    public Set<Issue> findCriticalIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.issueType) AND (i.category = \"PERFORMANCE\" " +
            "OR i.category = \"MALICIOUS CODE VULNERABILITY\" OR i.category = \"SECURITY\") with distinct i.issueType as dissueType, count(*) as cissueType " +
            "order by cissueType desc Limit 5{1}MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issueType: dissueType, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"PERFORMANCE\" OR i2.category = \"MALICIOUS CODE VULNERABILITY\" OR i2.category = \"SECURITY\") return i2")
    public Set<Issue> findCriticalIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.techDebtMinutes) AND (i.category = \"PERFORMANCE\" " +
            "OR i.category = \"MALICIOUS CODE VULNERABILITY\" OR i.category = \"SECURITY\") with distinct i.techDebtMinutes as dtechDebtMinutes, count(*) " +
            "as ctechDebtMinutes order by ctechDebtMinutes desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {techDebtMinutes: dtechDebtMinutes, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"PERFORMANCE\" OR i2.category = \"MALICIOUS CODE VULNERABILITY\" OR i2.category = \"SECURITY\") return i2")
    public Set<Issue> findCriticalIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit);

    // Queries for High Issues

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE (i.category = \"CORRECTNESS\" " +
            "OR i.category = \"MULTITHREADED CORRECTNESS\") RETURN i")
    public Set<Issue> findAllHighIssuesByScan(String teriansId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.issue) AND (i.category = \"CORRECTNESS\" " +
            "OR i.category = \"MULTITHREADED CORRECTNESS\") with distinct i.issue as dissue, count(*) as cissue " +
            "order by cissue desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issue: dissue, scanTool:\"FINDBUGS\"}) WHERE (i2.category = \"CORRECTNESS\" " +
            "OR i2.category = \"MULTITHREADED CORRECTNESS\") return i2")
    public Set<Issue> findHighIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.category)  AND (i.category = \"CORRECTNESS\" " +
            "OR i.category = \"MULTITHREADED CORRECTNESS\") with distinct i.category as dcategory, count(*) as ccategory order by ccategory desc Limit {1} " +
            "MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {category: dcategory, scanTool:\"FINDBUGS\"}) WHERE (i2.category = \"CORRECTNESS\" " +
            "OR i2.category = \"MULTITHREADED CORRECTNESS\") return i2")
    public Set<Issue> findHighIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.fileName) AND (i.category = \"CORRECTNESS\" " +
            "OR i.category = \"MULTITHREADED CORRECTNESS\") with distinct i.fileName as dfileName, count(*) as cfileName order by cfileName desc Limit {1} " +
            "MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {fileName: dfileName, scanTool:\"FINDBUGS\"}) WHERE (i2.category = \"CORRECTNESS\" " +
            "OR i2.category = \"MULTITHREADED CORRECTNESS\") return i2")
    public Set<Issue> findHighIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.packageName) AND (i.category = \"CORRECTNESS\" " +
            "OR i.category = \"MULTITHREADED CORRECTNESS\") with distinct i.packageName as dpackageName, count(*) as cpackageName " +
            "order by cpackageName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {packageName: dpackageName, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"CORRECTNESS\" OR i2.category = \"MULTITHREADED CORRECTNESS\") return i2")
    public Set<Issue> findHighIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.className) AND (i.category = \"CORRECTNESS\" " +
            "OR i.category = \"MULTITHREADED CORRECTNESS\") with distinct i.className as dclassName, count(*) as cclassName " +
            "order by cclassName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {className: dclassName, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"CORRECTNESS\" OR i2.category = \"MULTITHREADED CORRECTNESS\") return i2")
    public Set<Issue> findHighIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.issueType) AND (i.category = \"CORRECTNESS\" " +
            "OR i.category = \"MULTITHREADED CORRECTNESS\") with distinct i.issueType as dissueType, count(*) as cissueType order by cissueType desc Limit {1} " +
            "MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issueType: dissueType, scanTool:\"FINDBUGS\"}) WHERE (i2.category = \"CORRECTNESS\" " +
            "OR i2.category = \"MULTITHREADED CORRECTNESS\") return i2")
    public Set<Issue> findHighIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.techDebtMinutes) AND (i.category = \"CORRECTNESS\" " +
            "OR i.category = \"MULTITHREADED CORRECTNESS\") with distinct i.techDebtMinutes as dtechDebtMinutes, count(*) as ctechDebtMinutes order by " +
            "ctechDebtMinutes desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {techDebtMinutes: dtechDebtMinutes, " +
            "scanTool:\"FINDBUGS\"}) WHERE (i2.category = \"CORRECTNESS\" OR i2.category = \"MULTITHREADED CORRECTNESS\") return i2")
    public Set<Issue> findHighIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit);

    // Queries for Medium Issues

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE (i.category = \"INTERNATIONALIZATION\" " +
            "OR i.category = \"STYLE\" OR i.category = \"DODGY CODE\" OR i.category = \"EXPERIMENTAL\") RETURN i")
    public Set<Issue> findAllMediumIssuesByScan(String teriansId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.issue) AND (i.category = \"INTERNATIONALIZATION\" " +
            "OR i.category = \"STYLE\" OR i.category = \"DODGY CODE\" OR i.category = \"EXPERIMENTAL\" ) with distinct i.issue as dissue, count(*) as cissue " +
            "order by cissue desc Limit {1}} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issue: dissue, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"INTERNATIONALIZATION\" OR i2.category = \"STYLE\" OR i2.category = \"DODGY CODE\" OR i2.category = \"EXPERIMENTAL\") return i2")
    public Set<Issue> findMediumIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.category)  AND (i.category = \"INTERNATIONALIZATION\" " +
            "OR i.category = \"STYLE\" OR i.category = \"DODGY CODE\" OR i.category = \"EXPERIMENTAL\") with distinct i.category as dcategory, " +
            "count(*) as ccategory order by ccategory desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {category: dcategory, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"INTERNATIONALIZATION\" OR i2.category = \"STYLE\" OR i2.category = \"DODGY CODE\" OR i2.category = \"EXPERIMENTAL\") return i2")
    public Set<Issue> findMediumIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.fileName) AND (i.category = \"INTERNATIONALIZATION\" " +
            "OR i.category = \"STYLE\" OR i.category = \"DODGY CODE\" OR i.category = \"EXPERIMENTAL\") with distinct i.fileName as dfileName, count(*) as cfileName " +
            "order by cfileName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {fileName: dfileName, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"INTERNATIONALIZATION\" OR i2.category = \"STYLE\" OR i2.category = \"DODGY CODE\" OR i2.category = \"EXPERIMENTAL\") return i2")
    public Set<Issue> findMediumIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.packageName) AND (i.category = \"INTERNATIONALIZATION\" " +
            "OR i.category = \"STYLE\" OR i.category = \"DODGY CODE\" OR i.category = \"EXPERIMENTAL\") with distinct i.packageName as dpackageName, count(*) as cpackageName " +
            "order by cpackageName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {packageName: dpackageName, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"INTERNATIONALIZATION\" OR i2.category = \"STYLE\" OR i2.category = \"DODGY CODE\" OR i2.category = \"EXPERIMENTAL\") return i2")
    public Set<Issue> findMediumIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.className) AND (i.category = \"INTERNATIONALIZATION\" " +
            "OR i.category = \"STYLE\" OR i.category = \"DODGY CODE\" OR i.category = \"EXPERIMENTAL\") with distinct i.className as dclassName, count(*) as cclassName " +
            "order by cclassName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {className: dclassName, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"INTERNATIONALIZATION\" OR i2.category = \"STYLE\" OR i2.category = \"DODGY CODE\" OR i2.category = \"EXPERIMENTAL\") return i2")
    public Set<Issue> findMediumIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.issueType) AND (i.category = \"INTERNATIONALIZATION\" " +
            "OR i.category = \"STYLE\" OR i.category = \"DODGY CODE\" OR i.category = \"EXPERIMENTAL\") with distinct i.issueType as dissueType, count(*) as cissueType " +
            "order by cissueType desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issueType: dissueType, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"INTERNATIONALIZATION\" OR i2.category = \"STYLE\" OR i2.category = \"DODGY CODE\" OR i2.category = \"EXPERIMENTAL\") return i2")
    public Set<Issue> findMediumIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"FINDBUGS\"}) WHERE HAS(i.techDebtMinutes) AND (i.category = \"INTERNATIONALIZATION\" " +
            "OR i.category = \"STYLE\" OR i.category = \"DODGY CODE\" OR i.category = \"EXPERIMENTAL\") with distinct i.techDebtMinutes as dtechDebtMinutes, count(*) as ctechDebtMinutes " +
            "order by ctechDebtMinutes desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {techDebtMinutes: dtechDebtMinutes, scanTool:\"FINDBUGS\"}) " +
            "WHERE (i2.category = \"INTERNATIONALIZATION\" OR i2.category = \"STYLE\" OR i2.category = \"DODGY CODE\" OR i2.category = \"EXPERIMENTAL\") return i2")
    public Set<Issue> findMediumIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit);

    // Queries for Low Issues

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"PMD\"}) RETURN i")
    public Set<Issue> findAllLowIssuesByScan(String teriansId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"PMD\"}) WHERE HAS(i.issue) with distinct i.issue as dissue, " +
            "count(*) as cissue order by cissue desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issue: dissue, scanTool:\"PMD\"}) return i2")
    public Set<Issue> findLowIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"PMD\"}) WHERE HAS(i.category) with distinct i.category as dcategory, count(*) as ccategory " +
            "order by ccategory desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {category: dcategory, scanTool:\"PMD\"}) return i2")
    public Set<Issue> findMLowIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"PMD\"}) WHERE HAS(i.fileName) with distinct i.fileName as dfileName, count(*) as cfileName " +
            "order by cfileName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {fileName: dfileName, scanTool:\"PMD\"}) return i2")
    public Set<Issue> findLowIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"PMD\"}) WHERE HAS(i.packageName) with distinct i.packageName as dpackageName, count(*) as cpackageName " +
            "order by cpackageName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {packageName: dpackageName, scanTool:\"PMD\"}) return i2")
    public Set<Issue> findLowIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"PMD\"}) WHERE HAS(i.className) with distinct i.className as dclassName, count(*) as cclassName " +
            "order by cclassName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {className: dclassName, scanTool:\"PMD\"}) return i2")
    public Set<Issue> findLowIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"PMD\"}) WHERE HAS(i.issueType) with distinct i.issueType as dissueType, count(*) as cissueType " +
            "order by cissueType desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issueType: dissueType, scanTool:\"PMD\"}) return i2")
    public Set<Issue> findLowIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"PMD\"}) WHERE HAS(i.techDebtMinutes) with distinct i.techDebtMinutes as dtechDebtMinutes, " +
            "count(*) as ctechDebtMinutes order by ctechDebtMinutes desc Limit {1} " +
            "MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {techDebtMinutes: dtechDebtMinutes, scanTool:\"PMD\"}) return i2")
    public Set<Issue> findLowIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit);

    // Queries for Best Practices Issues

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"CHECKSTYLE\"}) RETURN i")
    public Set<Issue> findAllBestPracticesIssuesByScan(String teriansId);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"CHECKSTYLE\"}) WHERE HAS(i.issue) with distinct i.issue as dissue, count(*) as cissue " +
            "order by cissue desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issue: dissue, scanTool:\"CHECKSTYLE\"}) return i2")
    public Set<Issue> findBestPracticesIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"CHECKSTYLE\"}) WHERE HAS(i.category) with distinct i.category as dcategory, count(*) as ccategory " +
            "order by ccategory desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {category: dcategory, scanTool:\"CHECKSTYLE\"}) return i2")
    public Set<Issue> findBestPracticesIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"CHECKSTYLE\"}) WHERE HAS(i.fileName) with distinct i.fileName as dfileName, count(*) as cfileName " +
            "order by cfileName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {fileName: dfileName, scanTool:\"CHECKSTYLE\"}) return i2")
    public Set<Issue> findBestPracticesIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"CHECKSTYLE\"}) WHERE HAS(i.packageName) with distinct i.packageName as dpackageName, " +
            "count(*) as cpackageName order by cpackageName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {packageName: dpackageName, scanTool:\"CHECKSTYLE\"}) return i2")
    public Set<Issue> findBestPracticesIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"CHECKSTYLE\"}) WHERE HAS(i.className) with distinct i.className as dclassName, count(*) as cclassName " +
            "order by cclassName desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {className: dclassName, scanTool:\"CHECKSTYLE\"}) return i2")
    public Set<Issue> findBestPracticesIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"CHECKSTYLE\"}) WHERE HAS(i.issueType) with distinct i.issueType as dissueType, count(*) as cissueType " +
            "order by cissueType desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue {issueType: dissueType, scanTool:\"CHECKSTYLE\"}) return i2")
    public Set<Issue> findBestPracticesIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit);

    @Query("MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i:Issue {scanTool:\"CHECKSTYLE\"}) WHERE HAS(i.techDebtMinutes) with distinct i.techDebtMinutes as dtechDebtMinutes, " +
            "count(*) as ctechDebtMinutes order by ctechDebtMinutes desc Limit {1} MATCH (s:Scan {teriansId:{0}})-[:HAS_ISSUE]->(i2:Issue " +
            "{techDebtMinutes: dtechDebtMinutes, scanTool:\"CHECKSTYLE\"}) return i2")
    public Set<Issue> findBestPracticesIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit);

}
