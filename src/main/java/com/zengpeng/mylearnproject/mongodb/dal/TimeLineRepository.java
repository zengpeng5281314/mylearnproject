package com.zengpeng.mylearnproject.mongodb.dal;

import com.zengpeng.mylearnproject.mongodb.model.TimeLineModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeLineRepository extends MongoRepository<TimeLineModel, String> {

}
