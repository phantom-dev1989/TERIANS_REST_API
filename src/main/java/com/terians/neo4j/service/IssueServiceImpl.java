package com.terians.neo4j.service;

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
    public Integer findIssueCountByScan(String teriansId) {
        return issueRepository.findIssueCountByScan(teriansId);
    }

    @Override
    public IssuesDTO findAllIssuesByScan(String teriansId) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findAllIssuesByScan(teriansId));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findIssuesByScanOrderedByIssueCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findIssuesByScanOrderedByCategoryCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findIssuesByScanOrderedByFileNameCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findIssuesByScanOrderedByPackageCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findIssuesByScanOrderedByClazzCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findIssuesByScanOrderedByIssueTypeDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findIssuesByScanOrderedByTechDebtDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findAllCriticalIssuesByScan(String teriansId) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findAllCriticalIssuesByScan(teriansId));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findCriticalIssuesByScanOrderedByIssueCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findCriticalIssuesByScanOrderedByCategoryCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findCriticalIssuesByScanOrderedByFileNameCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findCriticalIssuesByScanOrderedByPackageCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findCriticalIssuesByScanOrderedByClazzCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findCriticalIssuesByScanOrderedByIssueTypeDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findCriticalIssuesByScanOrderedByTechDebtDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findAllHighIssuesByScan(String teriansId) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findAllHighIssuesByScan(teriansId));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findHighIssuesByScanOrderedByIssueCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findHighIssuesByScanOrderedByCategoryCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findHighIssuesByScanOrderedByFileNameCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findHighIssuesByScanOrderedByPackageCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findHighIssuesByScanOrderedByClazzCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findHighIssuesByScanOrderedByIssueTypeDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findHighIssuesByScanOrderedByTechDebtDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findAllMediumIssuesByScan(String teriansId) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findAllMediumIssuesByScan(teriansId));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findMediumIssuesByScanOrderedByIssueCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findMediumIssuesByScanOrderedByCategoryCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findMediumIssuesByScanOrderedByFileNameCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findMediumIssuesByScanOrderedByPackageCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findMediumIssuesByScanOrderedByClazzCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findMediumIssuesByScanOrderedByIssueTypeDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findMediumIssuesByScanOrderedByTechDebtDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findAllLowIssuesByScan(String teriansId) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findAllLowIssuesByScan(teriansId));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findLowIssuesByScanOrderedByIssueCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findMLowIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findMLowIssuesByScanOrderedByCategoryCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findLowIssuesByScanOrderedByFileNameCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findLowIssuesByScanOrderedByPackageCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findLowIssuesByScanOrderedByClazzCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findLowIssuesByScanOrderedByIssueTypeDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findLowIssuesByScanOrderedByTechDebtDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findAllBestPracticesIssuesByScan(String teriansId) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findAllBestPracticesIssuesByScan(teriansId));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findBestPracticesIssuesByScanOrderedByIssueCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findBestPracticesIssuesByScanOrderedByCategoryCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findBestPracticesIssuesByScanOrderedByFileNameCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findBestPracticesIssuesByScanOrderedByPackageCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findBestPracticesIssuesByScanOrderedByClazzCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findBestPracticesIssuesByScanOrderedByIssueTypeDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findBestPracticesIssuesByScanOrderedByTechDebtDesc(teriansId, limit));
    }

}
