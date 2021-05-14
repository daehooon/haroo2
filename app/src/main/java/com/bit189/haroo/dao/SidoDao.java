package com.bit189.haroo.dao;

import java.util.List;
import com.bit189.haroo.domain.Sido;

public interface SidoDao {

  int insert(Sido sido) throws Exception;

  List<Sido> findAll() throws Exception;

  Sido findByNo(int no) throws Exception;

  Sido findByname(String name) throws Exception;

  int update(int no) throws Exception;

  int delete(int no) throws Exception;
}
