package com.bit189.haroo.dao;

import java.util.Map;

public interface FollowDao {
  int insert(Map<String,Object> parmas) throws Exception;

  int delete(Map<String,Object> parms) throws Exception;
}
