package com.bit189.haroo.service;

import java.util.List;
import com.bit189.haroo.domain.LearningApplication;
import com.bit189.haroo.domain.LearningSchedule;

public interface LearningApplicationService {

  int add(LearningApplication learningApplication) throws Exception;

  List<LearningApplication> list() throws Exception;

  List<LearningSchedule> listSchedules() throws Exception;

  LearningApplication get(int no) throws Exception;

  int update(LearningApplication learningApplication) throws Exception;

  int delete(int no) throws Exception;

}


