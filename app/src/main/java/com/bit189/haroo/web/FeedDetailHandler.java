package com.bit189.haroo.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Comment;
import com.bit189.haroo.domain.Feed;
import com.bit189.haroo.service.CommentService;
import com.bit189.haroo.service.FeedService;


@Controller
public class FeedDetailHandler {

  FeedService feedService;
  CommentService commentService;

  public FeedDetailHandler(FeedService feedService, CommentService commentService) {
    this.feedService = feedService;
    this.commentService = commentService;
  }

  @RequestMapping("/feed/detail")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    Feed feed = feedService.get(no);
    List<Comment> comments = commentService.list(no);

    request.setAttribute("feed", feed);
    request.setAttribute("comments", comments);

    return "/jsp/feed/detail.jsp";

  }
}





