package com.cqut.stack.bn.service;

import com.cqut.stack.bn.entity.dto.train.TrainInputDTO;
import com.cqut.stack.bn.entity.dto.train.UserInfoInputDTO;
import com.cqut.stack.bn.entity.entity.Show;
import com.cqut.stack.bn.entity.entity.Train;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Service
public interface ShowService {
    /** 获取收藏集中的数据 */
    List<Train> getTrainData();

    /** 获取训练结果 */
    Show generateModel(String id);

    /** 调用模型 */
    Show saveModel(UserInfoInputDTO userInfoInputDTO);

    String getUserId(String userName);

    HashMap<String, Integer> test(HttpServletRequest request);
}