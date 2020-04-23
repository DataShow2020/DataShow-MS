package com.cqut.stack.bn.api.controller;

import com.cqut.stack.bn.entity.dto.show.ShowInputDTO;
import com.cqut.stack.bn.entity.dto.train.TrainInputDTO;
import com.cqut.stack.bn.entity.entity.Show;
import com.cqut.stack.bn.entity.entity.Train;
import com.cqut.stack.bn.entity.global.JSONResult;
import com.cqut.stack.bn.service.ShowService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ShowController {
    @Autowired
    private ShowService showService;

    /**
     * 获取训练数据信息
     * @param inputDTO
     * @return
     */
    @GetMapping("/getShowData")
    public JSONResult getShowData(@Valid TrainInputDTO inputDTO){
        /** mapper接口被检测前使用，紧跟的第一个select方法会被分页 */
        PageHelper.startPage((inputDTO.getPage()-1)*inputDTO.getPageSize(),inputDTO.getPageSize());
        JSONResult<List<Train>> jsonResult = new JSONResult<>();
        jsonResult.setData(showService.getTrainData(inputDTO));
        jsonResult.setTotalCount(10000);
        return jsonResult;
    }

    /**
     * 获取模型数据信息
     * @param id
     * @return
     */
    @GetMapping("/generateModel")
    public JSONResult generateModel(@RequestParam String id){
        JSONResult<Show> jsonResult = new JSONResult<>();
        jsonResult.setData(showService.generateModel(id));
        return jsonResult;
    }
}
