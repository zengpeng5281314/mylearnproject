package com.zengpeng.mylearnproject.mongodb.controller;

import com.zengpeng.mylearnproject.mongodb.dal.TimeLineRepository;
import com.zengpeng.mylearnproject.mongodb.model.TimeLineModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timeline")
public class TimeLineController {

    @Autowired
    private TimeLineRepository timeLineRepository;

    @GetMapping("")
    public List<TimeLineModel> getAllTimeLineModels() {
        List<TimeLineModel> list = timeLineRepository.findAll();
        return list;
    }

    @GetMapping("/{id}")
    public TimeLineModel getTimeLineModelById(@PathVariable String id) {
        return timeLineRepository.findById(id).orElse(new TimeLineModel());
    }

    @PostMapping("/add")
    public TimeLineModel addNewTimeLineModel(@RequestBody TimeLineModel timeLineModel) {
        return timeLineRepository.save(timeLineModel);
    }

    @DeleteMapping("/{_id}")
    public String delete(@PathVariable String _id) {
        TimeLineModel timeLineModel = new TimeLineModel();
        timeLineModel.set_id(_id);
        timeLineRepository.deleteById(_id);
        return "deleted: " + _id;
    }

    @PostMapping("/update")
    public TimeLineModel update(@RequestBody TimeLineModel timeLineModel) {
        return timeLineRepository.save(timeLineModel);
    }
}
