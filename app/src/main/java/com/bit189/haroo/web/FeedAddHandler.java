package com.bit189.haroo.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.AttachedFile;
import com.bit189.haroo.domain.Feed;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.Post;
import com.bit189.haroo.domain.Tutor;
import com.bit189.haroo.service.FeedService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;


@Controller
public class FeedAddHandler {

  FeedService feedService;

  public FeedAddHandler(FeedService feedService) {
    this.feedService = feedService; 
  }


  @RequestMapping("/feed/add")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    String uploadDir = request.getServletContext().getRealPath("/upload");

    if (request.getMethod().equals("GET")) {
      return "/jsp/feed/form.jsp";
    }

    Post post = new Post();
    post.setContent(request.getParameter("content"));

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    // 로그인유저가 튜터인지 확인하는 코드 작성 필요
    Tutor tutor = new Tutor();
    tutor.setNo(loginUser.getNo());

    Feed feed = new Feed();
    feed.setWriter(tutor);

    ArrayList<AttachedFile> attachedFiles = new ArrayList<>();


    Collection<Part> files = request.getParts();
    for (Part file : files) {
      if (file.getName().equals("file") && file.getSize() > 0) {
        System.out.println(">" + file.getSubmittedFileName());

        System.out.println("uploadDir1 : " + uploadDir);

        //          Part photoPart = request.getPart("file");
        if (file.getSize() > 0) {
          // 파일을 선택해서 업로드 했다면,
          String filename = UUID.randomUUID().toString();

          System.out.println("uploadDir2 : " + uploadDir);

          file.write(uploadDir + "/" + filename);
          System.out.println("uploadDir3 : " + uploadDir);
          System.out.println(uploadDir + "/");

          AttachedFile f = new AttachedFile();
          f.setName(filename);

          attachedFiles.add(f);
          //          f.setPostNo(post.getNo());
          //          postService.addFile(f);

          // 썸네일 이미지 생성
          Thumbnails.of(uploadDir + "/" + filename)
          .size(330, 220)
          .outputFormat("jpg")
          .crop(Positions.CENTER)
          .toFiles(new Rename() {
            @Override
            public String apply(String name, ThumbnailParameter param) {
              return name + "_330x220";
            }
          });

          System.out.println("uploadDir4 : " + uploadDir);

          Thumbnails.of(uploadDir + "/" + filename)
          .size(500, 500)
          .outputFormat("jpg")
          .crop(Positions.CENTER)
          .toFiles(new Rename() {
            @Override
            public String apply(String name, ThumbnailParameter param) {
              return name + "_500x500";
            }
          });
        }
      }


      System.out.println("uploadDir5 : " + uploadDir);
    }

    feedService.add(post, attachedFiles, feed);


    return "redirect:list";



  }

}
