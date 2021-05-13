package com.bit189.haroo.domain;

public class Feed extends Post{
  private Tutor writer;

  public Tutor getWriter() {
    return writer;
  }

  public void setWriter(Tutor writer) {
    this.writer = writer;
  }


}