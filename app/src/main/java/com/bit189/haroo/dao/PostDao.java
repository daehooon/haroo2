package com.bit189.haroo.dao;

import com.bit189.haroo.domain.AttachedFile;
import com.bit189.haroo.domain.Post;

public interface PostDao {
  int insert(Post post) throws Exception;

  int delete(int feedNo) throws Exception;

  int update(Post post) throws Exception;

  int updateViewCount(int no) throws Exception;

  int insertFile(AttachedFile file) throws Exception;

  int deleteFile(int feedNo) throws Exception;
}