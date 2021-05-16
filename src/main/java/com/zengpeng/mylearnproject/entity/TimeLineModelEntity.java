package com.zengpeng.mylearnproject.entity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "crm_event_action_tmp")
public class TimeLineModelEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Integer status;


    public TimeLineModelEntity updateTimeLineModel(TimeLineModelEntity timeLineModelEntity) {
        if (timeLineModelEntity.getId() != null && timeLineModelEntity.getId() != 0)
            this.id = timeLineModelEntity.getId();
        if (timeLineModelEntity.getOrg_id() != null && timeLineModelEntity.getOrg_id() != 0)
            this.org_id = timeLineModelEntity.getOrg_id();
        if (timeLineModelEntity.getCompany_id() != null && timeLineModelEntity.getCompany_id() != 0)
            this.company_id = timeLineModelEntity.getCompany_id();
        if (timeLineModelEntity.getContacts_id() != null && timeLineModelEntity.getContacts_id() != 0)
            this.contacts_id = timeLineModelEntity.getContacts_id();
        if (StringUtils.isNotBlank(timeLineModelEntity.getContacts_name()))
            this.contacts_name = timeLineModelEntity.getContacts_name();
        if (StringUtils.isNotBlank(timeLineModelEntity.getInquiry_id()))
            this.inquiry_id = timeLineModelEntity.getInquiry_id();
        if (StringUtils.isNotBlank(timeLineModelEntity.getVisitor_id()))
            this.visitor_id = timeLineModelEntity.getVisitor_id();
        if (StringUtils.isNotBlank(timeLineModelEntity.getClue_id()))
            this.clue_id = timeLineModelEntity.getClue_id();
        if (StringUtils.isNotBlank(timeLineModelEntity.getEmail()))
            this.email = timeLineModelEntity.getEmail();
        if (timeLineModelEntity.getEvent_category() != null && timeLineModelEntity.getEvent_category() != 0)
            this.event_category = timeLineModelEntity.getEvent_category();
        if (StringUtils.isNotBlank(timeLineModelEntity.getEvent_id()))
            this.event_id = timeLineModelEntity.getEvent_id();
        if (timeLineModelEntity.getEvent_time() != null)
            this.event_time = timeLineModelEntity.getEvent_time();
        if (StringUtils.isNotBlank(timeLineModelEntity.getEvent_user()))
            this.event_user = timeLineModelEntity.getEvent_user();
        if (StringUtils.isNotBlank(timeLineModelEntity.getEvent_action()))
            this.event_action = timeLineModelEntity.getEvent_action();
        if (StringUtils.isNotBlank(timeLineModelEntity.getEvent_content()))
            this.event_content = timeLineModelEntity.getEvent_content();
        if (StringUtils.isNotBlank(timeLineModelEntity.getEvent_custom_var()))
            this.event_custom_var = timeLineModelEntity.getEvent_custom_var();
        if (StringUtils.isNotBlank(timeLineModelEntity.getUuid()))
            this.uuid = timeLineModelEntity.getUuid();
        if (timeLineModelEntity.getCreate_userid() != null && timeLineModelEntity.getCreate_userid() != 0)
            this.create_userid = timeLineModelEntity.getCreate_userid();
        if (timeLineModelEntity.getCreate_time() != null)
            this.create_time = timeLineModelEntity.getCreate_time();
        if (timeLineModelEntity.getUpdate_userid() != null && timeLineModelEntity.getUpdate_userid() != 0)
            this.update_userid = timeLineModelEntity.getUpdate_userid();
        if (timeLineModelEntity.getUpdate_time() != null)
            this.update_time = timeLineModelEntity.getUpdate_time();
        if (timeLineModelEntity.getStatus() != 0)
            this.status = timeLineModelEntity.getStatus();
        return this;
    }
}
