package com.cqut.stack.bn.entity.dto.train;

import javax.validation.constraints.NotNull;

public class UserInfoInputDTO {
    @NotNull(message = "用户id不能为空")
    private String id;

    private String words;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @NotNull(message = "关键词不能为空")
    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }
}
