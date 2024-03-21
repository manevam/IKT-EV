package com.ikt.event.management.controller;

import com.ikt.event.management.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/v1/attendance")
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceRepository attendanceRepository;
}
