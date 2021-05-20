package com.bit189.haroo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.bit189.haroo.domain.AttachedFile;
import com.bit189.haroo.domain.Feed;
import com.bit189.haroo.domain.Post;
import com.bit189.haroo.domain.Tutor;
import com.bit189.haroo.service.FeedService;
import com.bit189.haroo.service.PostService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@SuppressWarnings("serial")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/feed/add")
public class FeedAddHandler extends HttpServlet{

  private String uploadDir;

  @Override
  public void init() throws ServletException {
    this.uploadDir = this.getServletContext().getRealPath("/upload");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    FeedService feedService = (FeedService) request.getServletContext().getAttribute("feedService");
    PostService postService = (PostService) request.getServletContext().getAttribute("postService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>스토리 등록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>스토리 등록</h1>");

    try {
      Post post = new Post();
      post.setContent(request.getParameter("content"));
      postService.add(post);

      Feed feed = new Feed();
      Tutor tutor = new Tutor();
      tutor.setNo(3);
      feed.setWriter(tutor);
      feedService.add(post.getNo(), feed);

      //      String[] fileName = request.getParameterValues("file");
      //      if (fileName != null) {
      //        for (String file : fileName) {
      //          AttachedFile f = new AttachedFile();
      //
      //          f.setName(file);
      //          f.setPostNo(post.getNo());
      //
      //          postService.addFile(f);
      //        }
      //      }

      //      Part part = request.getPart("file");
      //      System.out.println("part : " + part);
      //
      //      for (Part p : request.getParts()) {
      //        System.out.println("p : " + p);
      //      }

      //      for (String file : request.getParameterValues("file")) {
      Part photoPart = request.getPart("file");
      if (photoPart.getSize() > 0) {
        // 파일을 선택해서 업로드 했다면,
        String filename = UUID.randomUUID().toString();
        photoPart.write(this.uploadDir + "/" + filename);
        AttachedFile f = new AttachedFile();
        f.setName(filename);
        f.setPostNo(post.getNo());
        postService.addFile(f);

        // 썸네일 이미지 생성
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
      //      }

      response.sendRedirect("list");

    } catch (Exception e) {
      throw new ServletException(e);
    }


  }

}
