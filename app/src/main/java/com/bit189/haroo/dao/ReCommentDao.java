package com.bit189.haroo.dao;

import java.util.List;
import java.util.Map;
import com.bit189.haroo.domain.ReComment;

public interface ReCommentDao {
  int insert(ReComment reComment) throws Exception;

  List<ReComment> findByReComments(int commentNo) throws Exception;

  ReComment findByReComment(int reCommentNo) throws Exception;

  int update(ReComment reComment) throws Exception;

  int delete(int reCommentNo) throws Exception;

  String findLike(Map<String, Object> params) throws Exception;

  int deketeLike(Map<String, Object> params) throws Exception;

  int addLike(Map<String, Object> params) throws Exception;
}
