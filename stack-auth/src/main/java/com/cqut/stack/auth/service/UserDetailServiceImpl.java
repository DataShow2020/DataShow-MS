package com.cqut.stack.auth.service;

import com.alibaba.fastjson.JSONObject;
import com.cqut.stack.auth.serviceI.UserDetailService;
import com.cqut.stack.bn.dao.mapper.UserMapper;
import com.cqut.stack.bn.entity.entity.Permission;
import com.cqut.stack.bn.entity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class UserDetailServiceImpl implements UserDetailService{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Boolean register(User user) {
        if(userMapper.checkAccount(user.getAccount())) return new Boolean(false);
        user.setUserId(UUID.randomUUID().toString());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userMapper.insertUser(user);
    }

    @Override
    public Boolean checkAccount(User user) {
        return userMapper.checkAccount(user.getAccount());
    }

    /**
     * 根据用户信息返回菜单路由
     * @param account
     * @return
     */
    @Override
    public List<Permission> selectPermissionListByUser(String account) {
        Boolean result = userMapper.checkAccount(account);

        if(result == false){
            return null;
        }

        List<String> permissionIds = userMapper.selectPermissionId(account);
        if(permissionIds.size() == 0){
            return null;
        }
        return userMapper.selectPermissionListByUser(permissionIds);
    }

    @Override
    public String queryRoleInfo(String account){
        return userMapper.findUserByAccount(account).getRole();
    }
}
