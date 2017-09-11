package com.dfire.controller;

import com.dfire.service.TaskService;
import com.dfire.util.JsonResponse;
import com.dfire.vo.TaskVo;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    public JsonResponse getAll() {
        List<TaskVo> tasks = taskService.findAll();
        if (tasks == null) {
            return new JsonResponse("加载数据失败", false);
        } else {
            return new JsonResponse("加载数据成功", true, tasks);
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    public JsonResponse add(@RequestParam("name") @Valid @NotEmpty @NotNull(message = "任务名称不能为空") String name,
                            @RequestParam("time") @Valid @NotEmpty @NotNull(message = "完成时间不能为空") String time) {
        if (StringUtils.isAnyBlank(name, time)) {
            return new JsonResponse("信息填写不完整", false);
        }
        return taskService.add(name, time);
    }

    @RequestMapping("/del")
    @ResponseBody
    public JsonResponse delete(@RequestParam("id") @Valid @NotEmpty @NotNull(message = "任务id不能为空") String id) {
        return taskService.deleteById(id);
    }

    @RequestMapping("/find")
    @ResponseBody
    public JsonResponse find(@RequestParam("id") @Valid @NotEmpty @NotNull(message = "任务id不能为空") String id) {
        return taskService.selectById(id);
    }
}
