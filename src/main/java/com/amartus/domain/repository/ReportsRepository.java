package com.amartus.domain.repository;

import com.amartus.domain.DailyReport;

import java.util.List;

/**
 * Created by khe on 2017-02-01.
 */
public interface ReportsRepository {
    List<DailyReport> getAllReports();
}
