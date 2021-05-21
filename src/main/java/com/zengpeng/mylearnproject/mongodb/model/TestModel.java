package com.zengpeng.mylearnproject.mongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;


@Data
@Document(collection = "basic_test")
public class TestModel {
    @Id
    private String _id;
    private int id;
    private String name;
    private int sex;
    @Field(value = "createtime")
    private Date createTime;
}
