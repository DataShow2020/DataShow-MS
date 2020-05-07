package com.cqut.stack.bn.service;

import com.cqut.stack.bn.entity.dto.train.TrainInputDTO;
import com.cqut.stack.bn.entity.entity.Show;
import com.cqut.stack.bn.entity.entity.Train;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShowService {
    /** 获取训练集中的数据 */
    List<Train> getTrainData(TrainInputDTO inputDTO);

    /** 获取训练结果 */
    Show generateModel(String id);

    String getUserId(String userName);
}