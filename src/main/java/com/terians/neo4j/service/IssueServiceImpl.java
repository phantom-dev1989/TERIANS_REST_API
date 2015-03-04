package com.terians.neo4j.service;

import com.terians.dto.IssuesDTO;
import com.terians.dto.transformer.DTOTransformerUtil;
import com.terians.neo4j.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by stromero on 1/4/2015.
 */
@Service
@Transactional
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository repository;

    @Override
    public Integer findIssueCountByScan(String teriansId) {
        return repository.findIssueCountByScan(teriansId);
    }

    @Override
    public IssuesDTO findAllIssuesByScan(String teriansId) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findAllIssuesByScan(teriansId));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findIssuesByScanOrderedByIssueCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findIssuesByScanOrderedByCategoryCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findIssuesByScanOrderedByFileNameCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findIssuesByScanOrderedByPackageCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findIssuesByScanOrderedByClazzCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findIssuesByScanOrderedByIssueTypeDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findIssuesByScanOrderedByTechDebtDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findAllCriticalIssuesByScan(String teriansId) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findAllCriticalIssuesByScan(teriansId));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findCriticalIssuesByScanOrderedByIssueCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findCriticalIssuesByScanOrderedByCategoryCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findCriticalIssuesByScanOrderedByFileNameCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findCriticalIssuesByScanOrderedByPackageCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findCriticalIssuesByScanOrderedByClazzCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findCriticalIssuesByScanOrderedByIssueTypeDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findCriticalIssuesByScanOrderedByTechDebtDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findAllHighIssuesByScan(String teriansId) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findAllHighIssuesByScan(teriansId));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findHighIssuesByScanOrderedByIssueCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findHighIssuesByScanOrderedByCategoryCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findHighIssuesByScanOrderedByFileNameCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findHighIssuesByScanOrderedByPackageCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findHighIssuesByScanOrderedByClazzCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findHighIssuesByScanOrderedByIssueTypeDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findHighIssuesByScanOrderedByTechDebtDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findAllMediumIssuesByScan(String teriansId) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findAllMediumIssuesByScan(teriansId));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findMediumIssuesByScanOrderedByIssueCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findMediumIssuesByScanOrderedByCategoryCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findMediumIssuesByScanOrderedByFileNameCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findMediumIssuesByScanOrderedByPackageCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findMediumIssuesByScanOrderedByClazzCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findMediumIssuesByScanOrderedByIssueTypeDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findMediumIssuesByScanOrderedByTechDebtDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findAllLowIssuesByScan(String teriansId) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findAllLowIssuesByScan(teriansId));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findLowIssuesByScanOrderedByIssueCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findMLowIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findMLowIssuesByScanOrderedByCategoryCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findLowIssuesByScanOrderedByFileNameCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findLowIssuesByScanOrderedByPackageCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findLowIssuesByScanOrderedByClazzCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findLowIssuesByScanOrderedByIssueTypeDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findLowIssuesByScanOrderedByTechDebtDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findAllBestPracticesIssuesByScan(String teriansId) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findAllBestPracticesIssuesByScan(teriansId));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findBestPracticesIssuesByScanOrderedByIssueCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findBestPracticesIssuesByScanOrderedByCategoryCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findBestPracticesIssuesByScanOrderedByFileNameCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findBestPracticesIssuesByScanOrderedByPackageCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findBestPracticesIssuesByScanOrderedByClazzCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findBestPracticesIssuesByScanOrderedByIssueTypeDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit) {
        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(repository.findBestPracticesIssuesByScanOrderedByTechDebtDesc(teriansId, limit));
    }

}
