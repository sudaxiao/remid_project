package com.dfire.service;

import com.dfire.util.JsonResponse;
import com.dfire.vo.TaskVo;

import java.util.List;

/**
 * Created by xiaosuda on 2017/9/6.
 */
public interface TaskService {

    List<TaskVo> findAll();

    JsonResponse add(String name, String time);

    JsonResponse deleteById(String id);

    JsonResponse selectById(String id);
}
