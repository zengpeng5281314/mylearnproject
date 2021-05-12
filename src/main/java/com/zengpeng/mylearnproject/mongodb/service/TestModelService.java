package com.zengpeng.mylearnproject.mongodb.service;


import com.zengpeng.mylearnproject.mongodb.model.TestModel;

public interface TestModelService {

    public TestModel findOneByIDSB(int id);

    public TestModel getTestModelByNameSE(String name);
}
