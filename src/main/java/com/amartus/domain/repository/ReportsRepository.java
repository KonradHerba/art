package com.amartus.domain.repository;

import com.amartus.domain.ProjectReportDataUnit;

import java.util.List;

/**
 * Created by khe on 2017-02-01.
 */
public interface ReportsRepository {
    void addNewWeeklyReport(List<List<ProjectReportDataUnit>> weeklyReport);
    List<ProjectReportDataUnit> getAllReports();
}
