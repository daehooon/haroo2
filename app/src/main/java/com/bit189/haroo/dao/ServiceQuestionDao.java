package com.bit189.haroo.dao;

import java.util.List;
import java.util.Map;
import com.bit189.haroo.domain.Question;

public interface ServiceQuestionDao {
  int insert(Map<String,Object> param) throws Exception;

  List<Question> findAll() throws Exception;

  List<Question> findByMember(int mno) throws Exception;

  Question findByNo(int no) throws Exception;

  int update(Question question) throws Exception;

  int delete(int no) throws Exception;

  List<Question> findByKeyword(String keyword) throws Exception;

  int replyAdd(Map<String,Object> param) throws Exception;
}
