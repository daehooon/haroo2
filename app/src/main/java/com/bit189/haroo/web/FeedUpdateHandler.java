package com.bit189.haroo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Feed;
import com.bit189.haroo.service.CommentService;
import com.bit189.haroo.service.FeedService;


@Controller
public class FeedUpdateHandler {

  FeedService feedService;
  CommentService commentService;

  public FeedUpdateHandler(FeedService feedService, CommentService commentService) {
    this.feedService = feedService;
    this.commentService = commentService;
  }

  @RequestMapping("/feed/update")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    Feed oldFeed = feedService.get(no);

    if (oldFeed == null) {
      throw new Exception("해당 번호의 스토리가 없습니다.");
    }

    Feed feed = new Feed();

    // 아직 작업 보류..





    return "redirect:list";

  }
}






