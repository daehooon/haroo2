package com.bit189.haroo.domain;

import java.sql.Date;
import java.sql.Time;

public class LearningSchedule {
  private int no;
  private int learningNo;
  private Date learningDate;
  private Time startTime;
  private Time endTime;

  @Override
  public String toString() {
    return "LearningSchedule [no=" + no + ", learningNo=" + learningNo + ", LearningDate="
        + learningDate + ", startTime=" + startTime + ", endTime=" + endTime + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public int getLearningNo() {
    return learningNo;
  }

  public void setLearningNo(int learningNo) {
    this.learningNo = learningNo;
  }

  public Date getLearningDate() {
    return learningDate;
  }

  public void setLearningDate(Date learningDate) {
    this.learningDate = learningDate;
  }

  public Time getStartTime() {
    return startTime;
  }

  public void setStartTime(Time startTime) {
    this.startTime = startTime;
  }

  public Time getEndTime() {
    return endTime;
  }

  public void setEndTime(Time endTime) {
    this.endTime = endTime;
  }
}

