package com.bit189.haroo.domain;

import java.sql.Date;
import java.util.List;

public class Question extends Post {
  private Member writer;
  private List<ServiceInfo> serviceNo;
  private String title;
  private boolean secret;
  private String replyContent;
  private Date replyDate;
  private List<String> replyAttachedFile;

  @Override
  public String toString() {
    return "Question [writer=" + writer + ", serviceNo=" + serviceNo + ", title=" + title
        + ", secret=" + secret + ", replyContent=" + replyContent + ", replyDate=" + replyDate
        + ", replyAttachedFile=" + replyAttachedFile + ", toString()=" + super.toString()
        + ", getNo()=" + getNo() + ", getContent()=" + getContent() + ", getWritingDate()="
        + getWritingDate() + ", getViewCount()=" + getViewCount() + ", isState()=" + isState()
        + ", getAttachedFiles()=" + getAttachedFiles() + ", getClass()=" + getClass()
        + ", hashCode()=" + hashCode() + "]";
  }

  public Member getWriter() {
    return writer;
  }

  public void setWriter(Member writer) {
    this.writer = writer;
  }

  public List<ServiceInfo> getServiceNo() {
    return serviceNo;
  }

  public void setServiceNo(List<ServiceInfo> serviceNo) {
    this.serviceNo = serviceNo;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isSecret() {
    return secret;
  }

  public void setSecret(boolean secret) {
    this.secret = secret;
  }

  public String getReplyContent() {
    return replyContent;
  }

  public void setReplyContent(String replyContent) {
    this.replyContent = replyContent;
  }

  public Date getReplyDate() {
    return replyDate;
  }

  public void setReplyDate(Date replyDate) {
    this.replyDate = replyDate;
  }

  public List<String> getReplyAttachedFile() {
    return replyAttachedFile;
  }

  public void setReplyAttachedFile(List<String> replyAttachedFile) {
    this.replyAttachedFile = replyAttachedFile;
  }






}