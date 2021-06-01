package com.bit189.haroo.web;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bit189.haroo.domain.Comment;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.CommentService;


@Controller
@RequestMapping("/feed/comment")
public class CommentController {

  CommentService commentService;

  public CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  @PostMapping("add")
  public String add(Comment comment, HttpSession session) throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");

    comment.setWriter(loginUser);

    commentService.add(comment);

    return "redirect:../detail?no=" + comment.getFeedNo();


  }


  @GetMapping("delete")
  public String delete(int no, int feedNo, HttpSession session)
      throws Exception {

    Comment comment = commentService.get(no);

    Member loginUser = (Member) session.getAttribute("loginUser");

    if (loginUser.getNo() != comment.getWriter().getNo()) {
      throw new Exception("삭제 권한이 없습니다!");
    }

    commentService.delete(no);

    return "redirect:../detail?no=" + feedNo;


  }


  @PostMapping("update")
  @ResponseBody
  public String update(Comment comment, HttpSession session)
      throws Exception {

    Comment oldComment = commentService.get(comment.getNo());

    if (oldComment == null) {
      throw new Exception("해당 번호의 댓글이 없습니다.");
    }

    Member loginUser = (Member) session.getAttribute("loginUser");
    if (loginUser.getNo() != oldComment.getWriter().getNo()) {
      throw new Exception("수정할 권한이 없습니다.");
    }

    commentService.update(comment);

    return "yes!";
  }


  @PostMapping("like")
  @ResponseBody
  public String like(int no, HttpSession session)
      throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");
    if (loginUser == null) {
    }

    int isLike = commentService.getLike(no, loginUser.getNo());

    if (isLike == 1) {
      commentService.deleteLike(no, loginUser.getNo());
      return "no";
    } else {
      commentService.addLike(no, loginUser.getNo());
      return "yes";
    }


  }

}
