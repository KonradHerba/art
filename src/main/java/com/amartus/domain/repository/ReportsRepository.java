package com.amartus.domain.repository;

import com.amartus.domain.ProjectReportDataUnit;

import java.util.List;
import java.util.Set;

/**
 * Created by khe on 2017-02-01.
 */
public interface ReportsRepository {
    void addNewWeeklyReport(List<List<ProjectReportDataUnit>> weeklyReport);
    List<ProjectReportDataUnit> getAllReports();
    Set<String> getAllProjectList();
}
