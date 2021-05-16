package com.zengpeng.mylearnproject.kafka.consumer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zengpeng.mylearnproject.mongodb.dal.TimeLineRepository;
import com.zengpeng.mylearnproject.mongodb.model.TimeLineModel;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class ConsumerMongoDBTimeLine {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerMongoDBTimeLine.class);

    @Autowired
    private TimeLineRepository timeLineRepository;

//    @KafkaListener(topics = "${spring.kafka.template.mongo_db_timeline}")
    public boolean saveTimeLine(ConsumerRecord<String, String> record, Acknowledgment ack) {
        logger.info("listen saveTimeLine start:");
        JSONObject message = JSONObject.parseObject(record.value());
        try {
            String table = message.getString("table");
            if (StringUtils.isNotBlank(table) && table.equals("crm_event_action_tmp")) {
                String type = message.getString("type");
                JSONArray data = message.getJSONArray("data");
                if (type.equals("INSERT") || type.equals("UPDATE")) {
                    //新增数据或修改数据
                    for (int i = 0; i < data.size(); i++) {
                        TimeLineModel timeLineModel = JSONObject.parseObject(data.getJSONObject(i).toString(), TimeLineModel.class);
                        TimeLineModel timeLineModelOld = timeLineRepository.getTestModelByIdIs(timeLineModel.getId());
                        if (timeLineModelOld != null) {
                            //修改
                            timeLineModelOld = timeLineModelOld.updateTimeLineModel(timeLineModel);
                            timeLineRepository.save(timeLineModelOld);
                        } else {
                            //新增
                            timeLineRepository.save(timeLineModel);
                        }
                    }
                } else if (type.equals("DELETE")) {
                    //删除数据
                    for (int i = 0; i < data.size(); i++) {
                        TimeLineModel timeLineModel = JSONObject.parseObject(data.getJSONObject(i).toString(), TimeLineModel.class);
                        TimeLineModel timeLineModelOld = timeLineRepository.getTestModelByIdIs(timeLineModel.getId());
                        timeLineRepository.delete(timeLineModelOld);
                    }
                }
                //提交offset
                ack.acknowledge();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(message.toJSONString());
            logger.error(e.getMessage());
            return false;
        }
    }

}
