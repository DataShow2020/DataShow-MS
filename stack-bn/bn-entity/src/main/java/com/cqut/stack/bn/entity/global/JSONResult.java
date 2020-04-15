package com.cqut.stack.bn.entity.global;

import com.cqut.stack.bn.util.constants.ResponseCodeConstants;
import io.swagger.annotations.ApiModelProperty;

public class JSONResult<T> {

    private String message;

    private int code;
    @ApiModelProperty(value = "返回数据", name = "data", dataType = "Object")
    private T data;

    public JSONResult(Integer page, Integer pageSize, Integer totalCount, T data) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.data = data;
    }
    public JSONResult(String message, int code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }
    public JSONResult(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public JSONResult(int code, T data) {
        this.code = code;
        this.data = data;
    }
//    public JSONResult(T data) {
//        this.data = data;
//    }
//    /**
//     * 返回数据
//     */
//    @ApiModelProperty(value = "返回数据", name = "data", dataType = "Object")
//    private T data;
    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页", name = "page", dataType = "Integer")
    private Integer page;

    /**
     * 分页大小
     */
    @ApiModelProperty(value = "分页大小", name = "pageSize", dataType = "Integer")
    private Integer pageSize;

    /**
     * 总记录数
     */
    @ApiModelProperty(value = "总记录数", name = "totalCount", dataType = "Integer")
    private Integer totalCount;

    public JSONResult(T data) {
        this(ResponseCodeConstants.SUCCESS, data);
        this.data = data;
    }

    private JSONResult(int code) {
        this.code = code;
    }

    public JSONResult() {
        this(ResponseCodeConstants.SUCCESS);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    /**
     * 返回 当前页
     */
    public Integer getPage() {
        return page;
    }

    /**
     * 设置 当前页
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * 返回 分页大小
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置 分页大小
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 返回 总记录数
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * 设置 总记录数
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public static String CODE_KEY = "code";

    public static String MESSAGE_KEY = "message";

    public static String DATA_KEY = "data";
}

