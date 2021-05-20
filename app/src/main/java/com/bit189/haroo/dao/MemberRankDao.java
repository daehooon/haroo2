package com.bit189.haroo.dao;

import java.util.List;
import com.bit189.haroo.domain.Member;

public interface MemberRankDao {
  int insert(String rank) throws Exception;

  List<Member> findAll() throws Exception;

  Member findByNo(int no) throws Exception;

  int update(Member member) throws Exception;

  int delete(int no) throws Exception;

}