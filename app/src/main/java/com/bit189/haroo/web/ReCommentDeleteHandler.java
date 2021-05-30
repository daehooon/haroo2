package com.bit189.haroo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.ReComment;
import com.bit189.haroo.service.ReCommentService;


@Controller
public class ReCommentDeleteHandler {

  ReCommentService reCommentService;

  public ReCommentDeleteHandler(ReCommentService reCommentService) {
    this.reCommentService = reCommentService;
  }

  @RequestMapping("/feed/reComment/delete")
  public String execute(HttpServletRequest request, HttpServletResponse response)
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

}
