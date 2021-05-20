package com.bit189.haroo.domain;

public class NarrowCategory {
  int no;
  String name;
  int broadCategoryNo;

  @Override
  public String toString() {
    return "NarrowCategory [no=" + no + ", name=" + name + ", broadCategoryNo=" + broadCategoryNo
        + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getBroadCategoryNo() {
    return broadCategoryNo;
  }
  public void setBroadCategoryNo(int broadCategoryNo) {
    this.broadCategoryNo = broadCategoryNo;
  }
}