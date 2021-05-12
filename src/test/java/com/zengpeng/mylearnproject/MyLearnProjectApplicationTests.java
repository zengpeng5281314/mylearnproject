package com.zengpeng.mylearnproject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zengpeng.mylearnproject.mongodb.dal.TestDTORepository;
import com.zengpeng.mylearnproject.mongodb.model.TestModel;
import com.zengpeng.mylearnproject.mongodb.service.TestModelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyLearnProjectApplicationTests {

    @Autowired
    private TestModelService testModelService;
    @Autowired
    private TestDTORepository testDTORepository;

    @Test
    void contextLoads() {
        TestModel testModel = testModelService.findOneByIDSB(4);
        System.out.println("--------" + JSONObject.toJSONString(testModel));
//        TestModel testModel2= testDTORepository.getTestModelSEFS(4);
//        System.out.println("--------" + JSONObject.toJSONString(testModel2));

    }

}
