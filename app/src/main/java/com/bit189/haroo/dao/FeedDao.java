package com.bit189.haroo.dao;

import java.util.List;
import com.bit189.haroo.domain.Feed;

public interface FeedDao {
  List<Feed> findAll() throws Exception;

  Feed findByNo(int no) throws Exception;
}
