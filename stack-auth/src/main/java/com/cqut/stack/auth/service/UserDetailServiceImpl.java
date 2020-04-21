package com.cqut.stack.auth.service;

import com.alibaba.fastjson.JSONObject;
import com.cqut.stack.auth.serviceI.UserDetailService;
import com.cqut.stack.bn.dao.mapper.UserMapper;
import com.cqut.stack.bn.entity.entity.Permission;
import com.cqut.stack.bn.entity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@Service
public class UserDetailServiceImpl implements UserDetailService{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Transactional
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

}
