package com.ikt.event.management.service.impl;

import com.ikt.event.management.entity.*;
import com.ikt.event.management.entity.exceptions.InvalidEventIdException;
import com.ikt.event.management.entity.exceptions.InvalidPersonIdException;
import com.ikt.event.management.entity.exceptions.InvalidRoleIdException;
import com.ikt.event.management.repository.*;
import com.ikt.event.management.service.AttendanceService;
import com.ikt.event.management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final RoleRepository roleRepository;
    private final CompanyRepository companyRepository;
    private final AttendanceRepository attendanceRepository;

    public UserServiceImpl(UserRepository userRepositoryInterface, EventRepository eventRepository, RoleRepository roleRepository, CompanyRepository companyRepository, AttendanceRepository attendanceRepository) {
        this.userRepository = userRepositoryInterface;
        this.eventRepository = eventRepository;
        this.roleRepository = roleRepository;
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
    public User create(String personName, String personEmail, String phoneNumber, String companyName) {
        User user = new User(personName, personEmail, phoneNumber);
        Company company = companyRepository.findByName(companyName).orElse(null);
        user.setCompany(company);
        return userRepository.save(user);
    }

    @Override
    public void personRegistrationForEvent(Integer userID, Integer roleID, Integer eventID) {
        User user = findById(userID);

        Role role = roleRepository.findById(roleID.longValue()).orElseThrow(InvalidRoleIdException::new);
        user.getRolesUserHas().add(role);

        Event event = eventRepository.findById(eventID.longValue()).orElseThrow(InvalidEventIdException::new);
        Attendance attendance = new Attendance(role, user, event);
        attendanceRepository.save(attendance);
    }
}
