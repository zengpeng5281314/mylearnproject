package com.zengpeng.mylearnproject.mongodb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.Date;

@Data
@Document(collection = "basic_timeline")
public class TimeLineModel implements Serializable {

    @Id
    private String _id;
    private int id;
    private int org_id;
    private int company_id;
    private int contacts_id;
    private String contacts_name;
    private String inquiry_id;
    private String visitor_id;
    private String clue_id;
    private String email;
    private int event_category;
    private String event_id;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date event_time;
    private String event_user;
    private String event_action;
    private String event_content;
    private String event_custom_var;
    private String uuid;
    private int create_userid;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    private int update_userid;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date update_time;
    private int status;
}
