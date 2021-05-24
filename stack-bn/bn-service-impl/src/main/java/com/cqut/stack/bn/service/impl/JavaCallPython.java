package com.cqut.stack.bn.service.impl;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.Socket;

public class JavaCallPython {
    public static void main(String[] args) {
        String str = remoteCall("昂的笔顺\t三年级上册数学口算\t60米差不多跑多长时间\t可可小爱起动保护装置\t龙岩公共资源交易中心\t似乎造句\t家给我的快乐是城堡儿歌\n").toString();
//        String str = remoteCall("词语这样动画片挖掘机\\t世纪东方地方\\t过年尊敬\\n").toString();
        System.out.println(str);
        String[] s = str.split("\\[");
        for(String item : s)
            System.out.println(item);
        for (int i = 0; i < s[1].length(); i++) {
            System.out.println(s[1].charAt(i) + "---" + i);
        }
//        String s = "风格风格灌灌灌灌\\t法国发过v踩踩踩\\t餐馆打工的方法\\t回复四十风华是否还会杀杀杀\\t公司法官方否认分公司分管\\t方法灌灌灌水灌水规划和\\t通融通融通融通融\\t让如题如题如题\\t灌水灌水风格十分广泛\\t分公司分公司宝宝\\n";
//        s = s.replaceAll("t|n|\\\\"," ");
//        System.out.println(s);
    }

    public static String HOST = "127.0.0.1";
    public static int PORT = 8888;
    public static Object remoteCall(String words){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("words", words);
        String str = jsonObject.toJSONString();
        // 访问服务进程的套接字
        Socket socket = null;
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
            return sb;
        } catch (IOException e) {
//            System.out.println("1111");
            e.printStackTrace();
        }
        finally {
            try {
                System.out.println(socket);
                if(socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("远程接口调用结束");
        }
        return null;
    }
}
