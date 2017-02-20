package com.amartus.controller;

import com.amartus.domain.Employee;
import com.amartus.domain.repository.EmployeeRepository;
import com.amartus.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * Created by khe on 2017-01-24.
 */
@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping
    public String displayAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());

        return "employees";
    }

    @RequestMapping("/{employeeByCriteria}")
    public String displayChosenEmployee(Model model, @MatrixVariable(pathVar="employeeByCriteria") Map<String, List<String>> filterCriteria) {
        model.addAttribute("employees", employeeService.getEmployeeByCriteria(filterCriteria));

        return "employees";
    }



}
