package com.cqut.stack.bn.entity.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Permission {
    /** 资源ID */
    private String permissionId;

    /** 资源名称 */
    @JsonProperty("label")
    private String permissionName;

    /** 路径 */
    @JsonProperty("to")
    private String permissionPath;

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionPath() {
        return permissionPath;
    }

    public void setPermissionPath(String permissionPath) {
        this.permissionPath = permissionPath;
    }
}
