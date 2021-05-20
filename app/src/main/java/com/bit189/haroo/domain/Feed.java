package com.bit189.haroo.domain;

public class Feed extends Post{
  private Tutor writer;
  private int likeCount;
  private int commentCount;

  public Tutor getWriter() {
    return writer;
  }

  public void setWriter(Tutor writer) {
    this.writer = writer;
  }

  public int getLikeCount() {
    return likeCount;
  }

  public void setLikeCount(int likeCount) {
    this.likeCount = likeCount;
  }

  public int getCommentCount() {
    return commentCount;
  }

  public void setCommentCount(int commentCount) {
    this.commentCount = commentCount;
  }

}