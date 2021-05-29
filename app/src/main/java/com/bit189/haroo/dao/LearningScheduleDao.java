package com.bit189.haroo.dao;

import java.util.List;
import java.util.Map;
import com.bit189.haroo.domain.LearningSchedule;

public interface LearningScheduleDao {

  int insert(Map<String,Object> params) throws Exception;

  List<LearningSchedule> findAll() throws Exception;

  List<LearningSchedule> findByKeywords(Map<String,Object> params) throws Exception;

  int update(Map<String,Object> params) throws Exception;
}