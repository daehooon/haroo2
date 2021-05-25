package com.bit189.haroo.service;

import java.util.List;
import com.bit189.haroo.domain.ReComment;

public interface ReCommentService {
  int add(ReComment reComment) throws Exception;

  List<ReComment> list(int commentNo) throws Exception;

  ReComment get(int reCommentNo) throws Exception;

  int delete(int reCommentNo) throws Exception;
}
