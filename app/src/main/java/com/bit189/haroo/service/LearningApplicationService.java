package com.bit189.haroo.service;

import java.util.List;
import com.bit189.haroo.domain.LearningApplication;

public interface LearningApplicationService {

  int add(LearningApplication learningApplication) throws Exception;

  List<LearningApplication> list() throws Exception;

  int update(LearningApplication learningApplication) throws Exception;

  LearningApplication get(int no) throws Exception;

  int delete(int no) throws Exception;

}
