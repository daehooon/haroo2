package com.bit189.haroo.domain;

public class Sigungu {
  int no;
  String name;
  Sido sido;

  @Override
  public String toString() {
    return "Sigungu [no=" + no + ", name=" + name + ", sido=" + sido + "]";
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
  public Sido getSido() {
    return sido;
  }
  public void setSido(Sido sido) {
    this.sido = sido;
  }
}