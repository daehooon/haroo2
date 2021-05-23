package com.bit189.haroo.dao;

import java.util.List;
import com.bit189.haroo.domain.NarrowCategory;

public interface NarrowCategoryDao {

  List<NarrowCategory> findAll() throws Exception;
}