package com.bit189.haroo.service.impl;

import java.util.List;
import com.bit189.haroo.dao.TutorDao;
import com.bit189.haroo.domain.Tutor;
import com.bit189.haroo.service.TutorService;

public class DefaultTutorService implements TutorService {

  TutorDao tutorDao;

  public DefaultTutorService(TutorDao tutorDao) {
    this.tutorDao = tutorDao;
  }

  @Override
  public int add(Tutor tutor) throws Exception {
    return tutorDao.insert(tutor);
  }

  @Override
  public List<Tutor> list(String keyword) throws Exception {
    return tutorDao.findByKeyword(keyword);
  }

  @Override
  public Tutor get(int no) throws Exception {
    return tutorDao.findByNo(no);
  }

  @Override
  public int update(Tutor tutor) throws Exception {
    return tutorDao.update(tutor);
  }

  @Override
  public int delete(int no) throws Exception {
    return tutorDao.delete(no);
  }

  @Override
  public Tutor Search(String name) throws Exception {
    return tutorDao.findByName(name);
  }

  @Override
  public Tutor Search(int memberNo) throws Exception {
    return tutorDao.findFollowingByNo(memberNo);
  }
}