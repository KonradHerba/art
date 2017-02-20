package com.amartus.domain.repository.impl;

import com.amartus.domain.DailyReport;
import com.amartus.domain.Employee;
import com.amartus.domain.ProjectReportData;
import com.amartus.domain.repository.EmployeeRepository;
import com.amartus.domain.repository.ReportsRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by khe on 2017-01-25.
 */
@Repository
public class InMemoryDB implements EmployeeRepository, ReportsRepository {

    List<Employee> employeeList = new ArrayList<>();
    List<DailyReport> reportList = new ArrayList<>();

    InMemoryDB() {
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

        do {
            DailyReport report = new DailyReport();
            report.setDate(LocalDate.now().minusDays(daysInPeriod));
            report.setEmployee(konrad);
            report.setProjectsReportData(dailyProjectReports);

            reportList.add(report);

            daysInPeriod--;

        } while (daysInPeriod > 0);



    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public List<DailyReport> getAllReports() {
        return reportList;
    }

    @Override
    public List<Employee> getEmployeeByMail(String email) {
        List<Employee> employeeRecord = new ArrayList<>();

        for (Employee e : employeeList) {
            if (e.getEmail().equalsIgnoreCase(email)) employeeRecord.add(e);
        }

        return employeeRecord;
    }

    @Override
    public List<Employee> getEmployeeByCriteria(Map<String, List<String>> filterCriteria) {
        List<Employee> employeesToFilter = employeeList;
        List<Employee> filteredEmployees = new ArrayList<>();

        Set<String> criteria = filterCriteria.keySet();

        if (criteria.contains("name")) {

            // TODO
            // Replace with Lambda!
            filteredEmployees.clear();
            for (String name : filterCriteria.get("name")) {
                for (Employee employee : employeesToFilter) {
                    if(name.equalsIgnoreCase(employee.getName())) filteredEmployees.add(employee);
                }
            }

            employeesToFilter = filteredEmployees;


        }
        else if (criteria.contains("lastname")) {

            filteredEmployees.clear();
            for (String lastname : filterCriteria.get("lastname")) {
                for (Employee employee : employeesToFilter) {
                    if (lastname.equalsIgnoreCase(employee.getLastname())) filteredEmployees.add(employee);
                }
            }
            employeesToFilter = filteredEmployees;
        }
        else if (criteria.contains("vacationDays")) {
            // TODO
            // Tu bym chciał, żeby można było podać przedział. np. od 10 do 100 dni
        }

        return filteredEmployees;
    }
}
