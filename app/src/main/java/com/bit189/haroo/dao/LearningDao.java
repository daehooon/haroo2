package com.bit189.haroo.dao;

import java.util.List;
import com.bit189.haroo.domain.Learning;

public interface LearningDao {

  int insert(Learning learning) throws Exception;

  List<Learning> findAll() throws Exception;

  Learning findByNo(int no) throws Exception;

  Learning findByName(String name) throws Exception;

  int update(int no) throws Exception;

  int delete(int no) throws Exception;

  List<Learning> findByTutor(int tutorNo) throws Exception;

  Learning findBySchedule(int scheduleNo) throws Exception;
}
