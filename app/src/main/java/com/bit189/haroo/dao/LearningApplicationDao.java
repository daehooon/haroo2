package com.bit189.haroo.dao;

import java.util.List;
import com.bit189.haroo.domain.LearningApplication;
import com.bit189.haroo.domain.LearningSchedule;

public interface LearningApplicationDao {

  int insert(LearningApplication learningApplication) throws Exception;

  LearningApplication findByNo(int no) throws Exception;

  List<LearningApplication> findAll() throws Exception; 

  List<LearningSchedule> findAllSchedules() throws Exception;

  int update(LearningApplication learningApplication) throws Exception;

  int delete(int no) throws Exception;

}
