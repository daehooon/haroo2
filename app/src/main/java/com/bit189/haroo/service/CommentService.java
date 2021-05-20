package com.bit189.haroo.service;

import java.util.List;
import com.bit189.haroo.domain.Comment;

public interface CommentService {
  int add(Comment comment) throws Exception;

  List<Comment> get(int feedNo) throws Exception;
}
