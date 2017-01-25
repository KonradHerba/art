package com.amartus.domain.repository.impl;

import com.amartus.domain.Employee;
import com.amartus.domain.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khe on 2017-01-25.
 */
@Repository
public class InMemoryEmployeeRepository implements EmployeeRepository{

    List<Employee> employeeList = new ArrayList<Employee>();

    InMemoryEmployeeRepository() {
        Employee konrad = new Employee("Konrad", "Herba");
        Employee magdalena = new Employee("Magdalena", "Herba");

        employeeList.add(konrad);
        employeeList.add(magdalena);
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}
