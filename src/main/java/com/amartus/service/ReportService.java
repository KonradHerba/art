package com.amartus.service;

import com.amartus.domain.ProjectReportDataUnit;
import com.amartus.domain.WeeklyReportForm;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by khe on 2017-02-16.
 */
public interface ReportService {
    void addNewWeeklyReport(WeeklyReportForm weeklyReport);
    List<ProjectReportDataUnit> getAllReports();
    WeeklyReportForm initializeWeeklyReportForm(LocalDate date);
}
