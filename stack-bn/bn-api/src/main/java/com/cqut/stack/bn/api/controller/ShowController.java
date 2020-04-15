package com.cqut.stack.bn.api.controller;

import com.cqut.stack.bn.entity.dto.show.ShowInputDTO;
import com.cqut.stack.bn.entity.entity.Show;
import com.cqut.stack.bn.entity.global.JSONResult;
import com.cqut.stack.bn.service.ShowService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ShowController {
    @Autowired
    private ShowService showService;

    @GetMapping("/getShowData")
    public JSONResult getShowData(@Valid ShowInputDTO inputDTO){
        /** mapper接口被检测前使用，紧跟的第一个select方法会被分页 */
        PageHelper.startPage((inputDTO.getPage()-1)*inputDTO.getPageSize(),inputDTO.getPageSize());
        JSONResult<List<Show>> jsonResult = new JSONResult<>();
        jsonResult.setData(showService.getShowData());
        return jsonResult;
    }
}
