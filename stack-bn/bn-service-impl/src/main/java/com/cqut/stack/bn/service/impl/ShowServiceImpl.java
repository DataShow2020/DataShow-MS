package com.cqut.stack.bn.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cqut.stack.bn.dao.mapper.ShowMapper;
import com.cqut.stack.bn.entity.dto.train.TrainInputDTO;
import com.cqut.stack.bn.entity.entity.Show;
import com.cqut.stack.bn.entity.entity.Train;
import com.cqut.stack.bn.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

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
        for(Train item :trainData)
            item.setWords(item.getWords().concat("……等等"));
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
    /** 调用python脚本 */
    public static void modelTraining(){
        try {
            //需传入的参数
            String a = "car", b = "D3455054", c = "LJ12GKS28D4418248", d = "qingdao";
            System.out.println("开始" + a);
            //设置命令行传入参数
            String[] args = new String[] { "python", "com/cqut/stack/bn/util/Model/test.py", a, b, c, d };
            Process pr = Runtime.getRuntime().exec(args);

            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                line = decodeUnicode(line);
                System.out.println("---" + line);
            }
            in.close();
            pr.waitFor();
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static String decodeUnicode(final String dataStr) {
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }
    public static void test(){
        try {
            Process pr = Runtime.getRuntime().exec("C:\\Users\\gom\\Desktop\\DataShow-MS\\stack-bn\\bn-util\\src\\main\\java\\com\\cqut\\stack\\bn\\util\\Model\\test.py");
            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
//                line = decodeUnicode(line);
                System.out.println(line);
            }
            in.close();
            pr.waitFor();
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test(String[] args) {
        String[] arguments = new String[] {"python",
                                           "C:\\Users\\gom\\Desktop\\DataShow-MS\\stack-bn\\bn-util\\src\\main\\java\\com\\cqut\\stack\\bn\\util\\Model\\test.py",
                                           "gouman","21"

        };
        try {
            Process process = Runtime.getRuntime().exec(arguments);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            /** 成功则返回 0 */
            int re = process.waitFor();
            System.out.println(re);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    final String HOST = "127.0.0.1";
    final int PORT = 12345;
    /** 远程调用接口 */
    private Object remoteCall(String content){
        String name = remoteCall(content).getClass().getName();
        Logger log = Logger.getLogger(name);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content", content);
        String str = jsonObject.toJSONString();
        // 访问服务进程的套接字
        Socket socket = null;
//        List<Question> questions = new ArrayList<>();
        log.info("调用远程接口:host=>"+HOST+",port=>"+PORT);
        try {
            // 初始化套接字，设置访问服务的主机和进程端口号，HOST是访问python进程的主机名称，可以是IP地址或者域名，PORT是python进程绑定的端口号
            socket = new Socket(HOST,PORT);
            // 获取输出流对象
            OutputStream os = socket.getOutputStream();
            PrintStream out = new PrintStream(os);
            // 发送内容
            out.print(str);
            // 告诉服务进程，内容发送完毕，可以开始处理
            out.print("over");
            // 获取服务进程的输入流
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
            String tmp = null;
            StringBuilder sb = new StringBuilder();
            // 读取内容
            while((tmp=br.readLine())!=null)
                sb.append(tmp).append('\n');
            // 解析结果
            JSONArray res = JSON.parseArray(sb.toString());

            return res;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {if(socket!=null) socket.close();} catch (IOException e) {}
            log.info("远程接口调用结束.");
        }
        return null;
    }

    public String getUserId(String userName){
        return showMapper.getUserId(userName);
    }




}
