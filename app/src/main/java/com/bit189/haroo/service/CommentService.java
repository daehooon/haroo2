package com.bit189.haroo.service;

import java.util.List;
import com.bit189.haroo.domain.Comment;

public interface CommentService {
  int add(Comment comment) throws Exception;

  List<Comment> list(int feedNo) throws Exception;

  Comment get(int commentNo) throws Exception;

  int update(Comment comment) throws Exception;

  int delete(int commentNo) throws Exception;

  int getLike(int commentNo, int memberNo) throws Exception;

  int deleteLike(int commentNo, int memberNo) throws Exception;

  int addLike(int commentNo, int memberNo) throws Exception;

}
