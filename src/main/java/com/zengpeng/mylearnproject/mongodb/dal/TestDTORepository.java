package com.zengpeng.mylearnproject.mongodb.dal;

import com.zengpeng.mylearnproject.mongodb.model.TestModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDTORepository extends MongoRepository<TestModel, String> {

    TestModel getTestModelByIdIs(int id);

    @Query(value="{'id':?0}")
    TestModel getTestModelSEFS(int id);

    @Query(value="{'name':?0}")
    List<TestModel> getTestModelByName(String name);
}
