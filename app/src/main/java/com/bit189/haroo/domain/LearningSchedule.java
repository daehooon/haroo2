package com.bit189.haroo.domain;

import java.sql.Date;
import java.sql.Time;

public class LearningSchedule {
  private int no;
  private Date LearningDate;
  private Time startTime;
  private Time endTime;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public Date getLearningDate() {
    return LearningDate;
  }
  public void setLearningDate(Date learningDate) {
    LearningDate = learningDate;
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
