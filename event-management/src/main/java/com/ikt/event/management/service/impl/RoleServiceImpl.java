package com.ikt.event.management.service.impl;

import com.ikt.event.management.entity.Role;
import com.ikt.event.management.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    @Override
    public List<Role> listAll() {
        return null;
    }
}
