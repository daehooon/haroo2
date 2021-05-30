package com.bit189.haroo.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Feed;
import com.bit189.haroo.service.FeedService;


@Controller
public class FeedListHandler {

  FeedService feedService;

  public FeedListHandler(FeedService feedService) {
    this.feedService = feedService;
  }

  @RequestMapping("/feed/list")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    List<Feed> feeds = feedService.list();

    request.setAttribute("feeds", feeds);

    return "/jsp/feed/list.jsp";

  }

}





