package com.terians.neo4j.service;

import com.terians.dto.IssueDTO;
import com.terians.dto.IssuesDTO;
import com.terians.neo4j.model.Issue;
import com.terians.neo4j.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

        return transformIssuesSetToIssuesDTO(repository.findAllIssuesByScan(teriansId));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findIssuesByScanOrderedByIssueCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findIssuesByScanOrderedByCategoryCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findIssuesByScanOrderedByFileNameCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findIssuesByScanOrderedByPackageCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findIssuesByScanOrderedByClazzCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findIssuesByScanOrderedByIssueTypeDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findIssuesByScanOrderedByTechDebtDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findAllCriticalIssuesByScan(String teriansId) {

        return transformIssuesSetToIssuesDTO(repository.findAllCriticalIssuesByScan(teriansId));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findCriticalIssuesByScanOrderedByIssueCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findCriticalIssuesByScanOrderedByCategoryCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findCriticalIssuesByScanOrderedByFileNameCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findCriticalIssuesByScanOrderedByPackageCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findCriticalIssuesByScanOrderedByClazzCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findCriticalIssuesByScanOrderedByIssueTypeDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findCriticalIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findCriticalIssuesByScanOrderedByTechDebtDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findAllHighIssuesByScan(String teriansId) {

        return transformIssuesSetToIssuesDTO(repository.findAllHighIssuesByScan(teriansId));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findHighIssuesByScanOrderedByIssueCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findHighIssuesByScanOrderedByCategoryCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findHighIssuesByScanOrderedByFileNameCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findHighIssuesByScanOrderedByPackageCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findHighIssuesByScanOrderedByClazzCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findHighIssuesByScanOrderedByIssueTypeDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findHighIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findHighIssuesByScanOrderedByTechDebtDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findAllMediumIssuesByScan(String teriansId) {

        return transformIssuesSetToIssuesDTO(repository.findAllMediumIssuesByScan(teriansId));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findMediumIssuesByScanOrderedByIssueCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findMediumIssuesByScanOrderedByCategoryCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findMediumIssuesByScanOrderedByFileNameCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findMediumIssuesByScanOrderedByPackageCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findMediumIssuesByScanOrderedByClazzCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findMediumIssuesByScanOrderedByIssueTypeDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findMediumIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findMediumIssuesByScanOrderedByTechDebtDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findAllLowIssuesByScan(String teriansId) {

        return transformIssuesSetToIssuesDTO(repository.findAllLowIssuesByScan(teriansId));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findLowIssuesByScanOrderedByIssueCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findMLowIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findMLowIssuesByScanOrderedByCategoryCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findLowIssuesByScanOrderedByFileNameCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findLowIssuesByScanOrderedByPackageCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findLowIssuesByScanOrderedByClazzCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findLowIssuesByScanOrderedByIssueTypeDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findLowIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findLowIssuesByScanOrderedByTechDebtDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findAllBestPracticesIssuesByScan(String teriansId) {

        return transformIssuesSetToIssuesDTO(repository.findAllBestPracticesIssuesByScan(teriansId));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByIssueCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findBestPracticesIssuesByScanOrderedByIssueCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByCategoryCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findBestPracticesIssuesByScanOrderedByCategoryCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByFileNameCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findBestPracticesIssuesByScanOrderedByFileNameCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByPackageCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findBestPracticesIssuesByScanOrderedByPackageCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByClazzCountDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findBestPracticesIssuesByScanOrderedByClazzCountDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByIssueTypeDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findBestPracticesIssuesByScanOrderedByIssueTypeDesc(teriansId, limit));
    }

    @Override
    public IssuesDTO findBestPracticesIssuesByScanOrderedByTechDebtDesc(String teriansId, int limit) {

        return transformIssuesSetToIssuesDTO(repository.findBestPracticesIssuesByScanOrderedByTechDebtDesc(teriansId, limit));
    }

    private IssuesDTO transformIssuesSetToIssuesDTO(Set<Issue> issuesSet){

        IssuesDTO issuesDTO = new IssuesDTO();
        List<IssueDTO> issueDTOList = new ArrayList<>();
        for(Issue e: issuesSet){

            IssueDTO issueDTO = new IssueDTO();
            issueDTO.setTeriansId(e.getTeriansId());
            issueDTO.setCategory(e.getCategory());
            issueDTO.setClassName(e.getClassName());
            issueDTO.setDescription(e.getDescription());
            issueDTO.setFileName(e.getFileName());
            issueDTO.setFilePath(e.getFilePath());
            issueDTO.setLineNumber(e.getLineNumber());
            issueDTO.setPackageName(e.getPackageName());
            issueDTO.setPriority(e.getPriority());
            issueDTO.setScanTool(e.getScanTool());
            issueDTO.setSeverity(e.getSeverity());
            issueDTO.setTechDebtMinutes(e.getTechDebtMinutes());
            issueDTO.setIssue(e.getIssue());
            issueDTO.setIssueType(e.getIssueType());

            issueDTOList.add(issueDTO);
        }

        issuesDTO.setIssueDTOs(issueDTOList);
        issuesDTO.setTotalIssues(issueDTOList.size());

        return issuesDTO;

    }
}
