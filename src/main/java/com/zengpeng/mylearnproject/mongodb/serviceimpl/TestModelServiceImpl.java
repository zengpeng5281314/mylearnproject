package com.zengpeng.mylearnproject.mongodb.serviceimpl;

import com.zengpeng.mylearnproject.entity.TimeLineModelEntity;
import com.zengpeng.mylearnproject.mongodb.dal.TestDTORepository;
import com.zengpeng.mylearnproject.mongodb.model.TestModel;
import com.zengpeng.mylearnproject.mongodb.model.TimeLineModel;
import com.zengpeng.mylearnproject.mongodb.service.TestModelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestModelServiceImpl implements TestModelService {

    @Autowired
    private TestDTORepository testDTORepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public TestModel findOneByIDSB(int id) {
//        Query query=new Query(Criteria.where("id").is(id));
//        return mongoTemplate.findOne(query,TestModel.class);


        TestModel testModel = new TestModel();
        testModel.setId(id);
        //此处是根据指定条件精确查询
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreNullValues()
                .withMatcher("id", ExampleMatcher.GenericPropertyMatchers.contains())
            .withIgnorePaths("sex","_class");
        Example<TestModel> example = Example.of(testModel,matcher);

        Optional<TestModel> optional = testDTORepository.findOne(example);
        if(optional.isPresent())
            return optional.get();
        return null;
    }

    @Override
    public List<TestModel> getTestModelByName(String name) {
        TestModel testModel = new TestModel();
        testModel.setName(name);
        //此处是根据指定条件模糊查找
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains ())
                .withIgnorePaths("sex","id","_class");
        Example<TestModel> example = Example.of(testModel,matcher);
        List<TestModel> list = testDTORepository.findAll(example);
        return list;
    }

    @Override
    public Page<TestModel> getTestModelByName2(String name) {
        TestModel testModel = new TestModel();
        testModel.setName(name);
        //此处是根据指定条件模糊查找
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains ())
                .withIgnorePaths("sex","id","_class");
        Example<TestModel> example = Example.of(testModel,matcher);
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(0, 10, sort);
        Page<TestModel> page = testDTORepository.findAll(example,pageable);
        return page;
    }

    @Override
    public TimeLineModel conversionTimeLineModel(TimeLineModelEntity timeLineModelEntity) {
        TimeLineModel timeLineModel = new TimeLineModel();
        if (timeLineModelEntity.getId() != null && timeLineModelEntity.getId() != 0)
            timeLineModel.setId(timeLineModelEntity.getId());
        if (timeLineModelEntity.getOrg_id() != null && timeLineModelEntity.getOrg_id() != 0)
            timeLineModel.setOrg_id(timeLineModelEntity.getOrg_id());
        if (timeLineModelEntity.getCompany_id() != null && timeLineModelEntity.getCompany_id() != 0)
            timeLineModel.setCompany_id(timeLineModelEntity.getCompany_id());
        if (timeLineModelEntity.getContacts_id() != null && timeLineModelEntity.getContacts_id() != 0)
            timeLineModel.setContacts_id(timeLineModelEntity.getContacts_id());
        if (StringUtils.isNotBlank(timeLineModelEntity.getContacts_name()))
            timeLineModel.setContacts_name(timeLineModelEntity.getContacts_name());
        if (StringUtils.isNotBlank(timeLineModelEntity.getInquiry_id()))
            timeLineModel.setInquiry_id(timeLineModelEntity.getInquiry_id());
        if (StringUtils.isNotBlank(timeLineModelEntity.getVisitor_id()))
            timeLineModel.setVisitor_id(timeLineModelEntity.getVisitor_id());
        if (StringUtils.isNotBlank(timeLineModelEntity.getClue_id()))
            timeLineModel.setClue_id(timeLineModelEntity.getClue_id());
        if (StringUtils.isNotBlank(timeLineModelEntity.getEmail()))
            timeLineModel.setEmail(timeLineModelEntity.getEmail());
        if (timeLineModelEntity.getEvent_category() != null && timeLineModelEntity.getEvent_category() != 0)
            timeLineModel.setEvent_category(timeLineModelEntity.getEvent_category());
        if (StringUtils.isNotBlank(timeLineModelEntity.getEvent_id()))
            timeLineModel.setEvent_id(timeLineModelEntity.getEvent_id());
        if (timeLineModelEntity.getEvent_time() != null)
            timeLineModel.setEvent_time(timeLineModelEntity.getEvent_time());
        if (StringUtils.isNotBlank(timeLineModelEntity.getEvent_user()))
            timeLineModel.setEvent_user(timeLineModelEntity.getEvent_user());
        if (StringUtils.isNotBlank(timeLineModelEntity.getEvent_action()))
            timeLineModel.setEvent_action(timeLineModelEntity.getEvent_action());
        if (StringUtils.isNotBlank(timeLineModelEntity.getEvent_content()))
            timeLineModel.setEvent_content(timeLineModelEntity.getEvent_content());
        if (StringUtils.isNotBlank(timeLineModelEntity.getEvent_custom_var()))
            timeLineModel.setEvent_custom_var(timeLineModelEntity.getEvent_custom_var());
        if (StringUtils.isNotBlank(timeLineModelEntity.getUuid()))
            timeLineModel.setUuid(timeLineModelEntity.getUuid());
        if (timeLineModelEntity.getCreate_userid() != null && timeLineModelEntity.getCreate_userid() != 0)
            timeLineModel.setCreate_userid(timeLineModelEntity.getCreate_userid());
        if (timeLineModelEntity.getCreate_time() != null)
            timeLineModel.setCreate_time(timeLineModelEntity.getCreate_time());
        if (timeLineModelEntity.getUpdate_userid() != null && timeLineModelEntity.getUpdate_userid() != 0)
            timeLineModel.setUpdate_userid(timeLineModelEntity.getUpdate_userid());
        if (timeLineModelEntity.getUpdate_time() != null)
            timeLineModel.setUpdate_time( timeLineModelEntity.getUpdate_time());
        if (timeLineModelEntity.getStatus() != 0)
            timeLineModel.setStatus(timeLineModelEntity.getStatus());
        return timeLineModel;
    }
}
