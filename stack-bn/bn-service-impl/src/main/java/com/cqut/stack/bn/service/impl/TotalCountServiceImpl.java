package com.cqut.stack.bn.service.impl;

import com.cqut.stack.bn.dao.mapper.TotalCountMapper;
import com.cqut.stack.bn.entity.dto.total.AttributeAndCount;
import com.cqut.stack.bn.service.TotalCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TotalCountServiceImpl implements TotalCountService{

    @Autowired
    TotalCountMapper totalCountMapper;

    public List<AttributeAndCount> getTotalCountGender(){
        List<AttributeAndCount> list = totalCountMapper.getTotalCountGender();
        return list;
    }

    public List<AttributeAndCount> getTotalCountAge(){
        return totalCountMapper.getTotalCountAge();
    }

    public List<AttributeAndCount> getTotalCountEducation(){
        return totalCountMapper.getTotalCountEducation();
    }
}
