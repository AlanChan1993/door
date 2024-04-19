package com.twh.door.entity.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)//用于前端返回时，不返回值为null的属性
public class DoorUserVO {
    private Long id;
    private String userName;
    private String passWord;
    private String fullName;
    private String remark;
    private Integer age;
    private String bornDate;

    //private List<DoorUser> userList = new ArrayList<>();
}
