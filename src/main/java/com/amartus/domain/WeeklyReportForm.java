package com.amartus.domain;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by khe on 2017-03-06.
 */
public class WeeklyReportForm {
    Employee employee;
    List<List<String>> reportData;
    Set<String> projectList;
    Set<LocalDate> reportedDays;
    Set<String> reportingUnits;
    Set<String> employees;

    public WeeklyReportForm() {
        reportingUnits = new LinkedHashSet<>();
        for (int i = 0; i < 14; i++) {
            if (i < 13) {
                reportingUnits.add(String.valueOf(i));
                reportingUnits.add(String.valueOf(i) + ".5");
            }
            else {
                reportingUnits.add(String.valueOf(i));
            }
        }
    }

    public Set<String> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<String> employees) {
        this.employees = employees;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<LocalDate> getReportedDays() {
        return reportedDays;
    }

    public void setReportedDays(Set<LocalDate> reportedDays) {
        this.reportedDays = reportedDays;
    }

    public List<List<String>> getReportData() {
        return reportData;
    }

    public void setReportData(List<List<String>> reportData) {
        this.reportData = reportData;
    }

    public Set<String> getProjectList() {
        return projectList;
    }

    public void setProjectList(Set<String> projectList) {
        this.projectList = projectList;
    }

    public Set<String> getReportingUnits() {
        return reportingUnits;
    }

    public void setReportingUnits(Set<String> reportingUnits) {
        this.reportingUnits = reportingUnits;
    }
}
