package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */
public class IssuesDTO {

    private int totalIssues;
    @JsonProperty("issueList")
    private List<IssueDTO> issueDTOList;

    public IssuesDTO() {
    }

    public List<IssueDTO> getIssueDTOList() {
        return issueDTOList;
    }

    public void setIssueDTOList(List<IssueDTO> issueDTOList) {
        this.issueDTOList = issueDTOList;
    }

    public int getTotalIssues() {
        return totalIssues;
    }

    public void setTotalIssues(int totalIssues) {
        this.totalIssues = totalIssues;
    }
}
