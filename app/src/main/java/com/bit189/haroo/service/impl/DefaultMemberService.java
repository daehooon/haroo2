package com.bit189.haroo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.bit189.haroo.dao.MemberDao;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.MemberService;

@Service
public class DefaultMemberService implements MemberService {

  MemberDao memberDao;

  public DefaultMemberService(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  // 회원 가입
  @Override
  public int add(Member member) throws Exception {
    return memberDao.insert(member);
  }

  @Override
  public List<Member> list(String keyword) throws Exception {
    return memberDao.findByKeyword(keyword);
  }

  // 내정보 상세보기
  @Override
  public Member get(int no) throws Exception {
    return memberDao.findByNo(no);
  }

  @Override
  public Member get(String email, String password) throws Exception {
    Map<String,Object> params = new HashMap<>();
    params.put("email", email);
    params.put("password", password);

    return memberDao.findByEmailPassword(params);
  }

  @Override
  public Member getEmail(String email) throws Exception {
    return memberDao.findByEmail(email);
  }

  @Override
  public Member getNickname(String nickname) throws Exception {
    return memberDao.findByNickname(nickname);
  }

  // 내정보 수정시 비밀번호 재검증 - Dao에 없음
  @Override
  public Member get(String password) throws Exception {
    //    return memberDao.findyByPassword(password);
    return null;
  }

  @Override
  public int update(Member member) throws Exception {
    return memberDao.update(member);
  }

  @Override
  public int delete(int no) throws Exception {
    return memberDao.delete(no);
  }

  @Override
  public Member Search(String name) throws Exception {
    return memberDao.findByName(name);
  }

  @Override
  public List<Member> Search(int tutorNo) throws Exception {
    //    return memberDao.findFollowerByNo(tutorNo);
    return null;
  }
}