package com.bit189.haroo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Comment;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.CommentService;


@Controller
public class CommentAddHandler {

  CommentService commentService;

  public CommentAddHandler(CommentService commentService) {
    this.commentService = commentService;
  }

  @RequestMapping("/feed/comment/add")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    Comment comment = new Comment();
    comment.setFeedNo(Integer.parseInt(request.getParameter("no")));
    comment.setContent(request.getParameter("content"));

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    comment.setWriter(loginUser);

    commentService.add(comment);

    return "redirect:../detail?no=" + comment.getFeedNo();


  }

}
