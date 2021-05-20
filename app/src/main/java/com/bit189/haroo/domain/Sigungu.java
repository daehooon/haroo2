package com.bit189.haroo.domain;

public class Sigungu {
  int no;
  int sidoNo;
  String name;

  @Override
  public String toString() {
    return "Sigungu [no=" + no + ", sidoNo=" + sidoNo + ", name=" + name + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getSidoNo() {
    return sidoNo;
  }
  public void setSidoNo(int sidoNo) {
    this.sidoNo = sidoNo;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
}