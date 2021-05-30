package com.bit189.haroo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.CommentService;
import com.bit189.haroo.service.FeedService;
import com.bit189.haroo.service.ReCommentService;


@Controller
public class LikeCheckHandler {

  FeedService feedService;
  CommentService commentService;
  ReCommentService reCommentService;

  public LikeCheckHandler(FeedService feedService, CommentService commentService, ReCommentService reCommentService) {
    this.feedService = feedService;
    this.commentService = commentService;
    this.reCommentService = reCommentService;
  }

  @RequestMapping("/feed/likeCheck")
  @ResponseBody
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {


    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    int no = Integer.parseInt(request.getParameter("no"));
    int likeType = Integer.parseInt(request.getParameter("lType"));

    int isLike = 0;

    if (likeType == 1) {
      isLike = feedService.getLike(no, loginUser.getNo());
    } else if (likeType == 2) {
      isLike = commentService.getLike(no, loginUser.getNo());
    } else if (likeType == 3) {
      isLike = reCommentService.getLike(no, loginUser.getNo());
    }


    if (isLike == 1) {
      return "yes";
    } else {
      return "no";
    }


  }

}
