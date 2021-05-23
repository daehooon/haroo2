package com.bit189.haroo.dao;

import java.util.List;
import com.bit189.haroo.domain.Question;

public interface ServiceQuestionDao {
  int insert(Question question) throws Exception;

  List<Question> findAll(String keyword) throws Exception;

  List<Question> findByMember(int mno) throws Exception;

  Question findByNo(int no) throws Exception;

  int update(Question Question) throws Exception;

  int delete(int no) throws Exception;

  List<Question> findByKeyword(String keyword) throws Exception;
}
