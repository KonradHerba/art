package com.amartus.service;

import com.amartus.domain.DailyReport;

import java.util.List;

/**
 * Created by khe on 2017-02-16.
 */
public interface ReportService {
    List<DailyReport> getAllReports();
}
