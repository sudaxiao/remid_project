package com.dfire.domain;

import lombok.Data;

/**
 * Created by xiaosuda on 2017/9/5.
 */
@Data
public class Task {
    private String id;
    private Integer number;
    private String name;
    private Long time;
    private Long createTime;
    private boolean isFinish;
    private int lastVer;
}
