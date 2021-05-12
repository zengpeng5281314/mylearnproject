package com.zengpeng.mylearnproject.mongodb.serviceimpl;

import com.zengpeng.mylearnproject.mongodb.dal.TestDTORepository;
import com.zengpeng.mylearnproject.mongodb.model.TestModel;
import com.zengpeng.mylearnproject.mongodb.service.TestModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestModelServiceImpl implements TestModelService {

    @Autowired
    private TestDTORepository testDTORepository;

    @Override
    public TestModel findOneByIDSB(int id) {
//        Query query =new Query();
        //字段相等查询
//        query.addCriteria(Criteria.where("id").is(id));
//        query.addCriteria(Criteria.where("name").is("我擦111"));
        TestModel testModel = new TestModel();
        testModel.setId(id);
        //此处是根据指定条件精确查询
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withMatcher("id", ExampleMatcher.GenericPropertyMatchers.contains());


        Example<TestModel> example = Example.of(testModel,matcher);
        Optional<TestModel> optional = testDTORepository.findOne(example);
        if(optional.isPresent())
            return optional.get();

//        List<TestModel> list = testDTORepository.findAll(example);
//        if(list!=null&&list.size()>0)
//            return list.get(0);
        return null;
    }
}
