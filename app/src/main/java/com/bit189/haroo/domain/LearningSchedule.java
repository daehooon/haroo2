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
    return "LearningSchedule [no=" + no + ", learningNo=" + learningNo + ", learningDate="
        + learningDate + ", startTime=" + startTime + ", endTime=" + endTime + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((learningDate == null) ? 0 : learningDate.hashCode());
    result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
    result = prime * result + learningNo;
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
  public int getLearningNo() {
    return learningNo;
  }
  public void setLearningNo(int learningNo) {
    this.learningNo = learningNo;
  }
  public Date getlearningDate() {
    return learningDate;
  }
  public void setlearningDate(Date learningDate) {
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
