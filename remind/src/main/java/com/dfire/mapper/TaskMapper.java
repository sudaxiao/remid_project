package com.dfire.mapper;

import com.dfire.domain.Task;

import java.util.List;

/**
 * Created by xiaosuda on 2017/9/5.
 */
public interface TaskMapper {

    List<Task> selectAll();
    int selectMaxNumber();
    int insert(Task task);
    int deleteById(String id);
    Task selectById(String id);
}
