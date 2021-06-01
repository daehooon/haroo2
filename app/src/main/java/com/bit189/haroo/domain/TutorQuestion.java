package com.bit189.haroo.domain;

import java.util.Date;

public class TutorQuestion extends Post{
  private Member writer;
  private Member tutorNickname;
  private String title;
  private int secret;
  private String reply;
  private Date replyDate;

  @Override
  public String toString() {
    return "TutorQuestion [writer=" + writer + ", tutorNickname=" + tutorNickname + ", title="
        + title + ", secret=" + secret + ", reply=" + reply + ", replyDate=" + replyDate + "]";
  }
  public Member getWriter() {
    return writer;
  }
  public void setWriter(Member writer) {
    this.writer = writer;
  }
  public Member getTutorNickname() {
    return tutorNickname;
  }
  public void setTutorNickname(Member tutorNickname) {
    this.tutorNickname = tutorNickname;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public int getSecret() {
    return secret;
  }
  public void setSecret(int secret) {
    this.secret = secret;
  }
  public String getReply() {
    return reply;
  }
  public void setReply(String reply) {
    this.reply = reply;
  }
  public Date getReplyDate() {
    return replyDate;
  }
  public void setReplyDate(Date replyDate) {
    this.replyDate = replyDate;
  }



}
