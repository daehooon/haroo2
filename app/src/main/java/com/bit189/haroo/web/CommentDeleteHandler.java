package com.bit189.haroo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Comment;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.CommentService;


@Controller
public class CommentDeleteHandler {

  CommentService commentService;

  public CommentDeleteHandler(CommentService commentService) {
    this.commentService = commentService;
  }

  @RequestMapping("/feed/comment/delete")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    Comment comment = commentService.get(no);

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser.getNo() != comment.getWriter().getNo()) {
      throw new Exception("삭제 권한이 없습니다!");
    }

    commentService.delete(no);

    return "redirect:../detail?no=" + Integer.parseInt(request.getParameter("feedNo"));


  }

}
