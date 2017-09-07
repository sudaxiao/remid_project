package com.dfire.service.impl;

import com.dfire.domain.Task;
import com.dfire.mapper.TaskMapper;
import com.dfire.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiaosuda on 2017/9/6.
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public List<Task> findAll() {
        return taskMapper.selectAll();
    }
}
