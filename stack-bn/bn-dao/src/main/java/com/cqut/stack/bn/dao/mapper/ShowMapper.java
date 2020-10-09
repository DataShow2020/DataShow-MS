package com.cqut.stack.bn.dao.mapper;

import com.cqut.stack.bn.entity.dto.train.TrainInputDTO;
import com.cqut.stack.bn.entity.entity.Show;
import com.cqut.stack.bn.entity.entity.Train;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowMapper {
     /** 获取训练集中的数据 */

     List<Train> getTrainData(TrainInputDTO inputDTO);

     /** 获取生成模型数据 */
     Show generateModel ( String id);

     /** 将模型存入最终结果表 */
     boolean saveModel(Show show);

     boolean updateModel(Show show);

     String getUserId(String userName);
}
