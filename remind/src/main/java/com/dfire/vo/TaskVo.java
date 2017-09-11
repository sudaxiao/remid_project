package com.dfire.vo;

import lombok.Data;

/**
 * Created by xiaosuda on 2017/9/8.
 */
@Data
public class TaskVo {
    private String id;
    private Integer number;
    private String name;
    private String time;
    private boolean isFinish;
    private float progress;
    private String color;
}
