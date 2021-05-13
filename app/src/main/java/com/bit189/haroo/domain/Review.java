package com.bit189.haroo.domain;

// member => 이름이랑 닉네임 조인

public class Review extends Post {
  private String title;
  private Member writer;
  private int recommandCount;
  private double rate;
  private boolean state;
}