package com.bit189.haroo.dao;

import java.sql.Date;
import java.util.List;
import com.bit189.haroo.domain.LearningSchedule;

public interface LearningScheduleDao {

  int insert(LearningSchedule learningSchedule) throws Exception;

  List<LearningSchedule> findAll() throws Exception;

  LearningSchedule findByNo(int no) throws Exception;

  LearningSchedule findByDate(Date date) throws Exception;

  int update(int no) throws Exception;

  int delete(int no) throws Exception;
}
