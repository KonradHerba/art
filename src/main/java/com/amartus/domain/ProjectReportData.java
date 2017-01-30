package com.amartus.domain;

import java.math.BigDecimal;

/**
 * Created by khe on 2017-01-30.
 */
public class ProjectReportData {
    String projectName;
    BigDecimal reportedTime;
    BigDecimal reportedOvertime;
    String comment;

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
