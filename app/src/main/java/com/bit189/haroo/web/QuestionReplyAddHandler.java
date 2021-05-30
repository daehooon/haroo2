package com.bit189.haroo.web;

import java.util.Collection;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.AttachedFile;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.Question;
import com.bit189.haroo.service.ServiceQuestionService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;


@Controller
public class QuestionReplyAddHandler {

  ServiceQuestionService serviceQuestionService;

  public QuestionReplyAddHandler(ServiceQuestionService serviceQuestionService) {
    this.serviceQuestionService = serviceQuestionService;
  }

  @RequestMapping("/question/reply/add")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    String uploadDir = request.getServletContext().getRealPath("/upload");


    if (request.getMethod().equals("GET")) {
      return "/jsp/serviceQuestion/form2.jsp";
    }

    int no = Integer.parseInt(request.getParameter("no"));

    Question oldQuestion = serviceQuestionService.get(no);

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (oldQuestion.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("작업 권한이 없습니다!");
    }

    Question question = new Question();
    question.setNo(oldQuestion.getNo());
    question.setReplyContent(request.getParameter("content"));


    AttachedFile attachedFile = new AttachedFile();

    Collection<Part> files = request.getParts();
    for (Part file : files) {
      if (file.getName().equals("file") && file.getSize() > 0) {
        System.out.println(">" + file.getSubmittedFileName());

        System.out.println("uploadDir1 : " + uploadDir);

        if (file.getSize() > 0) {
          String filename = UUID.randomUUID().toString();

          System.out.println("uploadDir2 : " + uploadDir);

          file.write(uploadDir + "/" + filename);
          System.out.println("uploadDir3 : " + uploadDir);
          System.out.println(uploadDir + "/");


          attachedFile.setName(filename);

          //attachedFile.add(attachedFile);

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

    serviceQuestionService.replyUpdate(question, attachedFile);

    return "redirect:list";


  }    
}

