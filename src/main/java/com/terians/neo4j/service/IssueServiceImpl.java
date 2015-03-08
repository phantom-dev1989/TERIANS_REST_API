package com.terians.neo4j.service;

import com.terians.dto.IssueDTO;
import com.terians.dto.IssuesDTO;
import com.terians.dto.transformer.DTOTransformerUtil;
import com.terians.neo4j.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by stromero on 1/4/2015.
 */
@Service
@Transactional
public class IssueServiceImpl implements IssueService {

    @Autowired
    private Neo4jTemplate template;
    @Autowired
    private IssueRepository issueRepository;

    @Override
    public Integer findIssueCountByScan(String scanId) {
        return issueRepository.findIssueCountByScan(scanId);
    }

    @Override
    public IssuesDTO findAllIssues(String category, String orderedBy) {
        return null;
    }

    @Override
    public IssueDTO findIssue(String issueId) {
        return null;
    }

    @Override
    public IssuesDTO findAllIssuesByScan(String scanId) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findAllIssuesByScan(scanId));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByIssueCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findIssuesByScanOrderedByIssueCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByCategoryCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findIssuesByScanOrderedByCategoryCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByFileNameCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findIssuesByScanOrderedByFileNameCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByPackageCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findIssuesByScanOrderedByPackageCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByClazzCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findIssuesByScanOrderedByClazzCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByIssueTypeDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findIssuesByScanOrderedByIssueTypeDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByTechDebtDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findIssuesByScanOrderedByTechDebtDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findAllCriticalIssuesByScan(String scanId) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findAllCriticalIssuesByScan(scanId));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByIssueCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findCriticalIssuesByScanOrderedByIssueCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByCategoryCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findCriticalIssuesByScanOrderedByCategoryCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByFileNameCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findCriticalIssuesByScanOrderedByFileNameCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByPackageCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findCriticalIssuesByScanOrderedByPackageCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByClazzCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findCriticalIssuesByScanOrderedByClazzCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByIssueTypeDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findCriticalIssuesByScanOrderedByIssueTypeDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByTechDebtDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findCriticalIssuesByScanOrderedByTechDebtDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findAllHighIssuesByScan(String scanId) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findAllHighIssuesByScan(scanId));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByIssueCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findHighIssuesByScanOrderedByIssueCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByCategoryCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findHighIssuesByScanOrderedByCategoryCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByFileNameCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findHighIssuesByScanOrderedByFileNameCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByPackageCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findHighIssuesByScanOrderedByPackageCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByClazzCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findHighIssuesByScanOrderedByClazzCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByIssueTypeDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findHighIssuesByScanOrderedByIssueTypeDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByTechDebtDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findHighIssuesByScanOrderedByTechDebtDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findAllMediumIssuesByScan(String scanId) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findAllMediumIssuesByScan(scanId));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByIssueCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findMediumIssuesByScanOrderedByIssueCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByCategoryCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findMediumIssuesByScanOrderedByCategoryCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByFileNameCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findMediumIssuesByScanOrderedByFileNameCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByPackageCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findMediumIssuesByScanOrderedByPackageCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByClazzCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findMediumIssuesByScanOrderedByClazzCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByIssueTypeDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findMediumIssuesByScanOrderedByIssueTypeDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByTechDebtDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findMediumIssuesByScanOrderedByTechDebtDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findAllLowIssuesByScan(String scanId) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findAllLowIssuesByScan(scanId));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByIssueCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findLowIssuesByScanOrderedByIssueCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findMLowIssuesByScanOrderedByCategoryCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findMLowIssuesByScanOrderedByCategoryCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByFileNameCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findLowIssuesByScanOrderedByFileNameCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByPackageCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findLowIssuesByScanOrderedByPackageCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByClazzCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findLowIssuesByScanOrderedByClazzCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByIssueTypeDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findLowIssuesByScanOrderedByIssueTypeDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByTechDebtDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findLowIssuesByScanOrderedByTechDebtDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findAllBestPracticesIssuesByScan(String scanId) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findAllBestPracticesIssuesByScan(scanId));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByIssueCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findBestPracticesIssuesByScanOrderedByIssueCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByCategoryCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findBestPracticesIssuesByScanOrderedByCategoryCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByFileNameCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findBestPracticesIssuesByScanOrderedByFileNameCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByPackageCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findBestPracticesIssuesByScanOrderedByPackageCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByClazzCountDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findBestPracticesIssuesByScanOrderedByClazzCountDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByIssueTypeDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findBestPracticesIssuesByScanOrderedByIssueTypeDesc(scanId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByTechDebtDesc(String scanId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findBestPracticesIssuesByScanOrderedByTechDebtDesc(scanId, limit));
    }

}
