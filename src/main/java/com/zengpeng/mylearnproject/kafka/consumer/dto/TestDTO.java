package com.zengpeng.mylearnproject.kafka.consumer.dto;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class TestDTO {
    private int id;
    private String name;
    private int sex;
    private Timestamp createTime;

    public TestDTO(){}

    public TestDTO(int id,String name,int sex,Timestamp createTime){
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.createTime = createTime;
    }
}
