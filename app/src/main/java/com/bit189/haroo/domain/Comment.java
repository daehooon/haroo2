package com.bit189.haroo.domain;

import java.sql.Date;
import java.sql.Time;

public class Comment {
  private int no;
  private int feedNo;
  private Member writer;
  private String content;
  private boolean state;
  private Date registeredDate;
  private Time registeredTime;
}
