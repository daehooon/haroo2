package com.bit189.haroo.domain;

import java.sql.Date;
import java.sql.Time;

public class LearningApplication {
  private int no;
  private int memberNo;
  private int scheduleNo;
  private Date LearningDate;
  private Time LearningTime;
  private int applySize;
  @Override
  public String toString() {
    return "LearningApplication [no=" + no + ", memberNo=" + memberNo + ", scheduleNo=" + scheduleNo
        + ", LearningDate=" + LearningDate + ", LearningTime=" + LearningTime + ", applySize="
        + applySize + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getMemberNo() {
    return memberNo;
  }
  public void setMemberNo(int memberNo) {
    this.memberNo = memberNo;
  }
  public int getScheduleNo() {
    return scheduleNo;
  }
  public void setScheduleNo(int scheduleNo) {
    this.scheduleNo = scheduleNo;
  }
  public Date getLearningDate() {
    return LearningDate;
  }
  public void setLearningDate(Date learningDate) {
    LearningDate = learningDate;
  }
  public Time getLearningTime() {
    return LearningTime;
  }
  public void setLearningTime(Time learningTime) {
    LearningTime = learningTime;
  }
  public int getApplySize() {
    return applySize;
  }
  public void setApplySize(int applySize) {
    this.applySize = applySize;
  }



}
