package com.bit189.haroo.domain;

import java.sql.Date;
import java.sql.Time;

public class ReComment {
  private int no;
  private int commentNo;
  private Member writer;
  private String content;
  private Date registeredDate;
  private Time registeredTime;
  private Member taggedMember;
  private boolean state;
}
