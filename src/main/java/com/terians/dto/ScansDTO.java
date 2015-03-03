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
    private List<ScanDTO> scanDTOs;

    public ScansDTO() {
    }

    public ScansDTO(List<ScanDTO> scanDTOs, int totalScans) {
        this.scanDTOs = scanDTOs;
        this.totalScans = totalScans;
    }

    public List<ScanDTO> getScanDTOs() {
        return scanDTOs;
    }

    public void setScanDTOs(List<ScanDTO> scanDTOs) {
        this.scanDTOs = scanDTOs;
    }

    public int getTotalScans() {
        return totalScans;
    }

    public void setTotalScans(int totalScans) {
        this.totalScans = totalScans;
    }
}
