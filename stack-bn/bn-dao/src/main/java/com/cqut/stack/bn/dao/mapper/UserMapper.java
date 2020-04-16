package com.cqut.stack.bn.dao.mapper;


import com.cqut.stack.bn.entity.entity.Permission;
import com.cqut.stack.bn.entity.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    User findUserByAccount(String account);

    Boolean insertUser(User user);

    Boolean insertUserRoleRelation(@Param("UserRoleRelationId") String id);

    Boolean checkAccount(@Param("account") String account);
}