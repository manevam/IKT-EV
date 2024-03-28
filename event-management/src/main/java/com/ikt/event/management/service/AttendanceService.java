package com.ikt.event.management.service;

import com.ikt.event.management.repository.views.AllTimeAttendanceDto;
import com.ikt.event.management.repository.views.AverageAttendancePerCompanyDto;

import java.util.List;

public interface AttendanceService {

    List<AllTimeAttendanceDto> listAllTimeAttendancePerCompany();

    List<AverageAttendancePerCompanyDto> avgAttendancePerCompany();

}
