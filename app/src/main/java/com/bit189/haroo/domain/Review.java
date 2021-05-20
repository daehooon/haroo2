package com.bit189.haroo.domain;

public class Review extends Post {
  private String title;
  private Member writer;
  private ServiceInfo serviceInfo;
  private int recommendCount;
  private double rate;

  @Override
  public String toString() {
    return "Review [title=" + title + ", writer=" + writer + ", serviceInfo=" + serviceInfo
        + ", recommendCount=" + recommendCount + ", rate=" + rate + ", getNo()=" + getNo()
        + ", getContent()=" + getContent() + ", getWritingDate()=" + getWritingDate()
        + ", getViewCount()=" + getViewCount() + ", isState()=" + isState()
        + ", getAttachedFiles()=" + getAttachedFiles() + "]";
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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

  public int getRecommendCount() {
    return recommendCount;
  }

  public void setRecommendCount(int recommendCount) {
    this.recommendCount = recommendCount;
  }

  public double getRate() {
    return rate;
  }

  public void setRate(double rate) {
    this.rate = rate;
  }

}