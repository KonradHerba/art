package com.amartus.service.impl;

import com.amartus.domain.DailyReport;
import com.amartus.domain.repository.ReportsRepository;
import com.amartus.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by khe on 2017-02-16.
 */
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportsRepository reportsRepository;

    @Override
    public List<DailyReport> getAllReports() {
        return reportsRepository.getAllReports();
    }
}
