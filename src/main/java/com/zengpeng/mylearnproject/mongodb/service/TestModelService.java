package com.zengpeng.mylearnproject.mongodb.service;


import com.zengpeng.mylearnproject.entity.TimeLineModelEntity;
import com.zengpeng.mylearnproject.mongodb.model.TestModel;
import com.zengpeng.mylearnproject.mongodb.model.TimeLineModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TestModelService {

    TestModel findOneByIDSB(int id);

    TestModel mongoTemplateById(int id);

    List<TestModel> getTestModelByName(String name);

    Page<TestModel> getTestModelByName2(String name);

    TimeLineModel conversionTimeLineModel(TimeLineModelEntity timeLineModelEntity);
}
