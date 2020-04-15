package com.cqut.stack.auth.controller;

import com.cqut.stack.auth.serviceI.UserDetailService;
import com.cqut.stack.bn.entity.global.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/module")
public class ModuleController {
    @Autowired
    private UserDetailService userDetailService;

    /**
     * 根据账户名获取资源列表
     * @param account
     * @return
     */
    @GetMapping("/selectModuleList/{account}")
    public JSONResult selectModuleList(@PathVariable String account){
        return new JSONResult(userDetailService.selectPermissionListByUser(account));
    }

    /**
     * 查询用户角色
     * @param account
     * @return
     */
    @GetMapping("/queryRoleInfo/{account}")
    public JSONResult queryRoleInfo(@PathVariable String account){
        return new JSONResult(userDetailService.queryRoleInfo(account));
    }
}
