package com.bit189.haroo.service;

import java.util.List;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.Tutor;
import com.bit189.haroo.domain.TutorCategory;
import com.bit189.haroo.domain.TutorDistrict;

public interface TutorService {

  int add(Tutor tutor , Member member , TutorDistrict tutorDistrict, TutorCategory tutorCategory) throws Exception;

  List<Tutor> list(String keyword) throws Exception;

  Tutor get(int no) throws Exception;

  int update(Tutor Tutor , Member member, TutorDistrict tutorDistrict, TutorCategory tutorCategory) throws Exception;

  int delete(int no) throws Exception;

  Tutor Search(String name) throws Exception;

  Tutor Search(int memberNo) throws Exception;
}
