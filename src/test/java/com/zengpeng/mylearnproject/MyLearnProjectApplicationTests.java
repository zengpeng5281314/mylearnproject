package com.zengpeng.mylearnproject;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zengpeng.mylearnproject.dao.TimeLineEntityRepository;
import com.zengpeng.mylearnproject.entity.TimeLineModelEntity;
import com.zengpeng.mylearnproject.mongodb.dal.TestDTORepository;
import com.zengpeng.mylearnproject.mongodb.dal.TimeLineRepository;
import com.zengpeng.mylearnproject.mongodb.model.TestModel;
import com.zengpeng.mylearnproject.mongodb.model.TimeLineModel;
import com.zengpeng.mylearnproject.mongodb.service.TestModelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MyLearnProjectApplicationTests {

    @Autowired
    private TestModelService testModelService;
    @Autowired
    private TestDTORepository testDTORepository;
    @Autowired
    private TimeLineRepository timeLineRepository;
    @Autowired
    private TimeLineEntityRepository timeLineEntityRepository;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Test
    void contextLoads() {

//        System.out.println("11111111111  start:"+sdf.format(new Date()));
//        for (int i = 0; i < 10; i++) {
//            ccccc(i);
//        }

        System.out.println("11111111111  end:"+sdf.format(new Date()));

        TestModel testModel = testModelService.findOneByIDSB(4);
        System.out.println("--------" + JSONObject.toJSONString(testModel));

        List<TestModel> testModel2 = testDTORepository.getTestModelByName("您好");
        System.out.println("--------" + JSONObject.toJSONString(testModel2.get(0)));
        List<TestModel> testModel1 = testModelService.getTestModelByName("四");
        System.out.println("--------" + JSONArray.toJSONString(testModel1));
//        TestModel testModel23= testDTORepository.getTestModelSEFS(4);
//        System.out.println("--------" + JSONObject.toJSONString(testModel23));

        Page<TestModel> page = testModelService.getTestModelByName2("四");
        if(!page.isEmpty()){
           List<TestModel> list2 = page.getContent();
            System.out.println("--------size:" +page.getSize()+"  getTotalElements:"+page.getTotalElements()+"   "+ JSONArray.toJSONString(list2));
        }
    }

    private void ccccc(int i) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(i, 10000, sort);
        Page<TimeLineModelEntity> page = timeLineEntityRepository.findAll(pageable);
        if (!page.isEmpty()) {
            List<TimeLineModelEntity> list = page.getContent();
            List<TimeLineModel> list2 = new ArrayList<>();
            list.stream().forEach(timeLineModelEntity -> {
                TimeLineModel timeLineModelOld = timeLineRepository.getTestModelByIdIs(timeLineModelEntity.getId());
               TimeLineModel timeLineModel = testModelService.conversionTimeLineModel(timeLineModelEntity);
                if (timeLineModelOld != null) {
                    //修改
                   timeLineModelOld = timeLineModelOld.updateTimeLineModel(timeLineModel);
                    list2.add(timeLineModelOld);
//                    timeLineRepository.save(timeLineModelOld);
                  } else {
                    list2.add(timeLineModel);
                    //新增
//                    timeLineRepository.save(timeLineModel);
                 }


            });
            timeLineRepository.saveAll(list2);
        }
    }

}
