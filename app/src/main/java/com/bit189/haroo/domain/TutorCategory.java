package com.bit189.haroo.domain;

public class TutorCategory {
  private int tno;
  private String narrowCategory;
  private String broadCategory;
  private int narrowCategoryNo;
  private int broadCategoryNo;

  @Override
  public String toString() {
    return "TutorCategory [tno=" + tno + ", narrowCategory=" + narrowCategory + ", broadCategory="
        + broadCategory + ", narrowCategoryNo=" + narrowCategoryNo + ", broadCategoryNo="
        + broadCategoryNo + "]";
  }

  public int getTno() {
    return tno;
  }
  public void setTno(int tno) {
    this.tno = tno;
  }
  public String getNarrowCategory() {
    return narrowCategory;
  }
  public void setNarrowCategory(String narrowCategory) {
    this.narrowCategory = narrowCategory;
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
  public int getBroadCategoryNo() {
    return broadCategoryNo;
  }
  public void setBroadCategoryNo(int broadCategoryNo) {
    this.broadCategoryNo = broadCategoryNo;
  }

}
