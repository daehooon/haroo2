package com.bit189.haroo.dao;

import java.util.List;
import java.util.Map;
import com.bit189.haroo.domain.Tutor;

public interface TutorDao {
  int insert(Tutor tutor) throws Exception;

  List<Tutor> findAll() throws Exception;

  Tutor findByNo(int no) throws Exception;

  Tutor findByEmailPassword(Map<String,Object> params) throws Exception;

  int update(Tutor tutor) throws Exception;

  int delete(int no) throws Exception;

  Tutor findByName(String name) throws Exception;

  Tutor findFollowingByNo(int memberNo) throws Exception;
}
