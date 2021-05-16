package com.zengpeng.mylearnproject.mongodb.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document(collection = "basic_timeline_sef")
public class TimeLineModel implements Serializable {

    @Id
    private String _id;
    private Long id;
    private Integer org_id;
    private Integer company_id;
    private Integer contacts_id;
    private String contacts_name;
    private String inquiry_id;
    private String visitor_id;
    private String clue_id;
    private String email;
    private Integer event_category;
    private String event_id;
    private Date event_time;
    private String event_user;
    private String event_action;
    private String event_content;
    private String event_custom_var;
    private String uuid;
    private Integer create_userid;
    private Date create_time;
    private Integer update_userid;
    private Date update_time;
    private int status;

    public TimeLineModel updateTimeLineModel(TimeLineModel timeLineModel) {
        if (StringUtils.isNotBlank(timeLineModel.get_id()))
            this._id = timeLineModel.get_id();
        if (timeLineModel.getId() != null && timeLineModel.getId() != 0)
            this.id = timeLineModel.getId();
        if (timeLineModel.getOrg_id()!=null&&timeLineModel.getOrg_id() != 0)
            this.org_id = timeLineModel.getOrg_id();
        if (timeLineModel.getCompany_id()!=null&&timeLineModel.getCompany_id() != 0)
            this.company_id = timeLineModel.getCompany_id();
        if (timeLineModel.getContacts_id()!=null&&timeLineModel.getContacts_id() != 0)
            this.contacts_id = timeLineModel.getContacts_id();
        if (StringUtils.isNotBlank(timeLineModel.getContacts_name()))
            this.contacts_name = timeLineModel.getContacts_name();
        if (StringUtils.isNotBlank(timeLineModel.getInquiry_id()))
            this.inquiry_id = timeLineModel.getInquiry_id();
        if (StringUtils.isNotBlank(timeLineModel.getVisitor_id()))
            this.visitor_id = timeLineModel.getVisitor_id();
        if (StringUtils.isNotBlank(timeLineModel.getClue_id()))
            this.clue_id = timeLineModel.getClue_id();
        if (StringUtils.isNotBlank(timeLineModel.getEmail()))
            this.email = timeLineModel.getEmail();
        if (timeLineModel.getEvent_category() != 0)
            this.event_category = timeLineModel.getEvent_category();
        if (StringUtils.isNotBlank(timeLineModel.getEvent_id()))
            this.event_id = timeLineModel.getEvent_id();
        if (timeLineModel.getEvent_time() != null)
            this.event_time = timeLineModel.getEvent_time();
        if (StringUtils.isNotBlank(timeLineModel.getEvent_user()))
            this.event_user = timeLineModel.getEvent_user();
        if (StringUtils.isNotBlank(timeLineModel.getEvent_action()))
            this.event_action = timeLineModel.getEvent_action();
        if (StringUtils.isNotBlank(timeLineModel.getEvent_content()))
            this.event_content = timeLineModel.getEvent_content();
        if (StringUtils.isNotBlank(timeLineModel.getEvent_custom_var()))
            this.event_custom_var = timeLineModel.getEvent_custom_var();
        if (StringUtils.isNotBlank(timeLineModel.getUuid()))
            this.uuid = timeLineModel.getUuid();
        if (timeLineModel.getCreate_userid()!=null&&timeLineModel.getCreate_userid() != 0)
            this.create_userid = timeLineModel.getCreate_userid();
        if (timeLineModel.getCreate_time() != null)
            this.create_time = timeLineModel.getCreate_time();
        if (timeLineModel.getUpdate_userid() !=null&&timeLineModel.getUpdate_userid() != 0)
            this.update_userid = timeLineModel.getUpdate_userid();
        if (timeLineModel.getUpdate_time() != null)
            this.update_time = timeLineModel.getUpdate_time();
        if (timeLineModel.getStatus() != 0)
            this.status = timeLineModel.getStatus();
        return this;
    }
}
