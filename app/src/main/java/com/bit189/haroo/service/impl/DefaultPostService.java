package com.bit189.haroo.service.impl;

import org.springframework.stereotype.Service;
import com.bit189.haroo.dao.PostDao;
import com.bit189.haroo.domain.AttachedFile;
import com.bit189.haroo.domain.Post;
import com.bit189.haroo.service.PostService;

@Service
public class DefaultPostService implements PostService{

  PostDao postDao;


  public DefaultPostService(PostDao postDao) {
    this.postDao = postDao;
  }


  @Override
  public int add(Post post) throws Exception {
    return postDao.insert(post);
  }

  @Override
  public int delete(int feedNo) throws Exception {
    return postDao.delete(feedNo);
  }


  @Override
  public int addFile(AttachedFile file) throws Exception {
    return postDao.insertFile(file);
  }





}
