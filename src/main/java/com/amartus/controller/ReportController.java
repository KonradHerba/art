package com.amartus.controller;

import com.amartus.domain.WeeklyReportForm;
import com.amartus.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewWeeklyReportForm (Model model) {
        WeeklyReportForm reportForm = reportService.initializeWeeklyReportForm(LocalDate.now());

        model.addAttribute("reportForm", reportForm);
        return "addWeeklyReport";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewWeeklyReportForm (@ModelAttribute("reportForm") WeeklyReportForm reportForm) {
        reportService.addNewWeeklyReport(reportForm);

        return "redirect:/reports/all";
    }

    @RequestMapping("/{employeeByMail}/{reportType}")
    public String displayChosenEmployee(Model model, @PathVariable("employeeByMail") String email, @PathVariable("reportType") String reportType) {
        model.addAttribute("reports", reportService.getAllReports());

        return "reports";
    }
}
