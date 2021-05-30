package com.bit189.haroo.domain;

import java.util.Date;

public class Question extends Post {
  private Member writer;
  private ServiceInfo serviceInfo;
  private String title;
  private int secret;
  private String replyContent;
  private Date replyDate;

  @Override
  public String toString() {
    return "Question [writer=" + writer + ", serviceInfo=" + serviceInfo + ", title=" + title
        + ", secret=" + secret + ", replyContent=" + replyContent + ", replyDate=" + replyDate
        + ", getNo()=" + getNo() + ", getContent()=" + getContent() + ", getWritingDate()="
        + getWritingDate() + ", getViewCount()=" + getViewCount() + ", isState()=" + isState()
        + ", getAttachedFiles()=" + getAttachedFiles() + "]";
  }

  public Member getWriter() {
    return writer;
  }

  public void setWriter(Member writer) {
    this.writer = writer;
  }

  public ServiceInfo getServiceInfo() {
    return serviceInfo;
  }

  public void setServiceInfo(ServiceInfo serviceInfo) {
    this.serviceInfo = serviceInfo;
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

  public Date getReplyDate() {
    return replyDate;
  }

  public void setReplyDate(Date replyDate) {
    this.replyDate = replyDate;
  }




}