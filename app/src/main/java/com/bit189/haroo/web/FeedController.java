package com.bit189.haroo.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.bit189.haroo.domain.AttachedFile;
import com.bit189.haroo.domain.Comment;
import com.bit189.haroo.domain.Feed;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.Post;
import com.bit189.haroo.domain.Tutor;
import com.bit189.haroo.service.CommentService;
import com.bit189.haroo.service.FeedService;
import com.bit189.haroo.service.PostService;
import com.bit189.haroo.service.ReCommentService;
import com.bit189.haroo.service.TutorService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;


@Controller
@RequestMapping("/feed")
public class FeedController {

  FeedService feedService;
  PostService postService;
  CommentService commentService;
  ReCommentService reCommentService;
  TutorService tutorService;
  ServletContext sc;

  public FeedController(FeedService feedService, PostService postService, CommentService commentService, 
      ReCommentService reCommentService, TutorService tutorService, ServletContext sc) {
    this.feedService = feedService; 
    this.postService = postService;
    this.commentService = commentService;
    this.reCommentService = reCommentService;
    this.tutorService = tutorService;
    this.sc = sc;
  }

  @GetMapping("form")
  public void form(HttpSession session, RedirectAttributes redirectAttrs) throws Exception {

  }


  @PostMapping("add")
  public String add(Post post, HttpServletRequest request, HttpSession session, RedirectAttributes redirectAttrs)
      throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");

    // 로그인유저가 튜터인지 확인하는 코드 작성 필요

    Tutor tutor = tutorService.get(loginUser.getNo());

    Feed feed = new Feed();
    feed.setWriter(tutor);

    String uploadDir = sc.getRealPath("/upload");

    ArrayList<AttachedFile> attachedFiles = new ArrayList<>();

    Collection<Part> files = request.getParts();
    for (Part file : files) {
      if (file.getName().equals("files") && file.getSize() > 0) {
        System.out.println(">" + file.getSubmittedFileName());

        // 파일을 선택해서 업로드 했다면,
        String filename = UUID.randomUUID().toString();
        file.write(uploadDir + "/" + filename);

        AttachedFile f = new AttachedFile();
        f.setName(filename);

        attachedFiles.add(f);

        // 썸네일 이미지 생성
        Thumbnails.of(uploadDir + "/" + filename)
        .size(330, 220)
        .outputFormat("jpg")
        .crop(Positions.CENTER)
        .toFiles(new Rename() {
          @Override
          public String apply(String name, ThumbnailParameter param) {
            return name + "_330x220";
          }
        });
        System.out.println("여기?");
        Thumbnails.of(uploadDir + "/" + filename)
        .size(500, 500)
        .outputFormat("jpg")
        .crop(Positions.CENTER)
        .toFiles(new Rename() {
          @Override
          public String apply(String name, ThumbnailParameter param) {
            return name + "_500x500";
          }
        });
      }
      System.out.println("여기?1");

    }

    feedService.add(post, attachedFiles, feed);
    System.out.println("여기?3");

    return "redirect:list?no=" + tutor.getNo();
  }


  @GetMapping("list")
  public void list(Model model, int no) throws Exception {
    Tutor tutor = tutorService.get(no);

    List<Feed> feeds = feedService.list(no);

    model.addAttribute("feeds", feeds);
    model.addAttribute("tutor", tutor);


  }


  @GetMapping("delete")
  public String delete(int no, HttpSession session, RedirectAttributes redirectAttrs) throws Exception {

    Feed feed = feedService.get(no);

    Member loginUser = (Member) session.getAttribute("loginUser");
    if (feed.getWriter().getNo() != loginUser.getNo()) {
      redirectAttrs.addFlashAttribute("deleteMsg","삭제 권한이 없습니다!");

      return "redirect:detail?no=" + no;
    }

    postService.delete(no);

    return "redirect:list?no=" + feed.getWriter().getNo();

  }


  @GetMapping("detail")
  public void detail(int no, Model model)
      throws Exception {

    Feed feed = feedService.get(no);
    List<Comment> comments = commentService.list(no);

    model.addAttribute("feed", feed);
    model.addAttribute("comments", comments);
  }


  @RequestMapping("updateForm")
  public void updateForm(Feed feed, Model model, HttpSession session, RedirectAttributes redirectAttrs)
      throws Exception {


    Feed oldFeed = feedService.getCheck(feed.getNo());

    //    if (oldFeed == null) {
    //      redirectAttrs.addFlashAttribute("updateMsg","해당 번호의 스토리가 없습니다.");
    //
    //      return "redirect:list";
    //    }

    //    Member loginUser = (Member) session.getAttribute("loginUser");

    //    if (loginUser.getNo() != oldFeed.getWriter().getNo()) {
    //      redirectAttrs.addFlashAttribute("updateMsg","수정 권한이 없습니다.");
    //
    //      return "redirect:detail?no=" + feed.getNo();
    //    }

    model.addAttribute("feed", oldFeed);

    //    return "updateForm";
  }


  @RequestMapping("update")
  public String update(Post post, HttpSession session, HttpServletRequest request, RedirectAttributes redirectAttrs)
      throws Exception {


    Feed oldFeed = feedService.getCheck(post.getNo());

    if (oldFeed == null) {
      redirectAttrs.addFlashAttribute("updateMsg","해당 번호의 스토리가 없습니다.");

      return "redirect:list";
    }

    Member loginUser = (Member) session.getAttribute("loginUser");

    if (loginUser.getNo() != oldFeed.getWriter().getNo()) {
      redirectAttrs.addFlashAttribute("updateMsg","수정 권한이 없습니다.");

      return "redirect:detail?no=" + post.getNo();
    }

    String uploadDir = sc.getRealPath("/upload");

    ArrayList<AttachedFile> attachedFiles = new ArrayList<>();

    Collection<Part> files = request.getParts();
    for (Part file : files) {
      if (file.getName().equals("files") && file.getSize() > 0) {
        System.out.println(">" + file.getSubmittedFileName());

        // 파일을 선택해서 업로드 했다면,
        String filename = UUID.randomUUID().toString();
        file.write(uploadDir + "/" + filename);

        AttachedFile f = new AttachedFile();
        f.setName(filename);

        attachedFiles.add(f);

        // 썸네일 이미지 생성
        Thumbnails.of(uploadDir + "/" + filename)
        .size(330, 220)
        .outputFormat("jpg")
        .crop(Positions.CENTER)
        .toFiles(new Rename() {
          @Override
          public String apply(String name, ThumbnailParameter param) {
            return name + "_330x220";
          }
        });

        Thumbnails.of(uploadDir + "/" + filename)
        .size(500, 500)
        .outputFormat("jpg")
        .crop(Positions.CENTER)
        .toFiles(new Rename() {
          @Override
          public String apply(String name, ThumbnailParameter param) {
            return name + "_500x500";
          }
        });
      }


    }

    feedService.update(post, attachedFiles);

    return "redirect:detail?no=" + post.getNo();
  }


  @PostMapping("like")
  @ResponseBody
  public String like(int no, HttpSession session)
      throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");
    if (loginUser == null) {
    }

    int isLike = feedService.getLike(no, loginUser.getNo());

    if (isLike == 1) {
      feedService.deleteLike(no, loginUser.getNo());
      return "no";
    } else {
      feedService.addLike(no, loginUser.getNo());
      return "yes";
    }

  }


  @PostMapping("likeCheck")
  @ResponseBody
  public String likeCheck(int no, int lType, HttpSession session)
      throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");

    if (loginUser == null) {
      return "no";
    }

    int isLike = 0;

    if (lType == 1) {
      isLike = feedService.getLike(no, loginUser.getNo());
    } else if (lType == 2) {
      isLike = commentService.getLike(no, loginUser.getNo());
    } else if (lType == 3) {
      isLike = reCommentService.getLike(no, loginUser.getNo());
    }

    if (isLike == 1) {
      return "yes";
    } else {
      return "no";
    }

  }

}
