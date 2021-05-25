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
import com.bit189.haroo.dao.CommentDao;
import com.bit189.haroo.dao.FeedDao;
import com.bit189.haroo.dao.LearningDao;
import com.bit189.haroo.dao.LearningReviewDao;
import com.bit189.haroo.dao.LearningReviewRecommendDao;
import com.bit189.haroo.dao.LearningScheduleDao;
import com.bit189.haroo.dao.LikeDao;
import com.bit189.haroo.dao.MemberDao;
import com.bit189.haroo.dao.NarrowCategoryDao;
import com.bit189.haroo.dao.PostDao;
import com.bit189.haroo.dao.ReCommentDao;
import com.bit189.haroo.dao.ServiceInfoDao;
import com.bit189.haroo.dao.ServiceQuestionDao;
import com.bit189.haroo.dao.SidoDao;
import com.bit189.haroo.dao.SigunguDao;
import com.bit189.haroo.dao.TutorDao;
import com.bit189.haroo.service.BroadCategoryService;
import com.bit189.haroo.service.CommentService;
import com.bit189.haroo.service.FeedService;
import com.bit189.haroo.service.LearningReviewService;
import com.bit189.haroo.service.LearningService;
import com.bit189.haroo.service.LikeService;
import com.bit189.haroo.service.MemberService;
import com.bit189.haroo.service.NarrowCategoryService;
import com.bit189.haroo.service.PostService;
import com.bit189.haroo.service.ReCommentService;
import com.bit189.haroo.service.ServiceQuestionService;
import com.bit189.haroo.service.SidoService;
import com.bit189.haroo.service.SigunguService;
import com.bit189.haroo.service.TutorService;
import com.bit189.haroo.service.impl.DefaultBroadCategoryService;
import com.bit189.haroo.service.impl.DefaultCommentService;
import com.bit189.haroo.service.impl.DefaultFeedService;
import com.bit189.haroo.service.impl.DefaultLearningReviewService;
import com.bit189.haroo.service.impl.DefaultLearningService;
import com.bit189.haroo.service.impl.DefaultLikeService;
import com.bit189.haroo.service.impl.DefaultMemberService;
import com.bit189.haroo.service.impl.DefaultNarrowCategoryService;
import com.bit189.haroo.service.impl.DefaultPostService;
import com.bit189.haroo.service.impl.DefaultReCommentService;
import com.bit189.haroo.service.impl.DefaultServiceQuestionService;
import com.bit189.haroo.service.impl.DefaultSidoService;
import com.bit189.haroo.service.impl.DefaultSigunguService;
import com.bit189.haroo.service.impl.DefaultTutorService;

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
      CommentDao commentDao = daoFactory.createDao(CommentDao.class);
      ReCommentDao reCommentDao = daoFactory.createDao(ReCommentDao.class);
      TutorDao tutorDao = daoFactory.createDao(TutorDao.class);
      PostDao postDao = daoFactory.createDao(PostDao.class);
      LikeDao likeDao = daoFactory.createDao(LikeDao.class);
      ServiceInfoDao serviceInfoDao = daoFactory.createDao(ServiceInfoDao.class);
      LearningDao learningDao = daoFactory.createDao(LearningDao.class);
      BroadCategoryDao broadCategoryDao = daoFactory.createDao(BroadCategoryDao.class);
      NarrowCategoryDao narrowCategoryDao = daoFactory.createDao(NarrowCategoryDao.class);
      SidoDao sidoDao = daoFactory.createDao(SidoDao.class);
      SigunguDao sigunguDao = daoFactory.createDao(SigunguDao.class);
      LearningScheduleDao learningScheduleDao = daoFactory.createDao(LearningScheduleDao.class);

      //LearningApplicationDao learningApplicationDao = daoFactory.createDao(LearningApplicationDao.class);
      ServiceQuestionDao serviceQuestionDao = daoFactory.createDao(ServiceQuestionDao.class);

      //    LearningApplicationDao learningApplicationDao = daoFactory.createDao(LearningApplicationDao.class);
      LearningReviewDao learningReviewDao = daoFactory.createDao(LearningReviewDao.class);
      LearningReviewRecommendDao learningReviewRecommendDao = daoFactory.createDao(LearningReviewRecommendDao.class);

      // 3) 서비스 관련 객체 준비

      TransactionManager txManager = new TransactionManager(sqlSessionFactoryProxy);

      MemberService memberService = new DefaultMemberService(memberDao);
      FeedService feedService = new DefaultFeedService(feedDao, commentDao, likeDao, postDao);
      CommentService commentService = new DefaultCommentService(commentDao);
      ReCommentService reCommentService = new DefaultReCommentService(reCommentDao);
      TutorService tutorService = new DefaultTutorService(tutorDao); // 확인 바람!!!
      PostService postService = new DefaultPostService(postDao);

      LearningService learningService = new DefaultLearningService(txManager, serviceInfoDao, learningDao, learningScheduleDao);
      BroadCategoryService broadCategoryService = new DefaultBroadCategoryService(broadCategoryDao);
      NarrowCategoryService narrowCategoryService = new DefaultNarrowCategoryService(narrowCategoryDao);
      SidoService sidoService = new DefaultSidoService(sidoDao);
      SigunguService sigunguService = new DefaultSigunguService(sigunguDao);

      // LearningApplicationService learningApplicationService = new DefaultLearningApplicationService(learningApplicationDao, null);
      ServiceQuestionService serviceQuestionService = new DefaultServiceQuestionService(txManager, serviceQuestionDao, postDao);

      //    LearningApplicationService learningApplicationService = new DefaultLearningApplicationService(learningApplicationDao, null);

      LearningReviewService learningReviewService = new DefaultLearningReviewService(
          txManager, learningReviewDao, learningReviewRecommendDao);
      LikeService likeService = new DefaultLikeService(likeDao);


      // 4) 서비스 객체를 ServletContext 보관소에 저장한다.
      servletContext.setAttribute("memberService", memberService);
      servletContext.setAttribute("feedService", feedService);
      servletContext.setAttribute("commentService", commentService);
      servletContext.setAttribute("postService", postService);

      servletContext.setAttribute("learningService", learningService);
      servletContext.setAttribute("broadCategoryService", broadCategoryService);
      servletContext.setAttribute("narrowCategoryService", narrowCategoryService);
      servletContext.setAttribute("sidoService", sidoService);
      servletContext.setAttribute("sigunguService", sigunguService);

      //servletContext.setAttribute("learningApplicationService", learningApplicationService);
      servletContext.setAttribute("serviceQuestionService", serviceQuestionService);

      //    servletContext.setAttribute("learningApplicationService", learningApplicationService);
      servletContext.setAttribute("learningReviewService", learningReviewService);
      servletContext.setAttribute("likeService", likeService);
      servletContext.setAttribute("reCommentService", reCommentService);

      System.out.println("ContextLoaderListener: 의존 객체를 모두 준비하였습니다.");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
