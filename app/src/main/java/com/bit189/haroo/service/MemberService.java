package com.bit189.haroo.service;

import java.util.List;
import com.bit189.haroo.domain.Member;

public interface MemberService {

  int add(Member member) throws Exception;

  List<Member> list(String keyword) throws Exception;

  Member get(int no) throws Exception;

  Member get(String email, String password) throws Exception;

  Member get(String password) throws Exception; //회원 정보 수정시 비번 입력

  int update(Member member) throws Exception;

  int delete(int no) throws Exception;

  Member Search(String name) throws Exception;

  List<Member> Search(int tutorNo) throws Exception;
}
