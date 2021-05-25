package com.bit189.haroo.service.impl;

import java.util.List;
import com.bit189.Mybatis.TransactionCallback;
import com.bit189.Mybatis.TransactionManager;
import com.bit189.Mybatis.TransactionTemplate;
import com.bit189.haroo.dao.PostDao;
import com.bit189.haroo.dao.ServiceQuestionDao;
import com.bit189.haroo.domain.Post;
import com.bit189.haroo.domain.Question;
import com.bit189.haroo.service.ServiceQuestionService;



public class DefaultServiceQuestionService implements ServiceQuestionService{

  TransactionTemplate transactionTemplate;

  ServiceQuestionDao serviceQuestionDao;
  PostDao postDao;


  public DefaultServiceQuestionService(TransactionManager txManager, ServiceQuestionDao serviceQuestionDao, PostDao postDao) {
    this.transactionTemplate = new TransactionTemplate(txManager);
    this.serviceQuestionDao = serviceQuestionDao;
    this.postDao = postDao;

  }

  @Override
  public int add(Question question, Post post) throws Exception {
    return (int) transactionTemplate.execute(new TransactionCallback() {

      @Override
      public Object doInTransaction() throws Exception {

        int count = postDao.insert(post);

        serviceQuestionDao.insert(question);

        return count;
      }
    });
  }

  @Override
  public List<Question> list() throws Exception {
    return serviceQuestionDao.findAll(null);
  }


  @Override
  public List<Question> listByMember(int mno) throws Exception {
    return serviceQuestionDao.findByMember(mno);
  }

  @Override
  public Question get(int no) throws Exception {
    Question question = serviceQuestionDao.findByNo(no);
    if (question != null) {
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



}
