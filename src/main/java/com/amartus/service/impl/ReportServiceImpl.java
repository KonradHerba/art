package com.amartus.service.impl;

import com.amartus.domain.Employee;
import com.amartus.domain.ProjectReportDataUnit;
import com.amartus.domain.WeeklyReportForm;
import com.amartus.domain.repository.EmployeeRepository;
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

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public WeeklyReportForm initializeWeeklyReportForm(LocalDate date) {
        WeeklyReportForm weeklyReportForm = new WeeklyReportForm();
        weeklyReportForm.setMondayOfReportedWeek(date.with(TemporalAdjusters.previous( DayOfWeek.MONDAY )));
        Set<LocalDate> reportedDays = calculateReportedWeekdays(date);
        Set<String> projectList = reportsRepository.getAllProjectList();
        Set<String> employees = getEmployeeNamesSet(employeeRepository.getAllEmployees());

        weeklyReportForm.setReportedDays(reportedDays);
        weeklyReportForm.setProjectList(projectList);
        weeklyReportForm.setEmployees(employees);

        List<List<String>> reportTable = new ArrayList<>();

        weeklyReportForm.setProjectList(projectList);

        for (String project : projectList){
            List<String> reportRow = new ArrayList();
            reportRow.add(project);

            for (LocalDate day : reportedDays) {
                    reportRow.add("0");
            }
            reportTable.add(reportRow);
        }

        weeklyReportForm.setReportData(reportTable);

        return weeklyReportForm;
    }

    private Set<String> getEmployeeNamesSet(Set<Employee> employees) {
        Set<String> employeeNames = new LinkedHashSet<>();

        for (Employee employee : employees) {
            employeeNames.add(employee.getName() + " " + employee.getLastname());
        }

        return employeeNames;
    }

    private Set<LocalDate> calculateReportedWeekdays(LocalDate date) {
        Set<LocalDate> reportedWeekdays = new LinkedHashSet<>();

        LocalDate monday = date.with(TemporalAdjusters.previous( DayOfWeek.MONDAY ));

        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            LocalDate reportedDay = monday.plusDays(dayOfWeek.getValue() - 1);
            reportedWeekdays.add(reportedDay);
        }
        return reportedWeekdays;
    }

    @Override
    public void addNewWeeklyReport(WeeklyReportForm weeklyReport) {
        //this method is way to large. needs to be splited into mapping method and original add method
        String employeeString = weeklyReport.getEmployee();
        String name = employeeString.substring(0,employeeString.indexOf(" "));
        String lastname = employeeString.substring(employeeString.indexOf(" ") + 1);
        Employee employee = employeeRepository.getEmployeeByName(name, lastname);
        List<List<String>> weeklyReportData = weeklyReport.getReportData();
        List<List<ProjectReportDataUnit>> newWeeklyReport = new ArrayList<>();

        for (List<String> projectReports : weeklyReportData) {
            List<ProjectReportDataUnit> listOfAtomicReports = new ArrayList<>();
            int projectIndex = 0;

            for (String reportDetails : projectReports) {
                int dateIndex = 0;
                ProjectReportDataUnit atomicReport = new ProjectReportDataUnit();

                atomicReport.setEmployee(employee); //OK
                atomicReport.setDate(LocalDate.now().plusDays(dateIndex)); //NOK

                if(projectIndex == 0) atomicReport.setProjectName(reportDetails); //OK
                else atomicReport.setReportedTime(new BigDecimal(reportDetails)); //OK

                listOfAtomicReports.add(atomicReport);
                projectIndex++;
                dateIndex++;
            }

            newWeeklyReport.add(listOfAtomicReports);
        }

        reportsRepository.addNewWeeklyReport(newWeeklyReport);
    }

    @Override
    public List<ProjectReportDataUnit> getAllReports() {
        return reportsRepository.getAllReports();
    }
}
