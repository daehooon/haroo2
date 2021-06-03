package com.bit189.haroo.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import com.bit189.haroo.dao.AttachedFileDao;
import com.bit189.haroo.dao.PostDao;
import com.bit189.haroo.dao.TutorQuestionDao;
import com.bit189.haroo.domain.AttachedFile;
import com.bit189.haroo.domain.Post;
import com.bit189.haroo.domain.TutorQuestion;
import com.bit189.haroo.service.TutorQuestionService;


@Service
public class DefaultTutorQuestionService implements TutorQuestionService{

  TransactionTemplate transactionTemplate;

  TutorQuestionDao tutorQuestionDao;
  PostDao postDao;
  AttachedFileDao attachedFileDao;

  public DefaultTutorQuestionService(PlatformTransactionManager txManager, TutorQuestionDao tutorQuestionDao, PostDao postDao, 
      AttachedFileDao attachedFileDao) {
    this.transactionTemplate = new TransactionTemplate(txManager);
    this.tutorQuestionDao = tutorQuestionDao;
    this.postDao = postDao;
    this.attachedFileDao = attachedFileDao;

  }

  @Override
  public int add(TutorQuestion tutorQuestion, Post post, List<AttachedFile> files) throws Exception {
    return transactionTemplate.execute(new TransactionCallback<Integer>(){

      @Override
      public Integer doInTransaction(TransactionStatus status) {
        try {
          int count = postDao.insert(post);

          HashMap<String,Object> param = new HashMap<>();
          param.put("no", post.getNo());
          param.put("tutorQuestion", tutorQuestion);

          for (AttachedFile file : files) {
            file.setPostNo(post.getNo());

            postDao.insertFile(file);
          }

          tutorQuestionDao.insert(param);

          return count;
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    });
  }


  @Override
  public List<TutorQuestion> list() throws Exception {
    List<TutorQuestion> tutorQuestions = tutorQuestionDao.findAll();

    return tutorQuestions;
  }

  @Override
  public TutorQuestion get(int no) throws Exception {
    TutorQuestion tutorQuestion = tutorQuestionDao.findByNo(no);
    if (tutorQuestion != null) {
      postDao.updateViewCount(no);
    }
    return tutorQuestion;
  }

  @Override
  public int update(TutorQuestion tutorQuestion) throws Exception {
    return tutorQuestionDao.update(tutorQuestion);
  }

  @Override
  public int delete(int no) throws Exception {
    return postDao.delete(no);
  }

  @Override
  public int replyUpdate(TutorQuestion tutorQuestion, AttachedFile attachedFile) throws Exception {
    attachedFileDao.insert(attachedFile);
    return tutorQuestionDao.update(tutorQuestion);
  }
}
