package com.terians.neo4j.service;

import com.terians.dto.IssueDTO;
import com.terians.dto.IssuesDTO;
import com.terians.dto.transformer.DTOTransformerUtil;
import com.terians.neo4j.model.Issue;
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
    private IssueRepository issueRepository;

    @Override
    public IssueDTO findIssue(String issueId) {

        if (issueId != null) {
            Issue issue = null;
            for (Issue e : issueRepository.findAllIssues()) {
                if (e.getTeriansId().equals(issueId)) {
                    issue = e;
                    break;
                }
            }
            return DTOTransformerUtil.transformIssueToIssueDTO(issue);
        }
        return null;
    }

    @Override
    public IssuesDTO findAllIssues() {

        return DTOTransformerUtil.transformIssuesSetToIssuesDTO(issueRepository.findAllIssues());
    }
}
