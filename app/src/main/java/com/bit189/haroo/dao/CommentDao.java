package com.bit189.haroo.dao;

import java.util.List;
import java.util.Map;
import com.bit189.haroo.domain.Comment;

public interface CommentDao {
  int insert(Comment comment) throws Exception;

  //  List<Comment> findAll() throws Exception;

  List<Comment> findByComments(int feedNo) throws Exception;

  Comment findByComment(int commentNo) throws Exception;

  //  Comment findBywriter(Member writer) throws Exception;

  int update(Comment comment) throws Exception;

  int delete(int commentNo) throws Exception;

  String commentCount(int feedNo) throws Exception;

  String findLike(Map<String, Object> params) throws Exception;

  int deleteLike(Map<String, Object> params) throws Exception;

  int addLike(Map<String, Object> params) throws Exception;
}
