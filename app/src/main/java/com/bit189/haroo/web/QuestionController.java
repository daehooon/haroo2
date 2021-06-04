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
import com.bit189.haroo.domain.Question;
import com.bit189.haroo.domain.ServiceInfo;
import com.bit189.haroo.service.ServiceQuestionService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;


@Controller
@RequestMapping("/serviceQuestion/")
public class QuestionController{

  ServletContext sc;
  ServiceQuestionService serviceQuestionService;


  public QuestionController(ServiceQuestionService serviceQuestionService, ServletContext sc) {
    this.serviceQuestionService = serviceQuestionService;
    this.sc = sc;
  }

  @GetMapping("form")
  public void form() throws Exception {
  }

  @PostMapping("add")
  public String add(Question question, Post post, HttpSession session, HttpServletRequest request)
      throws Exception {

    String uploadDir = sc.getRealPath("/upload");



    Member loginUser = (Member) session.getAttribute("loginUser");
    question.setWriter(loginUser);

    ServiceInfo s = new ServiceInfo();
    s.setNo(1);
    question.setServiceInfo(s);



    ArrayList<AttachedFile> attachedFiles = new ArrayList<>();

    Collection<Part> files = request.getParts();
    for (Part file : files) {
      if (file.getName().equals("file") && file.getSize() > 0) {
        System.out.println(">" + file.getSubmittedFileName());
        String filename = UUID.randomUUID().toString();

        file.write(uploadDir + "/" + filename);

        AttachedFile f = new AttachedFile();
        f.setName(filename);

        attachedFiles.add(f);

        Thumbnails.of(uploadDir + "/" + filename)
        .size(300, 300)
        .outputFormat("jpg")
        .crop(Positions.CENTER)
        .toFiles(new Rename() {
          @Override
          public String apply(String name, ThumbnailParameter param) {
            return name + "_300x300";
          }
        });


        Thumbnails.of(uploadDir + "/" + filename)
        .size(300, 300)
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



    serviceQuestionService.add(question, post, attachedFiles);

    return "redirect:list";

  }    

  @GetMapping("delete")
  public String delete(int no, HttpSession session) throws Exception {

    Question oldQuestion = serviceQuestionService.get(no);

    if (oldQuestion == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }

    Member loginUser = (Member) session.getAttribute("loginUser");
    if (oldQuestion.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("삭제 권한이 없습니다!");
    }

    serviceQuestionService.delete(no);

    return "redirect:list";

  }

  @GetMapping("detail")
  public void detail(int no, Model model)
      throws Exception {

    Question question = serviceQuestionService.get(no);
    model.addAttribute("question", question);

  }

  @GetMapping("list")
  public void list(Model model) throws Exception {


    List<Question> questions = serviceQuestionService.list();

    model.addAttribute("questions", questions);

  }    

  @GetMapping("updateForm")
  public void updateForm(int no, Model model) throws Exception {
    model.addAttribute("question", serviceQuestionService.get(no));
  }

  @PostMapping("update")
  public String update(int no,  Model model, Question question, HttpSession session)
      throws Exception {

    Question oldQuestion = serviceQuestionService.get(question.getNo());
    if (oldQuestion == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    } 

    Member loginUser = (Member) session.getAttribute("loginUser");
    if (oldQuestion.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("변경 권한이 없습니다!");
    }
    model.addAttribute("no", no);
    model.addAttribute("question", oldQuestion);
    serviceQuestionService.update(question);

    return "redirect:detail?no=" + question.getNo();

  }

  @GetMapping("form2")
  public void form2(int pno, Model model) throws Exception {
    model.addAttribute("pno", pno);
  }

  @PostMapping("reply/add")
  public String replyAdd(@RequestParam(defaultValue = "0") int pno, Question question,
      Model model, HttpSession session, Part photoFile,
      AttachedFile attachedFile, HttpServletRequest request)
          throws Exception {


    Question oldQuestion = serviceQuestionService.get(pno);
    if (oldQuestion == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }

    Member loginUser = (Member) session.getAttribute("loginUser");
    if (oldQuestion.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("작업 권한이 없습니다!");
    }

    question.setWriter(loginUser);
    question.setNo(oldQuestion.getNo());


    String uploadDir = sc.getRealPath("/upload");

    ArrayList<AttachedFile> replyAttachedFiles = new ArrayList<>();

    Collection<Part> files = request.getParts();
    for (Part file : files) {
      if (file.getName().equals("file") && file.getSize() > 0) {
        System.out.println(">" + file.getSubmittedFileName());

        System.out.println("uploadDir1 : " + uploadDir);


        String filename = UUID.randomUUID().toString();



        file.write(uploadDir + "/" + filename);

        System.out.println(uploadDir + "/");


        attachedFile.setName(filename);

        replyAttachedFiles.add(attachedFile);



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

    serviceQuestionService.replyAdd(question, attachedFile);

    return "redirect:list";


  }    
}