package com.terians.neo4j.service;

import com.terians.neo4j.model.Scan;

/**
 * Created by stromero on 1/4/2015.
 */
public interface ScanService {
    Scan findLatestScanByMaxDate();
    Scan save(Scan scan);
}
