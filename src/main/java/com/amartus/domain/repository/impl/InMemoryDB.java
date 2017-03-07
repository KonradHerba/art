package com.amartus.domain.repository.impl;

import com.amartus.domain.Employee;
import com.amartus.domain.ProjectReportDataUnit;
import com.amartus.domain.repository.EmployeeRepository;
import com.amartus.domain.repository.ReportsRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static com.amartus.domain.ArtLiterals.DAY_OFF;
import static com.amartus.domain.ArtLiterals.HOLIDAY;
import static com.amartus.domain.ArtLiterals.WORKING_HOURS_PER_DAY;

/**
 * Created by khe on 2017-01-25.
 */
@Repository
public class InMemoryDB implements EmployeeRepository, ReportsRepository {

    Set<Employee> employeeList = new LinkedHashSet<>();
    List<ProjectReportDataUnit> reportList = new ArrayList<>();

    InMemoryDB() {
        //Fake employees
        Employee konrad = new Employee("Konrad", "Herba");
        Employee magdalena = new Employee("Magdalena", "Herba");

        employeeList.add(konrad);
        employeeList.add(magdalena);

        //Fake reports
        String projectName = "Fake Project";
        String comment = "fake comment";
        ProjectReportDataUnit projectReportDataUnit = new ProjectReportDataUnit();
        List<ProjectReportDataUnit> dailyProjectReports = new ArrayList<>();

        projectReportDataUnit.setProjectName(projectName);
        projectReportDataUnit.setReportedTime(new BigDecimal("8"));
        projectReportDataUnit.setComment(comment);

        dailyProjectReports.add(projectReportDataUnit);

        int daysInPeriod = 5;

        do {
            ProjectReportDataUnit report = new ProjectReportDataUnit();
            report.setDate(LocalDate.now().minusDays(daysInPeriod));
            report.setEmployee(konrad);
            report.setProjectName("ProjectA");
            report.setReportedTime(new BigDecimal(WORKING_HOURS_PER_DAY));

            reportList.add(report);

            daysInPeriod--;

        } while (daysInPeriod > 0);



    }

    @Override
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public void addNewWeeklyReport(List<List<ProjectReportDataUnit>> weeklyReport) {
        for (List<ProjectReportDataUnit> dailyReport : weeklyReport) {
            for (ProjectReportDataUnit report : dailyReport) {
                reportList.add(report);
            }
        }
    }

    @Override
    public Set<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public List<ProjectReportDataUnit> getAllReports() {
        return reportList;
    }

    @Override
    public Set<Employee> getEmployeeByMail(String email) {
        Set<Employee> employeeRecord = new LinkedHashSet<>();

        for (Employee e : employeeList) {
            if (e.getEmail().equalsIgnoreCase(email)) employeeRecord.add(e);
        }

        return employeeRecord;
    }

    @Override
    public Set<Employee> getEmployeeByCriteria(Map<String, List<String>> filterCriteria) {
        Set<Employee> employeesToFilter = employeeList;
        Set<Employee> filteredEmployees = new LinkedHashSet<>();

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

    @Override
    public Set<String> getAllProjectList() {
        Set<String> projectList = new LinkedHashSet<>();

        projectList.add("ProjectA");
        projectList.add(DAY_OFF);
        projectList.add(HOLIDAY);

        return projectList;
    }
}
