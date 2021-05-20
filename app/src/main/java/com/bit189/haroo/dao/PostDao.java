package com.bit189.haroo.dao;

import com.bit189.haroo.domain.AttachedFile;
import com.bit189.haroo.domain.Post;

public interface PostDao {
  int insert(Post post) throws Exception;

  int insertFile(AttachedFile file) throws Exception;
}