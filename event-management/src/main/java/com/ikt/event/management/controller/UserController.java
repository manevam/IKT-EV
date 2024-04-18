package com.ikt.event.management.controller;

import com.ikt.event.management.entity.Role;
import com.ikt.event.management.entity.User;
import com.ikt.event.management.entity.exceptions.InvalidEventIdException;
import com.ikt.event.management.entity.exceptions.InvalidPersonIdException;
import com.ikt.event.management.entity.exceptions.InvalidRoleIdException;
import com.ikt.event.management.repository.views.UserRegistrationDto;
import com.ikt.event.management.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create a new user
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UserRegistrationDto createUserRequest) {
        try {
            User user = userService.create(
                    createUserRequest.getPersonName(),
                    createUserRequest.getPersonEmail(),
                    createUserRequest.getPhoneNumber(),
                    createUserRequest.getCompanyName(),
                    createUserRequest.getRole()
            );
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = userService.listAll();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{userID}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userID) {
        try {
            User user = userService.findById(userID);
            return ResponseEntity.ok(user);
        } catch (InvalidPersonIdException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/{userID}/register")
    public ResponseEntity<String> registerForEvent(@PathVariable Integer userID,
                                                   @RequestParam Integer roleId,
                                                   @RequestParam Integer eventId,
                                                   @RequestParam(required = false) Role role) {
        try {
            userService.personRegistrationForEvent(userID, roleId, eventId, role);
            return ResponseEntity.ok("User registered for event successfully.");
        } catch (InvalidPersonIdException | InvalidRoleIdException | InvalidEventIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
