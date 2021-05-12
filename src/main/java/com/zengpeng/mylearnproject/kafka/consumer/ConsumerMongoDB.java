package com.zengpeng.mylearnproject.kafka.consumer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zengpeng.mylearnproject.kafka.consumer.dto.TestDTO;
import com.zengpeng.mylearnproject.mongodb.dal.TestDTORepository;
import com.zengpeng.mylearnproject.mongodb.model.TestModel;
import com.zengpeng.mylearnproject.mongodb.service.TestModelService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class ConsumerMongoDB {

    private static Logger logger = LoggerFactory.getLogger(ConsumerMongoDB.class);

    @Autowired
    private TestDTORepository testDTORepository;

    @Autowired
    private TestModelService testModelService;

    @KafkaListener(topics = "${spring.kafka.template.mongo_db_test}")
    public boolean mongo_db_test(ConsumerRecord<String, String> record , Acknowledgment ack) throws Exception {
        logger.info("listen mongo_db_test start:");

        JSONObject message = JSONObject.parseObject(record.value());
        try {
            String type = message.getString("type");
            JSONArray data = message.getJSONArray("data");
            if(type.equals("INSERT") || type.equals("UPDATE")){
                for (int i = 0; i < data.size(); i++) {

                    TestModel testModel = JSONObject.parseObject(data.getJSONObject(i).toString(), TestModel.class);
//                    TestModel testModelNew =  testModelService.findOneByID(testModel.getId());
//                            testDTORepository.findOneByID(testModel.getId());
                    TestModel testModelNew = testDTORepository.getTestModelByIdIs(testModel.getId());
                    System.out.println(type + " JSONObject.toJSONString(TestDTO1) = " + JSONObject.toJSONString(testModel));
                    if(testModelNew != null){
                        //修改数据
                        testModelNew.setCreateTime(testModel.getCreateTime());
                        testModelNew.setName(testModel.getName());
                        testModelNew.setSex(testModel.getSex());
                        testDTORepository.save(testModelNew);
                    }else {
                        //新增数据
                        testDTORepository.insert(testModel);
                    }
                }
            }else if(type.equals("DELETE")){
                //删除数据
                for (int i = 0; i < data.size(); i++) {
                    TestDTO TestDTO1 = JSONObject.parseObject(data.getJSONObject(i).toString(),TestDTO.class);
                    System.out.println("DELETE JSONObject.toJSONString(TestDTO1) = " + JSONObject.toJSONString(TestDTO1));
                    TestModel testModel = JSONObject.parseObject(data.getJSONObject(i).toString(), TestModel.class);
//                    TestModel testModelNew =  testModelService.findOneByID(testModel.getId());
                    TestModel testModelNew = testDTORepository.getTestModelByIdIs(testModel.getId());

                    testDTORepository.delete(testModelNew);
                }
            }else{

            }

            //提交offset
//            ack.acknowledge();
            return true;
        } catch (Exception e) {
            logger.info(message.toJSONString());
            logger.error(e.getMessage());
            return  false;
        }
    }


}
