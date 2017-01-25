package com.amartus.controller;

import com.amartus.domain.Employee;
import com.amartus.domain.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by khe on 2017-01-24.
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/employees")
    public String displayEmployees(Model model) {
        model.addAttribute("employees", employeeRepository.getAllEmployees());

        return "employees";
    }

}
