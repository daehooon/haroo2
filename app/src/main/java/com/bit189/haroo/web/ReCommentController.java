package com.bit189.haroo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.ReComment;
import com.bit189.haroo.service.ReCommentService;


@Controller
@RequestMapping("/feed/reComment")
public class ReCommentController {

  ReCommentService reCommentService;

  public ReCommentController(ReCommentService reCommentService) {
    this.reCommentService = reCommentService;
  }

  @PostMapping("add")
  public String add(ReComment reComment, int feedNo, HttpSession session) throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");

    reComment.setReWriter(loginUser);

    reCommentService.add(reComment);

    return "redirect:../detail?no=" + feedNo;


  }


  @RequestMapping("delete")
  public String delete(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    ReComment reComment = reCommentService.get(no);

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser.getNo() != reComment.getReWriter().getNo()) {
      throw new Exception("삭제 권한이 없습니다!");
    }

    reCommentService.delete(no);

    return "redirect:../detail?no=" + Integer.parseInt(request.getParameter("feedNo"));

  }


  @PostMapping("update")
  @ResponseBody
  public String update(ReComment reComment, HttpSession session)
      throws Exception {

    ReComment oldReComment = reCommentService.get(reComment.getNo());

    if (oldReComment == null) {
      throw new Exception("해당 번호의 대댓글이 없습니다.");
    }

    Member loginUser = (Member) session.getAttribute("loginUser");
    if (loginUser.getNo() != oldReComment.getReWriter().getNo()) {
      throw new Exception("수정할 권한이 없습니다.");
    }

    reCommentService.update(reComment);

    return "yes!";
  }


  @PostMapping("like")
  @ResponseBody
  public String like(int no, HttpSession session)
      throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");
    if (loginUser == null) {
    }

    int isLike = reCommentService.getLike(no, loginUser.getNo());

    if (isLike == 1) {
      reCommentService.deleteLike(no, loginUser.getNo());
      return "no";
    } else {
      reCommentService.addLike(no, loginUser.getNo());
      return "yes";
    }


  }

}
