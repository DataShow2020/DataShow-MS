package com.cqut.stack.bn.api.controller;

import com.cqut.stack.bn.entity.global.JSONResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TaskController {

    @GetMapping
    public JSONResult listTasks(){
        System.out.println("任务列表");
        return new JSONResult("任务列表");
    }


    @PostMapping
    public String newTasks(){
        return "创建了一个新的任务";
    }

    @PutMapping("/{taskId}")
    public String updateTasks(@PathVariable("taskId")Integer id){
        return "更新了一下id为:"+id+"的任务";
    }

    @DeleteMapping("/{taskId}")
    public String deleteTasks(@PathVariable("taskId")Integer id){
        return "删除了id为:"+id+"的任务";
    }
}

