package com.dfire.controller;

import com.dfire.domain.Task;
import com.dfire.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xiaosuda on 2017/9/5.
 */
@RestController
@RequestMapping("/remind")
public class RemindController {
    @Autowired
    private TaskService taskService;

    @RequestMapping("/show")
    @ResponseBody
    public Object getAll() {
        List<Task> tasks = taskService.findAll();
        return  tasks;
    }


}
