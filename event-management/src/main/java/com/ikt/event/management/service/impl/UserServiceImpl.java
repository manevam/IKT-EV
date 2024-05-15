package com.ikt.event.management.service.impl;

import com.ikt.event.management.entity.*;
import com.ikt.event.management.entity.exceptions.InvalidEventIdException;
import com.ikt.event.management.entity.exceptions.InvalidPersonIdException;
import com.ikt.event.management.repository.AttendanceRepository;
import com.ikt.event.management.repository.CompanyRepository;
import com.ikt.event.management.repository.EventRepository;
import com.ikt.event.management.repository.UserRepository;
import com.ikt.event.management.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final CompanyRepository companyRepository;
    private final AttendanceRepository attendanceRepository;

    public UserServiceImpl(UserRepository userRepositoryInterface, EventRepository eventRepository, CompanyRepository companyRepository, AttendanceRepository attendanceRepository) {
        this.userRepository = userRepositoryInterface;
        this.eventRepository = eventRepository;
        this.companyRepository = companyRepository;
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer userID) {
        return userRepository.findById(userID.longValue()).orElseThrow(InvalidPersonIdException::new);
    }

    @Override
    public User create(String personName, String personEmail, String phoneNumber, String companyName, Role role) {
        User user = new User(personName, personEmail, phoneNumber, role);
        Company company = companyRepository.findByName(companyName).orElse(null);
        user.setCompany(company);
        return userRepository.save(user);
    }

    @Override
    public void personRegistrationForEvent(Integer userID, Integer roleID, Integer eventID, Role role) {
        User user = findById(userID);

        Event event = eventRepository.findById(eventID.longValue()).orElseThrow(InvalidEventIdException::new);
        Attendance attendance = new Attendance(role, user, event);
        attendanceRepository.save(attendance);
    }
}
