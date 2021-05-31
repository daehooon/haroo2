package com.bit189.haroo.dao;

import java.util.List;
import java.util.Map;
import com.bit189.haroo.domain.TutorQuestion;

public interface TutorQuestionDao {
  int insert(Map<String,Object> param) throws Exception;

  List<TutorQuestion> findAll() throws Exception;

  TutorQuestion findByNo(int no) throws Exception;

  int update(TutorQuestion tutorQuestion) throws Exception;

  int delete(int no) throws Exception;

  int replyUpdate(TutorQuestion tutorQuestion) throws Exception;
}
