package com.bit189.haroo.dao;

import java.util.Map;

public interface LikeDao {
  int insert(Map<String,Object> parmas) throws Exception;

  int delete(Map<String,Object> parms) throws Exception;
 
  String likeCount(int feedNo) throws Exception;
}
