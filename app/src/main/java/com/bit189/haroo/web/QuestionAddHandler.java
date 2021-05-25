package com.bit189.haroo.web;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.bit189.haroo.domain.AttachedFile;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.Post;
import com.bit189.haroo.domain.Question;
import com.bit189.haroo.domain.ServiceInfo;
import com.bit189.haroo.service.PostService;
import com.bit189.haroo.service.ServiceQuestionService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@SuppressWarnings("serial")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/question/add")
public class QuestionAddHandler extends HttpServlet{

  private String uploadDir;

  @Override
  public void init() throws ServletException {
    this.uploadDir = this.getServletContext().getRealPath("/upload");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    request.getRequestDispatcher("/jsp/serviceQuestion/form.jsp").include(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServiceQuestionService serviceQuestionService =
        (ServiceQuestionService) request.getServletContext().getAttribute("serviceQuestionService");
    PostService postService = (PostService) request.getServletContext().getAttribute("postService");

    try {
      Question question = new Question();
      Post post = new Post();

      question.setTitle(request.getParameter("title"));
      question.setSecret(true);
      post.setContent(request.getParameter("content"));


      Member m = new Member();
      m.setNo(5);
      question.setWriter(m);

      ServiceInfo s = new ServiceInfo();
      s.setNo(2);
      question.setServiceInfo(s);

      Part photoPart = request.getPart("file");
      if (photoPart.getSize() > 0) {

        String filename = UUID.randomUUID().toString();
        photoPart.write(this.uploadDir + "/" + filename);
        AttachedFile f = new AttachedFile();
        f.setName(filename);
        f.setPostNo(post.getNo());
        postService.addFile(f);


        Thumbnails.of(this.uploadDir + "/" + filename)
        .size(10, 10)
        .outputFormat("jpg")
        .crop(Positions.CENTER)
        .toFiles(new Rename() {
          @Override
          public String apply(String name, ThumbnailParameter param) {
            return name + "_330x220";
          }
        });

        Thumbnails.of(this.uploadDir + "/" + filename)
        .size(20, 20)
        .outputFormat("jpg")
        .crop(Positions.CENTER)
        .toFiles(new Rename() {
          @Override
          public String apply(String name, ThumbnailParameter param) {
            return name + "_500x500";
          }
        });
      }

      serviceQuestionService.add(question, post);

      response.sendRedirect("list");
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }    
}

