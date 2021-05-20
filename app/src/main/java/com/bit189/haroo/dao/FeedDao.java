package com.bit189.haroo.dao;

import java.util.List;
import java.util.Map;
import com.bit189.haroo.domain.Feed;

public interface FeedDao {
  int insert(Map<String,Object> param) throws Exception;

  List<Feed> findAll() throws Exception;

  Feed findByNo(int no) throws Exception;

  String likeCount(int feedNo) throws Exception;
}