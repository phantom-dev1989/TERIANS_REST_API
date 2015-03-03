package com.terians.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * Created by stromero on 3/1/2015.
 */
@JsonRootName("Packages")
public class PackagesDTO {

    private int totalPackages;
    @JsonProperty("PackageList")
    private List<PackageDTO> packageDTOs;

    public PackagesDTO() {
    }

    public PackagesDTO(List<PackageDTO> packageDTOs, int totalPackages) {
        this.packageDTOs = packageDTOs;
        this.totalPackages = totalPackages;
    }

    public List<PackageDTO> getPackageDTOs() {
        return packageDTOs;
    }

    public void setPackageDTOs(List<PackageDTO> packageDTOs) {
        this.packageDTOs = packageDTOs;
    }

    public int getTotalPackages() {
        return totalPackages;
    }

    public void setTotalPackages(int totalPackages) {
        this.totalPackages = totalPackages;
    }
}
