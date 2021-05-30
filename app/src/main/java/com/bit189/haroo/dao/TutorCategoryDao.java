package com.bit189.haroo.dao;

import java.util.Map;
import com.bit189.haroo.domain.TutorCategory;

public interface TutorCategoryDao {

  //  int insert(Map<String,Object> params) throws Exception;

  int insert(TutorCategory tutorCategory) throws Exception;

  int update(TutorCategory tutorCategory) throws Exception;

  int delete(Map<String,Object> params) throws Exception;
}