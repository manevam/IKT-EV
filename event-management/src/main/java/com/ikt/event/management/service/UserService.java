package com.ikt.event.management.service;

import com.ikt.event.management.entity.Company;
import com.ikt.event.management.entity.User;

import java.util.List;

public interface UserService {

    List<User> listAll();

    User findById(Integer personID);

    User create(String personName, String personEmail, String phoneNumber, String company);

    void personRegistrationForEvent(Integer personID, Integer roleID, Integer eventID);
}
