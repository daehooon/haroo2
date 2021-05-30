package com.bit189.haroo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.ReComment;
import com.bit189.haroo.service.ReCommentService;


@Controller
public class ReCommentAddHandler {

  ReCommentService reCommentService;

  public ReCommentAddHandler(ReCommentService reCommentService) {
    this.reCommentService = reCommentService;
  }

  @RequestMapping("/feed/reComment/add")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    ReComment reComment = new ReComment();

    reComment.setCommentNo(Integer.parseInt(request.getParameter("commentNo")));
    reComment.setContent(request.getParameter("content"));
    Member taggedMember = new Member();
    taggedMember.setNo(Integer.parseInt(request.getParameter("taggedNo")));
    reComment.setTaggedMember(taggedMember);
    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    reComment.setReWriter(loginUser);

    reCommentService.add(reComment);

    return "redirect:../detail?no=" + Integer.parseInt(request.getParameter("no"));


  }

}
