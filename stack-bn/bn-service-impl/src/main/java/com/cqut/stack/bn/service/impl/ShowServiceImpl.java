package com.cqut.stack.bn.service.impl;

import com.cqut.stack.bn.dao.mapper.ShowMapper;
import com.cqut.stack.bn.entity.dto.train.TrainInputDTO;
import com.cqut.stack.bn.entity.dto.train.UserInfoInputDTO;
import com.cqut.stack.bn.entity.entity.Show;
import com.cqut.stack.bn.entity.entity.Train;
import com.cqut.stack.bn.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class ShowServiceImpl implements ShowService {
    @Autowired
    private ShowMapper showMapper;

    public ShowServiceImpl() {
        super();
    }

    /**
     * 获取训练数据
     * @return
     */
    @Override
    public List<Train> getTrainData(TrainInputDTO inputDTO){
        List<Train> trainData = showMapper.getTrainData(inputDTO);
        for(Train item :trainData){
            String words = item.getWords();
            if(words != null){
                words = words.replaceAll("t|n|\\\\"," ").concat("……等等");
                item.setWords(words);
            }

        }

        return trainData;
    }

    /**
     * 获取模型数据
     * @param id
     * @return
     */
    @Override
    public Show generateModel(String id){
        Show ModelData = showMapper.generateModel(id);
        String prob = ModelData.getProb().substring(1,ModelData.getProb().length()-1);
        String[] temp = prob.split(",");
        List<List<String>> probs = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            temp[i] = temp[i].replaceAll(":",",");
            List<String> str = Arrays.asList(temp[i]);
            probs.add(str);
        }
        ModelData.setProbs(probs);
        return ModelData;
    }
    public UserInfoInputDTO userInfoInputDTO;
    /** 调用模型，保存模型 */
    @Transactional
    public Show saveModel(UserInfoInputDTO userInfoInputDTO){
        /** 获取模型输出结果 */
        System.out.println(userInfoInputDTO.getWords());
        String modelResult = JavaCallPython.remoteCall(userInfoInputDTO.getWords()).toString();
        String[] s = modelResult.split("\\[");
        Show show = new Show();
        /** 由于输出固定，可直接从切割的字符串中拿到想要的字符 */
        show.setAge(Character.toString(s[1].charAt(0)));
        show.setEducation(Character.toString(s[1].charAt(3)));
        show.setGender(Character.toString(s[1].charAt(6)));
        show.setProb(s[0]);
        show.setId(userInfoInputDTO.getId());
        String words = s[0];
        String keyWords = "";
        int index_begin = 0;
        while(index_begin >= 0){
            index_begin = words.indexOf("'");
            if(index_begin < 0)
                break;
            int index_end = words.indexOf("'",index_begin + 1);
            String keyWord = words.substring(index_begin + 1,index_end) + " ";
            keyWords = keyWords.concat(keyWord);
            words = words.substring(index_end + 1);
        }
        show.setWords(keyWords);
        boolean isSave = false;
        /** 将数据存入最终结果表 keyprobs */
        try{
            isSave = showMapper.saveModel(show);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(!isSave){
            showMapper.updateModel(show);
        }
            return generateModel(userInfoInputDTO.getId());
    }

    public String getUserId(String userName){
        return showMapper.getUserId(userName);
    }




}
