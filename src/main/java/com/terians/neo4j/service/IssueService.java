package com.terians.neo4j.service;


import com.terians.dto.IssueDTO;
import com.terians.dto.IssuesDTO;

/**
 * Created by stromero on 1/4/2015.
 */
 public interface IssueService {
    
     Integer findIssueCountByScan(String scanId);

     IssueDTO findIssue(String issueId);

     IssuesDTO findAllIssues(String category, String orderedBy);

    // Queries for All Issues

     IssuesDTO findAllIssuesByScan(String scanId);

     IssuesDTO findIssuesByScanOrderedByIssueCountDesc(String scanId, int limit);

     IssuesDTO findIssuesByScanOrderedByCategoryCountDesc(String scanId, int limit);

     IssuesDTO findIssuesByScanOrderedByFileNameCountDesc(String scanId, int limit);

     IssuesDTO findIssuesByScanOrderedByPackageCountDesc(String scanId, int limit);

     IssuesDTO findIssuesByScanOrderedByClazzCountDesc(String scanId, int limit);

     IssuesDTO findIssuesByScanOrderedByIssueTypeDesc(String scanId, int limit);

     IssuesDTO findIssuesByScanOrderedByTechDebtDesc(String scanId, int limit);

    // Queries for Critical Issues
     IssuesDTO findAllCriticalIssuesByScan(String scanId);

     IssuesDTO findCriticalIssuesByScanOrderedByIssueCountDesc(String scanId, int limit);

     IssuesDTO findCriticalIssuesByScanOrderedByCategoryCountDesc(String scanId, int limit);

     IssuesDTO findCriticalIssuesByScanOrderedByFileNameCountDesc(String scanId, int limit);

     IssuesDTO findCriticalIssuesByScanOrderedByPackageCountDesc(String scanId, int limit);

     IssuesDTO findCriticalIssuesByScanOrderedByClazzCountDesc(String scanId, int limit);

     IssuesDTO findCriticalIssuesByScanOrderedByIssueTypeDesc(String scanId, int limit);

     IssuesDTO findCriticalIssuesByScanOrderedByTechDebtDesc(String scanId, int limit);

    // Queries for High Issues

     IssuesDTO findAllHighIssuesByScan(String scanId);

     IssuesDTO findHighIssuesByScanOrderedByIssueCountDesc(String scanId, int limit);

     IssuesDTO findHighIssuesByScanOrderedByCategoryCountDesc(String scanId, int limit);

     IssuesDTO findHighIssuesByScanOrderedByFileNameCountDesc(String scanId, int limit);

     IssuesDTO findHighIssuesByScanOrderedByPackageCountDesc(String scanId, int limit);

     IssuesDTO findHighIssuesByScanOrderedByClazzCountDesc(String scanId, int limit);

     IssuesDTO findHighIssuesByScanOrderedByIssueTypeDesc(String scanId, int limit);

     IssuesDTO findHighIssuesByScanOrderedByTechDebtDesc(String scanId, int limit);

    // Queries for Medium Issues

     IssuesDTO findAllMediumIssuesByScan(String scanId);

     IssuesDTO findMediumIssuesByScanOrderedByIssueCountDesc(String scanId, int limit);

     IssuesDTO findMediumIssuesByScanOrderedByCategoryCountDesc(String scanId, int limit);

     IssuesDTO findMediumIssuesByScanOrderedByFileNameCountDesc(String scanId, int limit);

     IssuesDTO findMediumIssuesByScanOrderedByPackageCountDesc(String scanId, int limit);

     IssuesDTO findMediumIssuesByScanOrderedByClazzCountDesc(String scanId, int limit);

     IssuesDTO findMediumIssuesByScanOrderedByIssueTypeDesc(String scanId, int limit);

     IssuesDTO findMediumIssuesByScanOrderedByTechDebtDesc(String scanId, int limit);

    // Queries for Low Issues
     IssuesDTO findAllLowIssuesByScan(String scanId);

     IssuesDTO findLowIssuesByScanOrderedByIssueCountDesc(String scanId, int limit);

     IssuesDTO findMLowIssuesByScanOrderedByCategoryCountDesc(String scanId, int limit);

     IssuesDTO findLowIssuesByScanOrderedByFileNameCountDesc(String scanId, int limit);

     IssuesDTO findLowIssuesByScanOrderedByPackageCountDesc(String scanId, int limit);

     IssuesDTO findLowIssuesByScanOrderedByClazzCountDesc(String scanId, int limit);

     IssuesDTO findLowIssuesByScanOrderedByIssueTypeDesc(String scanId, int limit);

     IssuesDTO findLowIssuesByScanOrderedByTechDebtDesc(String scanId, int limit);

    // Queries for Best Practices Issues

     IssuesDTO findAllBestPracticesIssuesByScan(String scanId);

     IssuesDTO findBestPracticesIssuesByScanOrderedByIssueCountDesc(String scanId, int limit);

     IssuesDTO findBestPracticesIssuesByScanOrderedByCategoryCountDesc(String scanId, int limit);

     IssuesDTO findBestPracticesIssuesByScanOrderedByFileNameCountDesc(String scanId, int limit);

     IssuesDTO findBestPracticesIssuesByScanOrderedByPackageCountDesc(String scanId, int limit);

     IssuesDTO findBestPracticesIssuesByScanOrderedByClazzCountDesc(String scanId, int limit);

     IssuesDTO findBestPracticesIssuesByScanOrderedByIssueTypeDesc(String scanId, int limit);

     IssuesDTO findBestPracticesIssuesByScanOrderedByTechDebtDesc(String scanId, int limit);


}

