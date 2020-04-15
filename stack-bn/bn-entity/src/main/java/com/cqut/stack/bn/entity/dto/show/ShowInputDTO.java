package com.cqut.stack.bn.entity.dto.show;

import javax.validation.constraints.NotNull;

public class ShowInputDTO {
    @NotNull(message = "当前页不能为空")
    private Integer page;

    @NotNull(message = "分页大小不能为空")
    private Integer pageSize;

    private String id;

    private int age;

    private int gender;

    private int education;

    public Integer getPage() {
        return page;
    }
    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getEducation() {
        return education;
    }

    public void setEducation(int education) {
        this.education = education;
    }

}
