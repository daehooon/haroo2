package com.bit189.haroo.service.impl;

import com.bit189.haroo.dao.LikeDao;
import com.bit189.haroo.service.LikeService;

public class DefaultLikeService implements LikeService{

  LikeDao likeDao;

  public DefaultLikeService(LikeDao likeDao) {
    this.likeDao = likeDao;
  }

  @Override
  public int get(int no) throws Exception {
    return Integer.parseInt(likeDao.likeCount(no));
  }


}
