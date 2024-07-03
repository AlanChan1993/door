package com.twh.door.common;

import lombok.Data;

@Data
public class PageQuery {
    private long size;
    private long current;


    public long getSize() {
        return size==0?20:size;
    }
}
