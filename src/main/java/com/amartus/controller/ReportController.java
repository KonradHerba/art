package com.amartus.controller;

import com.amartus.domain.ReportForm;
import com.amartus.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        ReportForm reportForm = reportService.getWeeklyReportTemplate(LocalDate.now());

        model.addAttribute("reportForm", reportForm);
        return "addWeeklyReport";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewWeeklyReportForm (@ModelAttribute("weeklyReport") ReportForm reportForm) {
        reportService.addNewWeeklyReport(reportForm.getWeeklyReport());

        return "redirect:/reports/all";
    }


    @RequestMapping("/{employeeByMail}/{reportType}")
    public String displayChosenEmployee(Model model, @PathVariable("employeeByMail") String email, @PathVariable("reportType") String reportType) {
        model.addAttribute("reports", reportService.getAllReports());

        return "reports";
    }
}
