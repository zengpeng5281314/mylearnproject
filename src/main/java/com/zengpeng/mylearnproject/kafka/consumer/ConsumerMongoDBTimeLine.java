package com.zengpeng.mylearnproject.kafka.consumer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zengpeng.mylearnproject.kafka.consumer.dto.TestDTO;
import com.zengpeng.mylearnproject.mongodb.dal.TimeLineRepository;
import com.zengpeng.mylearnproject.mongodb.model.TimeLineModel;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class ConsumerMongoDBTimeLine {

    private static Logger logger = LoggerFactory.getLogger(ConsumerMongoDBTimeLine.class);

    @Autowired
    private TimeLineRepository timeLineRepository;

    @KafkaListener(topics = "${spring.kafka.template.mongo_db_timeline}")
    public boolean saveTimeLine(ConsumerRecord<String, String> record , Acknowledgment ack) throws Exception {
        logger.info("listen saveTimeLine start:");
        JSONObject message = JSONObject.parseObject(record.value());
        try {
            String type = message.getString("type");
            JSONArray data = message.getJSONArray("data");
            if(type.equals("INSERT")){
                //新增数据
                for (int i = 0; i < data.size(); i++) {
                    TimeLineModel timeLineModel = JSONObject.parseObject(data.toString(),TimeLineModel.class);
                }
            }else if(type.equals("UPDATE")){
                //修改数据
                for (int i = 0; i < data.size(); i++) {
                    TimeLineModel timeLineModel = JSONObject.parseObject(data.toString(),TimeLineModel.class);

                }
            }else if(type.equals("DELETE")){
                //删除数据
                for (int i = 0; i < data.size(); i++) {
                    TimeLineModel timeLineModel = JSONObject.parseObject(data.toString(),TimeLineModel.class);
                }
            }else{

            }

            //提交offset
            ack.acknowledge();
            return true;
        } catch (Exception e) {
            logger.info(message.toJSONString());
            logger.error(e.getMessage());
            return  false;
        }
    }

}
