package com.amartus.service;

import com.amartus.domain.ProjectReportDataUnit;
import com.amartus.domain.ReportForm;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by khe on 2017-02-16.
 */
public interface ReportService {
    void addNewWeeklyReport(List<List<ProjectReportDataUnit>> weeklyReport);
    List<ProjectReportDataUnit> getAllReports();
    ReportForm getWeeklyReportTemplate(LocalDate date);
}
