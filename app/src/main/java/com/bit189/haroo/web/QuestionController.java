package com.bit189.haroo.web;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.Question;
import com.bit189.haroo.service.ServiceQuestionService;


@Controller
@RequestMapping("/question/")
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

  //  @RequestMapping("add")
  //  public String add(Question question, Post post, HttpSession session)
  //      throws Exception {
  //
  //    String uploadDir = sc.getRealPath("/upload");
  //
  //    ArrayList<AttachedFile> attachedFiles = new ArrayList<>();
  //
  //    Member loginUser = (Member) session.getAttribute("loginUser");
  //    question.setWriter(loginUser);
  //
  //    ServiceInfo s = new ServiceInfo();
  //    s.setNo(2);
  //    question.setServiceInfo(s);
  //
  //    Collection<Part> files = request.getParts();
  //    for (Part file : files) {
  //      if (file.getName().equals("file") && file.getSize() > 0) {
  //        System.out.println(">" + file.getSubmittedFileName());
  //
  //        System.out.println("uploadDir1 : " + uploadDir);
  //
  //        //          Part photoPart = request.getPart("file");
  //        if (file.getSize() > 0) {
  //          // 파일을 선택해서 업로드 했다면,
  //          String filename = UUID.randomUUID().toString();
  //
  //          System.out.println("uploadDir2 : " + uploadDir);
  //
  //          file.write(uploadDir + "/" + filename);
  //          System.out.println("uploadDir3 : " + uploadDir);
  //          System.out.println(uploadDir + "/");
  //
  //          AttachedFile f = new AttachedFile();
  //          f.setName(filename);
  //
  //          attachedFiles.add(f);
  //          //          f.setPostNo(post.getNo());
  //          //          postService.addFile(f);
  //
  //          // 썸네일 이미지 생성
  //          Thumbnails.of(uploadDir + "/" + filename)
  //          .size(330, 220)
  //          .outputFormat("jpg")
  //          .crop(Positions.CENTER)
  //          .toFiles(new Rename() {
  //            @Override
  //            public String apply(String name, ThumbnailParameter param) {
  //              return name + "_330x220";
  //            }
  //          });
  //
  //          System.out.println("uploadDir4 : " + uploadDir);
  //
  //          Thumbnails.of(uploadDir + "/" + filename)
  //          .size(500, 500)
  //          .outputFormat("jpg")
  //          .crop(Positions.CENTER)
  //          .toFiles(new Rename() {
  //            @Override
  //            public String apply(String name, ThumbnailParameter param) {
  //              return name + "_300x300";
  //            }
  //          });
  //        }
  //      }
  //
  //
  //      System.out.println("uploadDir5 : " + uploadDir);
  //    }
  //
  //    serviceQuestionService.add(question, post, attachedFiles);
  //
  //    return "redirect:list";
  //
  //  }    

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
  public void list(Model model)
      throws Exception {

    List<Question> questions = serviceQuestionService.list();

    model.addAttribute("questions", questions);

  }    

  @PostMapping("update")
  public String update(int no, Question question, HttpSession session)
      throws Exception {

    Question oldQuestion = serviceQuestionService.get(question.getNo());
    if (oldQuestion == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    } 

    Member loginUser = (Member) session.getAttribute("loginUser");
    if (oldQuestion.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("변경 권한이 없습니다!");
    }

    serviceQuestionService.update(question);

    return "redirect:list";

  }

  //  @RequestMapping("reply/add")
  //  public String replyAdd(@RequestParam(defaultValue = "0") int no, Question question, Model model)
  //      throws Exception {
  //
  //    String uploadDir = request.getServletContext().getRealPath("/upload");
  //
  //    if (request.getMethod().equals("GET")) {
  //      return "/jsp/serviceQuestion/form2.jsp";
  //    }
  //
  //    int no = Integer.parseInt(request.getParameter("no"));
  //
  //    Question oldQuestion = serviceQuestionService.get(no);
  //
  //    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
  //    if (oldQuestion.getWriter().getNo() != loginUser.getNo()) {
  //      throw new Exception("작업 권한이 없습니다!");
  //    }
  //
  //    Question question = new Question();
  //    question.setNo(oldQuestion.getNo());
  //    question.setReplyContent(request.getParameter("content"));
  //
  //
  //    AttachedFile attachedFile = new AttachedFile();
  //
  //    Collection<Part> files = request.getParts();
  //    for (Part file : files) {
  //      if (file.getName().equals("file") && file.getSize() > 0) {
  //        System.out.println(">" + file.getSubmittedFileName());
  //
  //        System.out.println("uploadDir1 : " + uploadDir);
  //
  //        if (file.getSize() > 0) {
  //          String filename = UUID.randomUUID().toString();
  //
  //          System.out.println("uploadDir2 : " + uploadDir);
  //
  //          file.write(uploadDir + "/" + filename);
  //          System.out.println("uploadDir3 : " + uploadDir);
  //          System.out.println(uploadDir + "/");
  //
  //
  //          attachedFile.setName(filename);
  //
  //          //attachedFile.add(attachedFile);
  //
  //          System.out.println("uploadDir4 : " + uploadDir);
  //
  //          Thumbnails.of(uploadDir + "/" + filename)
  //          .size(500, 500)
  //          .outputFormat("jpg")
  //          .crop(Positions.CENTER)
  //          .toFiles(new Rename() {
  //            @Override
  //            public String apply(String name, ThumbnailParameter param) {
  //              return name + "_300x300";
  //            }
  //          });
  //        }
  //      }
  //
  //      System.out.println("uploadDir5 : " + uploadDir);
  //    }
  //
  //    serviceQuestionService.replyUpdate(question, attachedFile);
  //
  //    return "redirect:list";
  //
  //
  //  }    
}

