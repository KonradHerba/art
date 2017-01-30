package com.amartus.domain.repository.impl;

import com.amartus.domain.DailyReport;
import com.amartus.domain.Employee;
import com.amartus.domain.ProjectReportData;
import com.amartus.domain.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by khe on 2017-01-25.
 */
@Repository
public class InMemoryRepository implements EmployeeRepository{

    List<Employee> employeeList = new ArrayList<Employee>();
    List<DailyReport> reportList = new ArrayList<>();

    InMemoryRepository() {
        //Fake employees
        Employee konrad = new Employee("Konrad", "Herba");
        Employee magdalena = new Employee("Magdalena", "Herba");

        employeeList.add(konrad);
        employeeList.add(magdalena);

        //Fake reports
        String projectName = "Fake Project";
        String comment = "fake comment";
        ProjectReportData projectReportData = new ProjectReportData();
        List<ProjectReportData> dailyProjectReports = new ArrayList<>();

        projectReportData.setProjectName(projectName);
        projectReportData.setReportedTime(new BigDecimal(8));
        projectReportData.setComment(comment);

        dailyProjectReports.add(projectReportData);

        int daysInPeriod = 5;
        DailyReport report = new DailyReport();

        do {
            report.setDate(LocalDate.now().minusDays(daysInPeriod));
            report.setEmployee(konrad);
            report.setProjectsReportData(dailyProjectReports);

            reportList.add(report);

        } while (daysInPeriod > 0);



    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }
    public String getEmployeeEmail (Employee employee) {
        for (Employee e : employeeList) {
            if (e.equals(employee)) {
                return e.getEmail();
            }
        }
        return "";
    }
}
