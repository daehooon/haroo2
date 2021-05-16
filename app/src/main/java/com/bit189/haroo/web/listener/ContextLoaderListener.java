package com.bit189.haroo.web.listener;

import java.io.InputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.bit189.Mybatis.MybatisDaoFactory;
import com.bit189.Mybatis.SqlSessionFactoryProxy;
import com.bit189.Mybatis.TransactionManager;
import com.bit189.haroo.dao.BroadCategoryDao;
import com.bit189.haroo.dao.FeedDao;
import com.bit189.haroo.dao.LearningDao;
import com.bit189.haroo.dao.LearningScheduleDao;
import com.bit189.haroo.dao.MemberDao;
import com.bit189.haroo.dao.NarrowCategoryDao;
import com.bit189.haroo.dao.ServiceInfoDao;
import com.bit189.haroo.dao.SidoDao;
import com.bit189.haroo.dao.SigunguDao;
import com.bit189.haroo.service.FeedService;
import com.bit189.haroo.service.LearningService;
import com.bit189.haroo.service.MemberService;
import com.bit189.haroo.service.impl.DefaultFeedService;
import com.bit189.haroo.service.impl.DefaultLearningService;
import com.bit189.haroo.service.impl.DefaultMemberService;


// 웹 애플리케이션을 시작하거나 종료할 때 서버로부터 보고를 받는다.
// 즉 톰캣 서버가 웹 애플리케이션을 시작하거나 종료하면 리스너 규칙에 따라 메서드를 호출한다는 뜻이다.
// 
public class ContextLoaderListener implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    try {
      ServletContext servletContext = sce.getServletContext();

      // 1) Mybatis 관련 객체 준비
      InputStream mybatisConfigStream = Resources.getResourceAsStream(
          servletContext.getInitParameter("mybatis-config"));
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(mybatisConfigStream);
      SqlSessionFactoryProxy sqlSessionFactoryProxy = new SqlSessionFactoryProxy(sqlSessionFactory);

      // 2) DAO 관련 객체 준비
      MybatisDaoFactory daoFactory = new MybatisDaoFactory(sqlSessionFactoryProxy);
      MemberDao memberDao = daoFactory.createDao(MemberDao.class);
      FeedDao feedDao = daoFactory.createDao(FeedDao.class);
      ServiceInfoDao serviceInfoDao = daoFactory.createDao(ServiceInfoDao.class);
      LearningDao learningDao = daoFactory.createDao(LearningDao.class);
      LearningScheduleDao learningScheduleDao = daoFactory.createDao(LearningScheduleDao.class);
      BroadCategoryDao broadCategoryDao = daoFactory.createDao(BroadCategoryDao.class);
      NarrowCategoryDao narrowCategoryDao = daoFactory.createDao(NarrowCategoryDao.class);
      SidoDao sidoDao = daoFactory.createDao(SidoDao.class);
      SigunguDao sigunguDao = daoFactory.createDao(SigunguDao.class);

      // 3) 서비스 관련 객체 준비
      TransactionManager txManager = new TransactionManager(sqlSessionFactoryProxy);

      MemberService memberService = new DefaultMemberService(memberDao);
      FeedService feedService = new DefaultFeedService(feedDao);
      LearningService learningService = new DefaultLearningService(txManager, serviceInfoDao,
          learningDao, learningScheduleDao, broadCategoryDao, narrowCategoryDao, sidoDao, sigunguDao);

      // 4) 서비스 객체를 ServletContext 보관소에 저장한다.
      servletContext.setAttribute("memberService", memberService);
      servletContext.setAttribute("feedService", feedService);
      servletContext.setAttribute("learningService", learningService);

      System.out.println("ContextLoaderListener: 의존 객체를 모두 준비하였습니다.");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
