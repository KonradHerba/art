package com.amartus.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by khe on 2017-02-22.
 */
public class ReportForm {
    List<List<ProjectReportDataUnit>> weeklyReport = new ArrayList<>();
    Set<LocalDate> reportedDays = new LinkedHashSet<>();

    public Set<LocalDate> getReportedDays() {
        return reportedDays;
    }

    public void setReportedDays(Set<LocalDate> reportedDays) {
        this.reportedDays = reportedDays;
    }

    public List<List<ProjectReportDataUnit>> getWeeklyReport() {
        return weeklyReport;
    }

    public void setWeeklyReport(List<List<ProjectReportDataUnit>> weeklyReport) {
        this.weeklyReport = weeklyReport;
    }
}
