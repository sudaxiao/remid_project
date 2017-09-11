package com.dfire.service.impl;

import com.dfire.domain.Task;
import com.dfire.mapper.TaskMapper;
import com.dfire.service.TaskService;
import com.dfire.util.DateTimeTransUtil;
import com.dfire.util.JsonResponse;
import com.dfire.vo.TaskVo;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by xiaosuda on 2017/9/6.
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    /**
     * 查询所有任务
     *
     * @return List<TaskVo>
     */
    @Override
    public List<TaskVo> findAll() {
        List<Task> tasks = taskMapper.selectAll();
        List<TaskVo> taskVos = new ArrayList<>();
        for (Task task : tasks) {
            TaskVo taskVo = new TaskVo();
            BeanUtils.copyProperties(task, taskVo);
            taskVo.setTime(DateTimeTransUtil.dateTimeLongToString(task.getTime()));
            float progress = 0.0f;
            if(System.currentTimeMillis() >= task.getTime()) {
                progress = 150;
            } else {
                progress = ((float) (System.currentTimeMillis() - task.getCreateTime()) / (float) (task.getTime() - task.getCreateTime())) * 100;
            }


            taskVo.setProgress(progress < 0 ? -progress : progress);
            if (progress <= 60) {
                taskVo.setColor("progress-bar-success");
            } else if (progress <= 80) {
                taskVo.setColor("progress-bar-info");
            } else if (progress <= 100) {
                taskVo.setColor("progress-bar-warning");
            } else {
                taskVo.setColor("progress-bar-danger");
            }
            taskVos.add(taskVo);
        }
        return taskVos;
    }

    /**
     * 添加任务
     *
     * @param name 任务名称
     * @param time 预计任务完成时间
     * @return
     */
    @Override
    public JsonResponse add(String name, String time) {
        Task task = new Task();
        task.setId(UUID.randomUUID().toString().replace("-", ""));
        task.setFinish(false);
        task.setName(name);
        task.setNumber(taskMapper.selectMaxNumber() + 1);
        task.setTime(DateTimeTransUtil.datetimeStringToLong(time));
        task.setCreateTime(System.currentTimeMillis());
        int line = taskMapper.insert(task);
        if (line > 0) {
            return new JsonResponse("添加成功", true);
        } else {
            return new JsonResponse("添加失败", false);
        }
    }

    @Override
    public JsonResponse deleteById(String id) {
        int line = taskMapper.deleteById(id);
        if (line > 0) {
            return new JsonResponse("删除成功", true);
        } else {
            return new JsonResponse("删除失败", false);
        }
    }

    @Override
    public JsonResponse selectById(String id) {
        Task task = taskMapper.selectById(id);
        if (task == null) {
            return new JsonResponse("查询任务为空", false);
        }
        return new JsonResponse("查询成功", true, task);
    }
}
