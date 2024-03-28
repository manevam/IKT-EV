package com.ikt.event.management.service.impl;

import com.ikt.event.management.entity.Role;
import com.ikt.event.management.repository.RoleRepository;
import com.ikt.event.management.service.AttendanceService;
import com.ikt.event.management.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> listAll() {
        return roleRepository.findAll();
    }
}
