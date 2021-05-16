package com.zengpeng.mylearnproject.dao;

import com.zengpeng.mylearnproject.entity.TimeLineModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeLineEntityRepository extends JpaRepository<TimeLineModelEntity, Long> {
}
