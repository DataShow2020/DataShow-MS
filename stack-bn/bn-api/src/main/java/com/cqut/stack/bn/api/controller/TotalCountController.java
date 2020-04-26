package com.cqut.stack.bn.api.controller;

import com.cqut.stack.bn.entity.dto.total.AttributeAndCount;
import com.cqut.stack.bn.entity.global.JSONResult;
import com.cqut.stack.bn.service.TotalCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/totalCountController")
public class TotalCountController {

    @Autowired
    TotalCountService totalCountService;

    @GetMapping("/getTotalCountGender")
    public JSONResult getTotalCountGender() {
        List<AttributeAndCount> list = totalCountService.getTotalCountGender();
        return new JSONResult(list);
    }

    @GetMapping("/getTotalCountAge")
    public JSONResult getTotalCountAge() {
        return new JSONResult(totalCountService.getTotalCountAge());
    }

    @GetMapping("/getTotalCountEducation")
    public JSONResult getTotalCountEducation() {
        return new JSONResult(totalCountService.getTotalCountEducation());
    }


}
