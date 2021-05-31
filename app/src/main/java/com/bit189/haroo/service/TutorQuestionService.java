package com.bit189.haroo.service;

import java.util.List;
import com.bit189.haroo.domain.AttachedFile;
import com.bit189.haroo.domain.Post;
import com.bit189.haroo.domain.TutorQuestion;

public interface TutorQuestionService {

  int add(TutorQuestion tutorQuestion, Post post, List<AttachedFile> files) throws Exception;

  List<TutorQuestion> list() throws Exception;

  TutorQuestion get(int no) throws Exception;

  int update(TutorQuestion tutorQuestion) throws Exception;

  int replyUpdate(TutorQuestion tutorQuestion, AttachedFile attachedFile) throws Exception;

  int delete(int no) throws Exception;

}
