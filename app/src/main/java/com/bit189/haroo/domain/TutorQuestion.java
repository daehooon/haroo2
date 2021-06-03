package com.bit189.haroo.domain;

import java.util.Date;
import java.util.List;

public class TutorQuestion extends Post{
  private Member writer;
  private Member tutor;
  private String title;
  private int secret;
  private String replyContent;
  private String reply;
  private Date replyDate;
  private List<AttachedFile> replyAttachedFiles;

  @Override
  public String toString() {
    return "TutorQuestion [writer=" + writer + ", tutor=" + tutor + ", title=" + title + ", secret="
        + secret + ", replyContent=" + replyContent + ", reply=" + reply + ", replyDate="
        + replyDate + ", replyAttachedFiles=" + replyAttachedFiles + "]";
  }

  public Member getWriter() {
    return writer;
  }

  public void setWriter(Member writer) {
    this.writer = writer;
  }

  public Member getTutor() {
    return tutor;
  }

  public void setTutor(Member tutor) {
    this.tutor = tutor;
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

  public String getReplyContent() {
    return replyContent;
  }

  public void setReplyContent(String replyContent) {
    this.replyContent = replyContent;
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

  public List<AttachedFile> getReplyAttachedFiles() {
    return replyAttachedFiles;
  }

  public void setReplyAttachedFiles(List<AttachedFile> replyAttachedFiles) {
    this.replyAttachedFiles = replyAttachedFiles;
  }




}
