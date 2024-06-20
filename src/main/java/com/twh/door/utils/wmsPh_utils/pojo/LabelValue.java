package com.twh.door.utils.wmsPh_utils.pojo;

import lombok.Data;

@Data
public class LabelValue<L,V>{
    private L label;

    private V val;
}
