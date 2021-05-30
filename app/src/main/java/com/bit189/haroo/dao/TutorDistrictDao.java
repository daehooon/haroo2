package com.bit189.haroo.dao;

import java.util.Map;
import com.bit189.haroo.domain.TutorDistrict;

public interface TutorDistrictDao {

  //  int insert(Map<String,Object> params) throws Exception;

  int insert(TutorDistrict tutorDistrict) throws Exception;

  int update(TutorDistrict tutorDistrict) throws Exception;

  int delete(Map<String,Object> params) throws Exception;
}
