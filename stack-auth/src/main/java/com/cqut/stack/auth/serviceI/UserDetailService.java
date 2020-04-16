package com.cqut.stack.auth.serviceI;

import com.cqut.stack.bn.entity.entity.Permission;
import com.cqut.stack.bn.entity.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserDetailService {

    Boolean register(User user);

    Boolean checkAccount(User user);
}
