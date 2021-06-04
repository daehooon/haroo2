package com.bit189.haroo.service;

import java.util.List;
import com.bit189.haroo.domain.AttachedFile;
import com.bit189.haroo.domain.Post;
import com.bit189.haroo.domain.Question;

public interface ServiceQuestionService {

  int add(Question question, Post post, List<AttachedFile> files) throws Exception;

  List<Question> list() throws Exception;

  List<Question> listByMember(int mno) throws Exception;

  Question get(int no) throws Exception;

  int update(Question question) throws Exception;

  //  int replyAdd(Question question, AttachedFile attachedFile) throws Exception;

  int delete(int no) throws Exception;

  List<Question> Search(String keyword) throws Exception;

}
