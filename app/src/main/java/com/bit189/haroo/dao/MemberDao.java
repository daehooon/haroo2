package com.bit189.haroo.dao;

import java.util.List;
import java.util.Map;
import com.bit189.haroo.domain.Member;

public interface MemberDao {
  int insert(Member member) throws Exception;

  List<Member> findByKeyword(String keyword) throws Exception;

  Member findByNo(int no) throws Exception;

  Member findByEmailPassword(Map<String,Object> params) throws Exception;

  int update(Member member) throws Exception;

  int delete(int no) throws Exception;

  Member findByName(String name) throws Exception;

  List<Member> findFollowerByNo(int tutorNo) throws Exception;
}