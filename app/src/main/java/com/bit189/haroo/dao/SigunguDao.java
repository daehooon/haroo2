package com.bit189.haroo.dao;

import java.util.List;
import com.bit189.haroo.domain.Sigungu;

public interface SigunguDao {
  int insert(int no) throws Exception;

  List<Sigungu> findAll() throws Exception;

  Sigungu findByNo(int no) throws Exception;

  Sigungu findByname(String name) throws Exception;

  int update(int no) throws Exception;

  int delete(int no) throws Exception;
}
