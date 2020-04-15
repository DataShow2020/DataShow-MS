package com.cqut.stack.bn.service.impl;


import com.cqut.stack.bn.dao.mapper.RoleManagementMapper;

import com.cqut.stack.bn.entity.dto.role.RoleTypeDTO;

import com.cqut.stack.bn.service.RoleManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleManagementServiceImpl implements RoleManagementService {

    @Autowired
    private RoleManagementMapper roleManagementMapper;

    @Override
    public List<RoleTypeDTO> selectRoleType() {
        //PageHelper.startPage(0, 0);
        return roleManagementMapper.selectRoleType();
    }

    @Override
    public boolean insertTest() {
        return roleManagementMapper.insertTest();
    }
}
