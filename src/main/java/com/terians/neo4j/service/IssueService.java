package com.terians.neo4j.service;


import com.terians.dto.IssueDTO;
import com.terians.dto.IssuesDTO;

/**
 * Created by stromero on 1/4/2015.
 */
public interface IssueService {
    
    public Integer findIssueCountByScan(String teriansId);

    public IssueDTO findIssueById(String issueId);

    // Queries for All Issues
    
    public IssuesDTO findAllIssuesByScan(String teriansId);
    
    public IssuesDTO findIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit);
    
    public IssuesDTO findIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit);
    
    public IssuesDTO findIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit);
    
    public IssuesDTO findIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit);
    
    public IssuesDTO findIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit);
    
    public IssuesDTO findIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit);
    
    public IssuesDTO findIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit);

    // Queries for Critical Issues
    public IssuesDTO findAllCriticalIssuesByScan(String teriansId);
    
    public IssuesDTO findCriticalIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit);
    
    public IssuesDTO findCriticalIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit);
    
    public IssuesDTO findCriticalIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit);
    
    public IssuesDTO findCriticalIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit);
    
    public IssuesDTO findCriticalIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit);
    
    public IssuesDTO findCriticalIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit);
    
    public IssuesDTO findCriticalIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit);

    // Queries for High Issues
    
    public IssuesDTO findAllHighIssuesByScan(String teriansId);
    
    public IssuesDTO findHighIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit);
    
    public IssuesDTO findHighIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit);
    
    public IssuesDTO findHighIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit);
    
    public IssuesDTO findHighIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit);
    
    public IssuesDTO findHighIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit);
    
    public IssuesDTO findHighIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit);
    
    public IssuesDTO findHighIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit);

    // Queries for Medium Issues
    
    public IssuesDTO findAllMediumIssuesByScan(String teriansId);
    
    public IssuesDTO findMediumIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit);
    
    public IssuesDTO findMediumIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit);

    public IssuesDTO findMediumIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit);
    
    public IssuesDTO findMediumIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit);
    
    public IssuesDTO findMediumIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit);

    public IssuesDTO findMediumIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit);
    
    public IssuesDTO findMediumIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit);

    // Queries for Low Issues
    public IssuesDTO findAllLowIssuesByScan(String teriansId);
    
    public IssuesDTO findLowIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit);
    
    public IssuesDTO findMLowIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit);
    
    public IssuesDTO findLowIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit);
    
    public IssuesDTO findLowIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit);
    
    public IssuesDTO findLowIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit);
    
    public IssuesDTO findLowIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit);
    
    public IssuesDTO findLowIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit);

    // Queries for Best Practices Issues
    
    public IssuesDTO findAllBestPracticesIssuesByScan(String teriansId);
    
    public IssuesDTO findBestPracticesIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit);
    
    public IssuesDTO findBestPracticesIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit);
    
    public IssuesDTO findBestPracticesIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit);
    
    public IssuesDTO findBestPracticesIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit);
    
    public IssuesDTO findBestPracticesIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit);
    
    public IssuesDTO findBestPracticesIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit);
    
    public IssuesDTO findBestPracticesIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit);


}

