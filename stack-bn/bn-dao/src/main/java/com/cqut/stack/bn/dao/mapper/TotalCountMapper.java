package com.cqut.stack.bn.dao.mapper;

import com.cqut.stack.bn.entity.dto.total.AttributeAndCount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TotalCountMapper {

    public List<AttributeAndCount> getTotalCountGender();

    public List<AttributeAndCount> getTotalCountAge();

    public List<AttributeAndCount> getTotalCountEducation();
}
