package com.ikt.event.management.repository.views;

import com.ikt.event.management.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDto {
    String personName;
    String personEmail;
    String phoneNumber;
    String companyName;
    Role role;
}
