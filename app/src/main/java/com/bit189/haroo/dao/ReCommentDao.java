package com.bit189.haroo.dao;

import java.util.List;
import com.bit189.haroo.domain.ReComment;
 
public interface ReCommentDao {
  int insert(ReComment reComment) throws Exception;

  List<ReComment> findByReComments(int commentNo) throws Exception;

  ReComment findByReComment(int reCommentNo) throws Exception;

  int delete(int reCommentNo) throws Exception;
}
