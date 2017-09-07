package com.dfire.mapper;

import com.dfire.domain.Task;

import java.util.List;

/**
 * Created by xiaosuda on 2017/9/5.
 */
public interface TaskMapper {

 /*    int add(Task task);
     int delete(Task task);
     int update(Task task);
     int selectById(Integer id);*/
     List<Task> selectAll();
}
