package com.bit189.haroo.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bit189.haroo.domain.AttachedFile;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.Post;
import com.bit189.haroo.domain.Tutor;
import com.bit189.haroo.domain.TutorQuestion;
import com.bit189.haroo.service.TutorQuestionService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;


@Controller
@RequestMapping("/tutorQuestion/")
public class TutorQuestionController {

  TutorQuestionService tutorQuestionService;
  ServletContext sc;

  public TutorQuestionController(TutorQuestionService tutorQuestionService,  ServletContext sc) {
    this.tutorQuestionService = tutorQuestionService;
    this.sc = sc;
  }

  @GetMapping("form")
  public void form() throws Exception {
  }

  @PostMapping("add")
  public String add(TutorQuestion tutorQuestion, Post post, HttpSession session, Part photoFile,
      AttachedFile attachedFile, HttpServletRequest request)
          throws Exception {

    String uploadDir = sc.getRealPath("/upload");

    ArrayList<AttachedFile> attachedFiles = new ArrayList<>();

    Member loginUser = (Member) session.getAttribute("loginUser");
    tutorQuestion.setWriter(loginUser);

    Tutor t = new Tutor();
    t.setNo(1);
    tutorQuestion.setTutor(t);

    Collection<Part> files = request.getParts();
    for (Part file : files) {
      if (file.getName().equals("file") && file.getSize() > 0) {
        System.out.println(">" + file.getSubmittedFileName());

        System.out.println("uploadDir1 : " + uploadDir);

        if (file.getSize() > 0) {
          // ????????? ???????????? ????????? ?????????,
          String filename = UUID.randomUUID().toString();

          System.out.println("uploadDir2 : " + uploadDir);

          file.write(uploadDir + "/" + filename);
          System.out.println("uploadDir3 : " + uploadDir);
          System.out.println(uploadDir + "/");

          attachedFile.setName(filename);

          attachedFiles.add(attachedFile);
          //          f.setPostNo(post.getNo());
          //          postService.addFile(f);

          // ????????? ????????? ??????
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

    tutorQuestionService.add(tutorQuestion, post, attachedFiles);

    return "redirect:list";

  } 

  @GetMapping("delete")
  public String delete(int no, HttpSession session) throws Exception {
    TutorQuestion oldTutorQuestion = tutorQuestionService.get(no);

    if (oldTutorQuestion == null) {
      throw new Exception("?????? ????????? ???????????? ????????????.");
    }

    Member loginUser = (Member) session.getAttribute("loginUser");
    if (oldTutorQuestion.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("?????? ????????? ????????????!");
    }

    tutorQuestionService.delete(no);

    return "redirect:list";
  }

  @GetMapping("detail")
  public void detail(int no, Model model) throws Exception {
    TutorQuestion q = tutorQuestionService.get(no);
    model.addAttribute("tutorQuestion", q);
  }

  @RequestMapping("list")
  public void list(Model model) throws Exception {

    List<TutorQuestion> tutorQuestions = tutorQuestionService.list();

    model.addAttribute("tutorQuestions", tutorQuestions);
  }    

  @PostMapping("update")
  public String update(int no, TutorQuestion tutorQuestion, HttpSession session)
      throws Exception {

    TutorQuestion oldTutorQuestion = tutorQuestionService.get(tutorQuestion.getNo());
    if (oldTutorQuestion == null) {
      throw new Exception("?????? ????????? ???????????? ????????????.");
    } 

    Member loginUser = (Member) session.getAttribute("loginUser");
    if (oldTutorQuestion.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("?????? ????????? ????????????!");
    }

    tutorQuestionService.update(tutorQuestion);

    return "redirect:list";

  }

  @GetMapping("form2")
  public void form2() throws Exception {
  }

  @PostMapping("reply/add")
  public String replyAdd(@RequestParam(defaultValue = "0") int pno, TutorQuestion tutorQuestion,
      Model model, HttpSession session, Part photoFile,
      AttachedFile attachedFile, HttpServletRequest request)
          throws Exception {

    TutorQuestion oldTutorQuestion = tutorQuestionService.get(tutorQuestion.getNo());
    if (oldTutorQuestion == null) {
      throw new Exception("?????? ????????? ???????????? ????????????.");
    }

    Member loginUser = (Member) session.getAttribute("loginUser");
    if (oldTutorQuestion.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("?????? ????????? ????????????!");
    }

    tutorQuestion.setWriter(loginUser);
    tutorQuestion.setNo(oldTutorQuestion.getNo());


    String uploadDir = sc.getRealPath("/upload");


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

    tutorQuestionService.replyUpdate(tutorQuestion, attachedFile);

    return "redirect:list";


  }    

}

