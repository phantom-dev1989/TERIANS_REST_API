package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */
@JsonRootName("Scans")
public class ScansDTO {

    private int totalScans;
    @JsonProperty("ScanList")
    private List<ScanDTO> scanDTOList;

    public ScansDTO() {
    }

    public ScansDTO(List<ScanDTO> scanDTOList, int totalScans) {
        this.scanDTOList = scanDTOList;
        this.totalScans = totalScans;
    }

    public List<ScanDTO> getScanDTOList() {
        return scanDTOList;
    }

    public void setScanDTOList(List<ScanDTO> scanDTOList) {
        this.scanDTOList = scanDTOList;
    }

    public int getTotalScans() {
        return totalScans;
    }

    public void setTotalScans(int totalScans) {
        this.totalScans = totalScans;
    }
}
