package com.bit189.haroo.domain;

import java.util.Date;

public class ServiceInfo {
  private int no;
  private int broadCategoryNo;
  private String broadCategory;
  private int narrowCategoryNo;
  private String narrowCategory;
  private String name;
  private String intro;
  private String coverImage;
  private double averageRate;
  private boolean state;
  private Tutor tutor;
  private Date registeredDate;

  @Override
  public String toString() {
    return "ServiceInfo [no=" + no + ", broadCategoryNo=" + broadCategoryNo + ", broadCategory="
        + broadCategory + ", narrowCategoryNo=" + narrowCategoryNo + ", narrowCategory="
        + narrowCategory + ", name=" + name + ", intro=" + intro + ", coverImage=" + coverImage
        + ", averageRate=" + averageRate + ", state=" + state + ", tutor=" + tutor
        + ", registeredDate=" + registeredDate + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getBroadCategoryNo() {
    return broadCategoryNo;
  }
  public void setBroadCategoryNo(int broadCategoryNo) {
    this.broadCategoryNo = broadCategoryNo;
  }
  public String getBroadCategory() {
    return broadCategory;
  }
  public void setBroadCategory(String broadCategory) {
    this.broadCategory = broadCategory;
  }
  public int getNarrowCategoryNo() {
    return narrowCategoryNo;
  }
  public void setNarrowCategoryNo(int narrowCategoryNo) {
    this.narrowCategoryNo = narrowCategoryNo;
  }
  public String getNarrowCategory() {
    return narrowCategory;
  }
  public void setNarrowCategory(String narrowCategory) {
    this.narrowCategory = narrowCategory;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getIntro() {
    return intro;
  }
  public void setIntro(String intro) {
    this.intro = intro;
  }
  public String getCoverImage() {
    return coverImage;
  }
  public void setCoverImage(String coverImage) {
    this.coverImage = coverImage;
  }
  public double getAverageRate() {
    return averageRate;
  }
  public void setAverageRate(double averageRate) {
    this.averageRate = averageRate;
  }
  public boolean isState() {
    return state;
  }
  public void setState(boolean state) {
    this.state = state;
  }
  public Tutor getTutor() {
    return tutor;
  }
  public void setTutor(Tutor tutor) {
    this.tutor = tutor;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
}
