package com.bit189.haroo.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import com.bit189.haroo.dao.ReCommentDao;
import com.bit189.haroo.domain.ReComment;
import com.bit189.haroo.service.ReCommentService;

@Service
public class DefaultReCommentService implements ReCommentService{

  ReCommentDao reCommentDao;

  public DefaultReCommentService(ReCommentDao reCommentDao) {
    this.reCommentDao = reCommentDao;
  }

  @Override
  public int add(ReComment reComment) throws Exception {
    return reCommentDao.insert(reComment);
  }

  @Override
  public List<ReComment> list(int commentNo) throws Exception {
    return reCommentDao.findByReComments(commentNo);
  }

  @Override
  public ReComment get(int reCommentNo) throws Exception {
    return reCommentDao.findByReComment(reCommentNo);
  }

  @Override
  public int delete(int reCommentNo) throws Exception {
    return reCommentDao.delete(reCommentNo);
  }

  @Override
  public int update(ReComment reComment) throws Exception {
    return reCommentDao.update(reComment);
  }

  @Override
  public int getLike(int reCommentNo, int memberNo) throws Exception {
    HashMap<String, Object> params = new HashMap<>();
    params.put("reCommentNo", reCommentNo);
    params.put("memberNo", memberNo);

    return Integer.parseInt(reCommentDao.findLike(params));
  }

  @Override
  public int deleteLike(int reCommentNo, int memberNo) throws Exception {
    HashMap<String, Object> params = new HashMap<>();
    params.put("reCommentNo", reCommentNo);
    params.put("memberNo", memberNo);

    return reCommentDao.deketeLike(params);
  }

  @Override
  public int addLike(int reCommentNo, int memberNo) throws Exception {
    HashMap<String, Object> params = new HashMap<>();
    params.put("reCommentNo", reCommentNo);
    params.put("memberNo", memberNo);

    return reCommentDao.addLike(params);
  }


}
