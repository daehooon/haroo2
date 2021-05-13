package com.bit189.haroo.dao;

import java.util.List;
import com.bit189.haroo.domain.Comment;
import com.bit189.haroo.domain.Member;

public interface CommentDao {
  int insert(Comment comment) throws Exception;

  List<Comment> findAll() throws Exception;

  List<Comment> findByfeedNo(int feedNo) throws Exception;

  Comment findByNo(int no) throws Exception;

  Comment findBywriter(Member writer) throws Exception;

  int update(int no) throws Exception;

  int delete(int no) throws Exception;
}
