package com.cqut.stack.bn.dao.mapper;


import com.cqut.stack.bn.entity.entity.Permission;
import com.cqut.stack.bn.entity.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User findUserByAccount(String account);
    Boolean insertUser(User user);
    Boolean checkAccount(@Param("account") String account);
    /**
     * 根据角色获取资源ID列表
     * @param account
     * @return
     */
    List<String> selectPermissionId(@Param("account") String account);

    /**
     * 根据资源ID列表获取资源列表
     * @param permissionIds
     * @return
     */
    List<Permission> selectPermissionListByUser(@Param("permissionIds") List<String> permissionIds);
}