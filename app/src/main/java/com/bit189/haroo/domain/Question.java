package com.bit189.haroo.domain;

import java.sql.Date;
import java.util.List;

public class Question extends Post {
  private Member writer;
  private String title;
  private boolean secret;
  private String replyContent;
  private Date replyDate;
  private List<String> replyAttachedFile;

  // 미완성
}