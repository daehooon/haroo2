package com.bit189.haroo.service.impl;

import java.util.List;
import com.bit189.haroo.dao.FeedDao;
import com.bit189.haroo.domain.Feed;
import com.bit189.haroo.service.FeedService;

public class DefaultFeedService implements FeedService{

  FeedDao feedDao;

  public DefaultFeedService(FeedDao feedDao) {
    this.feedDao = feedDao;
  }

  @Override
  public List<Feed> list() throws Exception {
    return feedDao.findAll();
  }

  @Override
  public Feed get(int no) throws Exception {
    return feedDao.findByNo(no);
  }

}
