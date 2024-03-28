package com.ikt.event.management.service.impl;

import com.ikt.event.management.repository.AttendanceRepository;
import com.ikt.event.management.repository.views.AllTimeAttendanceDto;
import com.ikt.event.management.repository.views.AverageAttendancePerCompanyDto;
import com.ikt.event.management.service.AttendanceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    private final AttendanceRepository attendanceRepository;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public List<AllTimeAttendanceDto> listAllTimeAttendancePerCompany() {
        List<AllTimeAttendanceDto> result = attendanceRepository.allTimeAttendancePerCompanyReport();
        List<AllTimeAttendanceDto> reports = new ArrayList<>();
        for (AllTimeAttendanceDto row : result) {
            String companyName = row.getName();
            Long allTimeAttendance = row.getTotalAttendance();
            AllTimeAttendanceDto a = new AllTimeAttendanceDto(companyName, allTimeAttendance);
            reports.add(a);
        }
        return reports;
    }

    @Override
    public List<AverageAttendancePerCompanyDto> avgAttendancePerCompany() {
        List<AverageAttendancePerCompanyDto> result = attendanceRepository.avgAttendancePerCompanyReport();
        List<AverageAttendancePerCompanyDto> reports = new ArrayList<>();
        for (AverageAttendancePerCompanyDto row : result) {
            String companyName = row.getCompanyName();
            Double avgAtt = row.getAvgAttendance();
            AverageAttendancePerCompanyDto av = new AverageAttendancePerCompanyDto(companyName, avgAtt);
            reports.add(av);
        }
        return reports;
    }

}
