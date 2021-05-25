package com.bit189.haroo.domain;

import java.util.Date;
import java.util.List;

public class Comment {
  private int no;
  private int feedNo;
  private String content;
  private boolean state;
  private Date registeredDate;
  private Member writer;
  private List<ReComment> reComments;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getFeedNo() {
    return feedNo;
  }
  public void setFeedNo(int feedNo) {
    this.feedNo = feedNo;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public boolean isState() {
    return state;
  }
  public void setState(boolean state) {
    this.state = state;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public Member getWriter() {
    return writer;
  }
  public void setWriter(Member writer) {
    this.writer = writer;
  }
  public List<ReComment> getReComments() {
    return reComments;
  }
  public void setReComments(List<ReComment> reComments) {
    this.reComments = reComments;
  }




}