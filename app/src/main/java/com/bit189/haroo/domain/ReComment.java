package com.bit189.haroo.domain;

import java.util.Date;

public class ReComment {
  private int no;
  private int commentNo;
  private Member reWriter;
  private String content;
  private Date registeredDate;
  private Member taggedMember;
  private boolean state;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getCommentNo() {
    return commentNo;
  }
  public void setCommentNo(int commentNo) {
    this.commentNo = commentNo;
  }
  public Member getReWriter() {
    return reWriter;
  }
  public void setReWriter(Member reWriter) {
    this.reWriter = reWriter;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public Member getTaggedMember() {
    return taggedMember;
  }
  public void setTaggedMember(Member taggedMember) {
    this.taggedMember = taggedMember;
  }
  public boolean isState() {
    return state;
  }
  public void setState(boolean state) {
    this.state = state;
  }


}
