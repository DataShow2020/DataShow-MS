package com.cqut.stack.bn.service;

import com.cqut.stack.bn.entity.entity.Show;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShowService {
    /** 获取训练集中的数据 */
    List<Show> getShowData();
}