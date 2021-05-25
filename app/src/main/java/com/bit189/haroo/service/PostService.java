package com.bit189.haroo.service;

import com.bit189.haroo.domain.AttachedFile;
import com.bit189.haroo.domain.Post;

public interface PostService {
  int add(Post post) throws Exception;

  int delete(int feedNo) throws Exception;

  int addFile(AttachedFile file) throws Exception;
}
