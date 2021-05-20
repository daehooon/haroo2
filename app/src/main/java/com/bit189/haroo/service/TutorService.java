package com.bit189.haroo.service;

import java.util.List;
import com.bit189.haroo.domain.Tutor;

public interface TutorService {

  int add(Tutor tutor) throws Exception;

  List<Tutor> list(String keyword) throws Exception;

  Tutor get(int no) throws Exception;

  int update(Tutor Tutor) throws Exception;

  int delete(int no) throws Exception;

  Tutor Search(String name) throws Exception;

  Tutor Search(int memberNo) throws Exception;
}
