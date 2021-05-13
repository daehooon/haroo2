package com.bit189.haroo.domain;

import java.sql.Date;
import java.util.List;

public class ServiceInfo {
  private int no;
  private String broadCategory;
  private String narrowCategory;
  private String name;
  private String intro;
  private String coverImage;
  private double averageRate;
  private boolean state;
  private Date registeredDate;
  private List<Question> questions;
  private List<Review> reviews;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getBroadCategory() {
    return broadCategory;
  }
  public void setBroadCategory(String broadCategory) {
    this.broadCategory = broadCategory;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getIntro() {
    return intro;
  }
  public void setIntro(String intro) {
    this.intro = intro;
  }
  public String getCoverImage() {
    return coverImage;
  }
  public void setCoverImage(String coverImage) {
    this.coverImage = coverImage;
  }
  public double getAverageRate() {
    return averageRate;
  }
  public void setAverageRate(double averageRate) {
    this.averageRate = averageRate;
  }
  public boolean isState() {
    return state;
  }
  public void setState(boolean state) {
    this.state = state;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public List<Question> getQuestions() {
    return questions;
  }
  public void setQuestions(List<Question> questions) {
    this.questions = questions;
  }
  public List<Review> getReviews() {
    return reviews;
  }
  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }
  public String getNarrowCategory() {
    return narrowCategory;
  }
  public void setNarrowCategory(String narrowCategory) {
    this.narrowCategory = narrowCategory;
  }
}
