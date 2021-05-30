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
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.Post;
import com.bit189.haroo.domain.Question;
import com.bit189.haroo.domain.ServiceInfo;
import com.bit189.haroo.service.ServiceQuestionService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;


@Controller
public class QuestionAddHandler{

  ServiceQuestionService serviceQuestionService;

  public QuestionAddHandler(ServiceQuestionService serviceQuestionService) {
    this.serviceQuestionService = serviceQuestionService;
  }

  @RequestMapping("/question/add")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    String uploadDir = request.getServletContext().getRealPath("/upload");

    if (request.getMethod().equals("GET")) {
      return "/jsp/serviceQuestion/form.jsp";
    }


    Post post = new Post();
    Question question = new Question();
    ArrayList<AttachedFile> attachedFiles = new ArrayList<>();

    question.setTitle(request.getParameter("title"));
    question.setSecret(Integer.parseInt(request.getParameter("secret")));
    post.setContent(request.getParameter("content"));


    Member m = new Member();
    m.setNo(3);
    question.setWriter(m);

    ServiceInfo s = new ServiceInfo();
    s.setNo(2);
    question.setServiceInfo(s);

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
              return name + "_300x300";
            }
          });
        }
      }


      System.out.println("uploadDir5 : " + uploadDir);
    }

    serviceQuestionService.add(question, post, attachedFiles);

    return "redirect:list";

  }    

}

