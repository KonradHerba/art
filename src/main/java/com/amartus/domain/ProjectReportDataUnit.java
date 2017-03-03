package com.amartus.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by khe on 2017-01-30.
 */
public class ProjectReportDataUnit {
    Employee employee;
    LocalDate date;
    String projectName;
    BigDecimal reportedTime;
    BigDecimal reportedOvertime;
    String comment;

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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public BigDecimal getReportedTime() {
        return reportedTime;
    }

    public void setReportedTime(BigDecimal reportedTime) {
        this.reportedTime = reportedTime;
    }

    public BigDecimal getReportedOvertime() {
        return reportedOvertime;
    }

    public void setReportedOvertime(BigDecimal reportedOvertime) {
        this.reportedOvertime = reportedOvertime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
