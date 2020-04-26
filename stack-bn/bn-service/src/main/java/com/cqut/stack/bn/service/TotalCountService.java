package com.cqut.stack.bn.service;

import com.cqut.stack.bn.entity.dto.total.AttributeAndCount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TotalCountService {
    public List<AttributeAndCount> getTotalCountGender();

    public List<AttributeAndCount> getTotalCountAge();

    public List<AttributeAndCount> getTotalCountEducation();
}
