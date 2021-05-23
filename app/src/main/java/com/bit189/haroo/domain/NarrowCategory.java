package com.bit189.haroo.domain;

public class NarrowCategory {
  int no;
  String name;
  BroadCategory broadCategory;

  @Override
  public String toString() {
    return "NarrowCategory [no=" + no + ", name=" + name + ", broadCategory=" + broadCategory + "]";
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
  public BroadCategory getBroadCategory() {
    return broadCategory;
  }
  public void setBroadCategory(BroadCategory broadCategory) {
    this.broadCategory = broadCategory;
  }
}