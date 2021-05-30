package com.bit189.haroo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Tutor;
import com.bit189.haroo.service.TutorService;

@Controller
public class TutorDeleteHandler {

  TutorService tutorService;

  public TutorDeleteHandler(TutorService tutorService) {
    this.tutorService = tutorService;
  }

  @RequestMapping("/tutor/delete")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    Tutor tutor = tutorService.get(no);
    if (tutor == null) {
      throw new Exception("해당 번호의 튜터가 없습니다.");
    }

    tutorService.delete(no);

    return "redirect:list";

  }
}






