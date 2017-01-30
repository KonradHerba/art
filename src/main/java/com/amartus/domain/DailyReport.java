package com.amartus.domain;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by khe on 2017-01-30.
 */
public class DailyReport {
    Employee employee;
    LocalDate date;
    List<ProjectReportData> projectsReportData;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<ProjectReportData> getProjectsReportData() {
        return projectsReportData;
    }

    public void setProjectsReportData(List<ProjectReportData> projectsReportData) {
        this.projectsReportData = projectsReportData;
    }
}
