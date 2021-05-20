package com.bit189.haroo.domain;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class LearningApplication {
  private int no;
  private Member memberNo;
  private List<LearningSchedule> schedules;
  private Date registeredDate;
  private int applySize;

  public String getRegisteredDate2() {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(registeredDate);
  }

  @Override
  public String toString() {
    return "LearningApplication [no=" + no + ", memberNo=" + memberNo + ", schedules=" + schedules
        + ", registeredDate=" + registeredDate + ", applySize=" + applySize + ", getClass()="
        + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public Member getMemberNo() {
    return memberNo;
  }

  public void setMemberNo(Member memberNo) {
    this.memberNo = memberNo;
  }

  public List<LearningSchedule> getSchedules() {
    return schedules;
  }

  public void setSchedules(List<LearningSchedule> schedules) {
    this.schedules = schedules;
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
}
