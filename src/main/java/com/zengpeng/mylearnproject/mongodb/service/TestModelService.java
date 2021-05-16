package com.zengpeng.mylearnproject.mongodb.service;


import com.zengpeng.mylearnproject.entity.TimeLineModelEntity;
import com.zengpeng.mylearnproject.mongodb.model.TestModel;
import com.zengpeng.mylearnproject.mongodb.model.TimeLineModel;

public interface TestModelService {

    public TestModel findOneByIDSB(int id);

    public TestModel getTestModelByNameSE(String name);

    public TimeLineModel conversionTimeLineModel(TimeLineModelEntity timeLineModelEntity);
}
