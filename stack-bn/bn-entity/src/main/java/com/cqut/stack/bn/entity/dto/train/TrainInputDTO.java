package com.cqut.stack.bn.entity.dto.train;

import javax.validation.constraints.NotNull;

public class TrainInputDTO {
    @NotNull(message = "当前页不能为空")
    private Integer page;

    @NotNull(message = "分页大小不能为空")
    private Integer pageSize;

    private String id;

    private String words;

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }
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

}
