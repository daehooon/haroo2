package com.bit189.haroo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Tutor;
import com.bit189.haroo.service.TutorService;

@Controller
public class TutorDetailHandler {

  TutorService tutorService;

  public TutorDetailHandler(TutorService tutorService) {
    this.tutorService = tutorService;
  }

  @RequestMapping("/tutor/detail")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    Tutor t = tutorService.get(no);
    request.setAttribute("tutor", t);

    return "/jsp/tutor/detail.jsp";

  }
}






