package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */
@JsonRootName("Issues")
public class IssuesDTO {

    private int totalIssues;
    @JsonProperty("IssueList")
    private List<IssueDTO> issueDTOs;

    public IssuesDTO() {
    }

    public IssuesDTO(List<IssueDTO> issueDTOs, int totalIssues) {
        this.issueDTOs = issueDTOs;
        this.totalIssues = totalIssues;
    }

    public List<IssueDTO> getIssueDTOs() {
        return issueDTOs;
    }

    public void setIssueDTOs(List<IssueDTO> issueDTOs) {
        this.issueDTOs = issueDTOs;
    }

    public int getTotalIssues() {
        return totalIssues;
    }

    public void setTotalIssues(int totalIssues) {
        this.totalIssues = totalIssues;
    }
}
