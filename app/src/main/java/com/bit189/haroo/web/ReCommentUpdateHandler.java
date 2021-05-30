package com.bit189.haroo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.ReComment;
import com.bit189.haroo.service.ReCommentService;


@Controller
public class ReCommentUpdateHandler {

  ReCommentService reCommentService;

  public ReCommentUpdateHandler(ReCommentService reCommentService) {
    this.reCommentService = reCommentService;
  }

  @RequestMapping("/feed/reComment/update")
  @ResponseBody
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));
    String content = request.getParameter("content");

    ReComment oldReComment = reCommentService.get(no);

    if (oldReComment == null) {
      throw new Exception("해당 번호의 대댓글이 없습니다.");
    }

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser.getNo() != oldReComment.getReWriter().getNo()) {
      throw new Exception("수정할 권한이 없습니다.");
    }

    ReComment reComment = new ReComment();
    reComment.setNo(no);
    reComment.setContent(content);

    reCommentService.update(reComment);

    return "yes!";
  }



}
