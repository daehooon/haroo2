package com.bit189.haroo.dao;

import java.util.List;
import com.bit189.haroo.domain.BroadCategory;

public interface BroadCategoryDao {

  List<BroadCategory> findAll() throws Exception;
}