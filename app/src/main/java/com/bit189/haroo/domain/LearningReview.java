package com.bit189.haroo.domain;

public class LearningReview extends Post {
  private String title;
  private int learningApplyNo;
  private Member writer;
  private ServiceInfo serviceInfo;
  private LearningSchedule schedule;
  private double rate;
  private int recommendCount;

  @Override
  public String toString() {
    return "LearningReview [title=" + title + ", learningApplyNo=" + learningApplyNo + ", writer="
        + writer + ", serviceInfo=" + serviceInfo + ", schedule=" + schedule + ", rate=" + rate
        + ", recommendCount=" + recommendCount + ", getNo()=" + getNo() + ", getContent()="
        + getContent() + ", getWritingDate()=" + getWritingDate() + ", getViewCount()="
        + getViewCount() + ", isState()=" + isState() + ", getAttachedFiles()=" + getAttachedFiles()
        + "]";
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getLearningApplyNo() {
    return learningApplyNo;
  }

  public void setLearningApplyNo(int learningApplyNo) {
    this.learningApplyNo = learningApplyNo;
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

  public LearningSchedule getSchedule() {
    return schedule;
  }

  public void setSchedule(LearningSchedule schedule) {
    this.schedule = schedule;
  }

  public double getRate() {
    return rate;
  }

  public void setRate(double rate) {
    this.rate = rate;
  }

  public int getRecommendCount() {
    return recommendCount;
  }

  public void setRecommendCount(int recommendCount) {
    this.recommendCount = recommendCount;
  }

}