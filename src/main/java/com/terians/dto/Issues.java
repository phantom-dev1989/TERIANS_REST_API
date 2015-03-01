package com.terians.dto;

import java.util.Set;

/**
 * Created by stromero on 3/1/2015.
 */
public class Issues {

    private Set<Issue> issues;

    public Issues() {
    }

    public Issues(Set<Issue> issues) {
        this.issues = issues;
    }

    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }
}
