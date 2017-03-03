package com.amartus.service.impl;

import com.amartus.domain.Employee;
import com.amartus.domain.ProjectReportDataUnit;
import com.amartus.domain.ReportForm;
import com.amartus.domain.repository.ReportsRepository;
import com.amartus.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static com.amartus.domain.ArtLiterals.DAY_OFF;
import static com.amartus.domain.ArtLiterals.HOLIDAY;
import static com.amartus.domain.ArtLiterals.WORKING_HOURS_PER_DAY;

/**
 * Created by khe on 2017-02-16.
 */
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportsRepository reportsRepository;

    @Override
    public ReportForm getWeeklyReportTemplate(LocalDate date) {
        Set<LocalDate> reportedDays = new LinkedHashSet<>();
        ReportForm reportForm = new ReportForm();
        List<ProjectReportDataUnit> dailyReportData = new ArrayList<>();
        List<List<ProjectReportDataUnit>> weeklyReport = new ArrayList<>();

        Set<String> projectList = reportsRepository.getAllProjectList();
        LocalDate monday = date.with(TemporalAdjusters.previous( DayOfWeek.MONDAY ));

        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            reportedDays.add(monday.plusDays(dayOfWeek.getValue() - 1));

            if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                ProjectReportDataUnit reportDataSaturday = new ProjectReportDataUnit();
                reportDataSaturday.setProjectName(DAY_OFF);
                reportDataSaturday.setReportedTime(new BigDecimal(WORKING_HOURS_PER_DAY));
                dailyReportData.clear();
                dailyReportData.add(reportDataSaturday);
            }
            else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                ProjectReportDataUnit reportDataSunday = new ProjectReportDataUnit();
                reportDataSunday.setProjectName(HOLIDAY);
                reportDataSunday.setReportedTime(new BigDecimal(WORKING_HOURS_PER_DAY));
                dailyReportData.clear();
                dailyReportData.add(reportDataSunday);
            }
            else {
                ProjectReportDataUnit reportDataWeekday = new ProjectReportDataUnit();
                dailyReportData.clear();
                dailyReportData.add(reportDataWeekday);
            }

            weeklyReport.add(dailyReportData);
        }

        reportForm.setWeeklyReport(weeklyReport);
        reportForm.setReportedDays(reportedDays);
        reportForm.setProjectList(projectList);

        return reportForm;
    }

    @Override
    public void addNewWeeklyReport(List<List<ProjectReportDataUnit>> weeklyReport) {
        reportsRepository.addNewWeeklyReport(weeklyReport);
    }

    @Override
    public List<ProjectReportDataUnit> getAllReports() {
        return reportsRepository.getAllReports();
    }
}
