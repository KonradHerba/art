package com.amartus.controller;

import com.amartus.domain.repository.ReportsRepository;
import com.amartus.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by khe on 2017-02-01.
 */
@Controller
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    ReportService reportService;

    @RequestMapping("/all")
    public String showAllReports(Model model) {
        model.addAttribute("reports", reportService.getAllReports());

        return "reports";
    }

    @RequestMapping("/{employeeByMail}/{reportType}")
    public String displayChosenEmployee(Model model, @PathVariable("employeeByMail") String email, @PathVariable("reportType") String reportType) {
        model.addAttribute("reports", reportService.getAllReports());

        return "reports";
    }
}
