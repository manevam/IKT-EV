package com.ikt.event.management.service;

import com.ikt.event.management.entity.Role;
import com.ikt.event.management.entity.User;

import java.util.List;

public interface UserService {

    List<User> listAll();

    User findById(Integer personID);

    User create(String personName, String personEmail, String phoneNumber, String companyName, Role role);

    void personRegistrationForEvent(Integer userID, Integer roleID, Integer eventID, Role role);
}
