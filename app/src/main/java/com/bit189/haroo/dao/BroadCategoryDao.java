package com.bit189.haroo.dao;

import java.util.List;
import com.bit189.haroo.domain.BroadCategory;

public interface BroadCategoryDao {

  int insert(BroadCategory broadCategory) throws Exception;

  List<BroadCategory> findAll() throws Exception;

  BroadCategory findByNo(int no) throws Exception;

  BroadCategory findByname(String name) throws Exception;

  int update(int no) throws Exception;

  int delete(int no) throws Exception;
}
