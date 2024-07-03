package com.twh.door.entity.DTO;

import com.twh.door.common.PageQuery;
import lombok.Data;

@Data
public class QueryGenealogyEntityDTO extends PageQuery {
    private String name;
    private String vagueName;
    private String living;
    private String bornDate;
    private String deathDay;
    private String parentId;
    private String sonId;
    private String partnerId;
    private String createTime;
    private String updateTime;

}
