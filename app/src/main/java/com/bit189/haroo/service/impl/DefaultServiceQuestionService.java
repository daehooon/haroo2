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
import com.bit189.haroo.dao.ServiceQuestionDao;
import com.bit189.haroo.domain.AttachedFile;
import com.bit189.haroo.domain.Post;
import com.bit189.haroo.domain.Question;
import com.bit189.haroo.service.ServiceQuestionService;


@Service
public class DefaultServiceQuestionService implements ServiceQuestionService{

  TransactionTemplate transactionTemplate;

  ServiceQuestionDao serviceQuestionDao;
  PostDao postDao;
  AttachedFileDao attachedFileDao;

  public DefaultServiceQuestionService(PlatformTransactionManager txManager, ServiceQuestionDao serviceQuestionDao, PostDao postDao, 
      AttachedFileDao attachedFileDao) {
    this.transactionTemplate = new TransactionTemplate(txManager);
    this.serviceQuestionDao = serviceQuestionDao;
    this.postDao = postDao;
    this.attachedFileDao = attachedFileDao;

  }

  @Override
  public int add(Question question, Post post, List<AttachedFile> files) throws Exception {
    return transactionTemplate.execute(new TransactionCallback<Integer>(){

      @Override
      public Integer doInTransaction(TransactionStatus status) {
        try {
          int count = postDao.insert(post);

          HashMap<String,Object> param = new HashMap<>();
          param.put("no", post.getNo());
          param.put("question", question);

          for (AttachedFile file : files) {
            file.setPostNo(post.getNo());

            postDao.insertFile(file);
          }

          serviceQuestionDao.insert(param);

          return count;
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    });
  }


  @Override
  public List<Question> list() throws Exception {
    List<Question> questions = serviceQuestionDao.findAll();

    return questions;
  }


  @Override
  public List<Question> listByMember(int mno) throws Exception {
    return serviceQuestionDao.findByMember(mno);
  }

  @Override
  public Question get(int no) throws Exception {
    Question question = serviceQuestionDao.findByNo(no);
    if (question != null) {
      postDao.updateViewCount(no);
    }
    return question;
  }

  @Override
  public int update(Question question) throws Exception {
    return serviceQuestionDao.update(question);
  }

  @Override
  public int delete(int no) throws Exception {
    return serviceQuestionDao.delete(no);
  }


  @Override
  public List<Question> Search(String keyword) throws Exception {
    return serviceQuestionDao.findByKeyword(keyword);
  }

  @Override
  public int replyUpdate(Question question, AttachedFile attachedFile) throws Exception {
    attachedFileDao.insert(attachedFile);
    return serviceQuestionDao.update(question);
  }
}
