package com.bit189.haroo.domain;

import java.util.Date;
import java.util.List;

public class LearningApplication {
  private int no;
  private Member writer;
  private List<LearningSchedule> schedules;
  private Date registeredDate;
  private int applySize;
  private int scheduleNo;
  private int learningNo;

  @Override
  public String toString() {
    return "LearningApplication [no=" + no + ", writer=" + writer + ", schedules=" + schedules
        + ", registeredDate=" + registeredDate + ", applySize=" + applySize + ", scheduleNo="
        + scheduleNo + ", learningNo=" + learningNo + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public Member getWriter() {
    return writer;
  }
  public void setWriter(Member writer) {
    this.writer = writer;
  }
  public List<LearningSchedule> getSchedules() {
    return schedules;
  }
  public void setSchedules(List<LearningSchedule> schedules) {
    this.schedules = schedules;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public int getApplySize() {
    return applySize;
  }
  public void setApplySize(int applySize) {
    this.applySize = applySize;
  }
  public int getScheduleNo() {
    return scheduleNo;
  }
  public void setScheduleNo(int scheduleNo) {
    this.scheduleNo = scheduleNo;
  }
  public int getLearningNo() {
    return learningNo;
  }
  public void setLearningNo(int learningNo) {
    this.learningNo = learningNo;
  }
}
