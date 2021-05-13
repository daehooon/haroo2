package com.bit189.haroo.web;

import java.io.InputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.bit189.Mybatis.MybatisDaoFactory;
import com.bit189.Mybatis.SqlSessionFactoryProxy;
import com.bit189.Mybatis.TransactionManager;
import com.bit189.haroo.dao.FeedDao;
import com.bit189.haroo.dao.MemberDao;
import com.bit189.haroo.service.FeedService;
import com.bit189.haroo.service.MemberService;
import com.bit189.haroo.service.impl.DefaultFeedService;
import com.bit189.haroo.service.impl.DefaultMemberService;

// --------------------사용하지 않는 클래스입니다.--------------------
// web.xml에 배치정보 설정
@SuppressWarnings("serial")
public class AppInitHandler extends HttpServlet {

  @Override
  public void init() throws ServletException {
    // 서블릿 객체를 생성할 때 톰캣 서버가 호출하는 과정
    // 톰캣 서버 => 서블릿 인스턴스 생성 => 생성자 호출 => init(ServletConfig) 호출 => ini() 호출
    //

    try {
      // 1) Mybatis 관련 객체 준비
      InputStream mybatisConfigStream = Resources.getResourceAsStream(
          this.getInitParameter("mybatis-config"));
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(mybatisConfigStream);
      SqlSessionFactoryProxy sqlSessionFactoryProxy = new SqlSessionFactoryProxy(sqlSessionFactory);

      // 2) DAO 관련 객체 준비
      MybatisDaoFactory daoFactory = new MybatisDaoFactory(sqlSessionFactoryProxy);
      MemberDao memberDao = daoFactory.createDao(MemberDao.class);
      FeedDao feedDao = daoFactory.createDao(FeedDao.class);

      // 3) 서비스 관련 객체 준비
      TransactionManager txManager = new TransactionManager(sqlSessionFactoryProxy);

      MemberService memberService = new DefaultMemberService(memberDao);
      FeedService feedService = new DefaultFeedService(feedDao);

      // 4) 서비스 객체를 ServletContext 보관소에 저장한다.
      ServletContext servletContext = this.getServletContext();

      servletContext.setAttribute("memberService", memberService);
      servletContext.setAttribute("feedService", feedService);

      System.out.println("AppInitHandler: 의존 객체를 모두 준비하였습니다.");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
