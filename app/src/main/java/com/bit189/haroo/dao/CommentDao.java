package com.bit189.haroo.dao;

import java.util.List;
import com.bit189.haroo.domain.Comment;

public interface CommentDao {
  int insert(Comment comment) throws Exception;
 
  //  List<Comment> findAll() throws Exception;

  List<Comment> findByComments(int feedNo) throws Exception;

  Comment findByComment(int commentNo) throws Exception;

  //  Comment findBywriter(Member writer) throws Exception;

  //  int update(int no) throws Exception;

  int delete(int commentNo) throws Exception;

  String commentCount(int feedNo) throws Exception;
}
