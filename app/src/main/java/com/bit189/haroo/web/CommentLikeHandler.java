package com.bit189.haroo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.CommentService;


@Controller
public class CommentLikeHandler {

  CommentService commentService;

  public CommentLikeHandler(CommentService commentService) {
    this.commentService = commentService;
  }

  @RequestMapping("/feed/comment/like")
  @ResponseBody
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {



    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
    }

    int commentNo = Integer.parseInt(request.getParameter("no"));

    int isLike = commentService.getLike(commentNo, loginUser.getNo());

    if (isLike == 1) {
      commentService.deleteLike(commentNo, loginUser.getNo());
      return "no";
    } else {
      commentService.addLike(commentNo, loginUser.getNo());
      return "yes";
    }


  }

}
