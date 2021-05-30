package com.bit189.haroo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.FeedService;


@Controller
public class FeedLikeHandler {

  FeedService feedService;

  public FeedLikeHandler(FeedService feedService) {
    this.feedService = feedService;
  }

  @RequestMapping("/feed/like")
  @ResponseBody
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {


    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
    }

    int feedNo = Integer.parseInt(request.getParameter("no"));

    int isLike = feedService.getLike(feedNo, loginUser.getNo());

    if (isLike == 1) {
      feedService.deleteLike(feedNo, loginUser.getNo());
      return "no";
    } else {
      feedService.addLike(feedNo, loginUser.getNo());
      return "yes";
    }


  }

}
