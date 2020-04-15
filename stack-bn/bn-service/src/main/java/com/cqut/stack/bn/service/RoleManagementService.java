package com.cqut.stack.bn.service;



import com.cqut.stack.bn.entity.dto.role.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RoleManagementService{
    List<RoleTypeDTO> selectRoleType();
    boolean insertTest();
}