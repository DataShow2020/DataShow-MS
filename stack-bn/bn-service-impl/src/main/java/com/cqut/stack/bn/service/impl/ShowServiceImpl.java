package com.cqut.stack.bn.service.impl;

import com.cqut.stack.bn.dao.mapper.ShowMapper;
import com.cqut.stack.bn.entity.entity.Show;
import com.cqut.stack.bn.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShowServiceImpl implements ShowService {
    @Autowired
    private ShowMapper showMapper;

    public ShowServiceImpl() {
        super();
    }

    public List<Show> getShowData(){
        return showMapper.getShowData();
    }
}
