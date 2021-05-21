package com.zengpeng.mylearnproject.mongodb.service;


import com.zengpeng.mylearnproject.entity.TimeLineModelEntity;
import com.zengpeng.mylearnproject.mongodb.model.TestModel;
import com.zengpeng.mylearnproject.mongodb.model.TimeLineModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TestModelService {

    public TestModel findOneByIDSB(int id);

    public List<TestModel> getTestModelByName(String name);

    public Page<TestModel> getTestModelByName2(String name);

    public TimeLineModel conversionTimeLineModel(TimeLineModelEntity timeLineModelEntity);
}
