package com.zengpeng.mylearnproject.mongodb.serviceimpl;

import com.zengpeng.mylearnproject.mongodb.dal.TestDTORepository;
import com.zengpeng.mylearnproject.mongodb.model.TestModel;
import com.zengpeng.mylearnproject.mongodb.service.TestModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestModelServiceImpl implements TestModelService {

    @Autowired
    private TestDTORepository testDTORepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public TestModel findOneByIDSB(int id) {
//        Query query=new Query(Criteria.where("id").is(id));
//        return mongoTemplate.findOne(query,TestModel.class);



        TestModel testModel = new TestModel();
        testModel.setId(id);
        //此处是根据指定条件精确查询
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreNullValues().withIgnorePaths("intRefNo").withIgnorePaths("intRefType")
                .withMatcher("id", ExampleMatcher.GenericPropertyMatchers.contains())
            .withIgnorePaths("sex");
        Example<TestModel> example = Example.of(testModel,matcher);

        Optional<TestModel> optional = testDTORepository.findOne(example);
        if(optional.isPresent())
            return optional.get();
//
//        List<TestModel> list = testDTORepository.findAll(example);
//        if(list!=null&&list.size()>0)
//            return list.get(0);
        return null;
    }

    @Override
    public TestModel getTestModelByNameSE(String name) {



        TestModel testModel = new TestModel();
        testModel.setName(name);
        //此处是根据指定条件精确查询
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<TestModel> example = Example.of(testModel,matcher);

//        Optional<TestModel> optional = testDTORepository.findOne(example);
//        if(optional.isPresent())
//            return optional.get();

        List<TestModel> list = testDTORepository.findAll(example);
        if(list!=null&&list.size()>0)
            return list.get(0);
        return null;
    }
}
