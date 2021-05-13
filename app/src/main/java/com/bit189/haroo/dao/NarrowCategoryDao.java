package com.bit189.haroo.dao;

import java.util.List;
import com.bit189.haroo.domain.NarrowCategory;

public interface NarrowCategoryDao {
  int insert(int no) throws Exception;

  List<NarrowCategory> findAll() throws Exception;

  NarrowCategory findByNo(int no) throws Exception;

  NarrowCategory findByname(String name) throws Exception;

  int update(int no) throws Exception;

  int delete(int no) throws Exception;
}
