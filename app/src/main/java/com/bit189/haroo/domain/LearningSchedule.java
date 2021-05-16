package com.bit189.haroo.domain;

import java.sql.Date;
import java.sql.Time;

public class LearningSchedule {
  private int no;
  private Date LearningDate;
  private Time startTime;
  private Time endTime;

  @Override
  public String toString() {
    return "LearningSchedule [no=" + no + ", LearningDate=" + LearningDate + ", startTime="
        + startTime + ", endTime=" + endTime + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((LearningDate == null) ? 0 : LearningDate.hashCode());
    result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
    result = prime * result + no;
    result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    LearningSchedule other = (LearningSchedule) obj;
    if (no != other.no)
      return false;
    return true;
  }

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
