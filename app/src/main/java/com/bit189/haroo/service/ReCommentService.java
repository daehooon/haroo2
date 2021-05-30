package com.bit189.haroo.service;

import java.util.List;
import com.bit189.haroo.domain.ReComment;

public interface ReCommentService {
  int add(ReComment reComment) throws Exception;

  List<ReComment> list(int commentNo) throws Exception;

  ReComment get(int reCommentNo) throws Exception;

  int update(ReComment reComment) throws Exception;

  int delete(int reCommentNo) throws Exception;

  int getLike(int reCommentNo, int memberNo) throws Exception;

  int deleteLike(int reCommentNo, int memberNo) throws Exception;

  int addLike(int reCommentNo, int memberNo) throws Exception;
}
