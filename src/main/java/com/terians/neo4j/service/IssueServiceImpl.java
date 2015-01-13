package com.terians.neo4j.service;

import com.terians.neo4j.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by stromero on 1/4/2015.
 */
@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository repository;

}
