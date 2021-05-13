package com.bit189.haroo.domain;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Tutor extends Member {
  private String intro;
  private String application;
  private Date promotedDate;
  private Time promotedTime;
  private ArrayList<Learning> learnings;
  private ArrayList<Product> products;
  private ArrayList<Sigungu> tutorDistricts;
  private ArrayList<NarrowCategory> tutorCategories;
  private ArrayList<Question> tutorQuestions;
  private ArrayList<Feed> feeds;

  public String getIntro() {
    return intro;
  }
  public void setIntro(String intro) {
    this.intro = intro;
  }
  public String getApplication() {
    return application;
  }
  public void setApplication(String application) {
    this.application = application;
  }
  public Date getPromotedDate() {
    return promotedDate;
  }
  public void setPromotedDate(Date promotedDate) {
    this.promotedDate = promotedDate;
  }
  public Time getPromotedTime() {
    return promotedTime;
  }
  public void setPromotedTime(Time promotedTime) {
    this.promotedTime = promotedTime;
  }
  public ArrayList<Learning> getLearnings() {
    return learnings;
  }
  public void setLearnings(ArrayList<Learning> learnings) {
    this.learnings = learnings;
  }
  public ArrayList<Product> getProducts() {
    return products;
  }
  public void setProducts(ArrayList<Product> products) {
    this.products = products;
  }
  public ArrayList<Sigungu> getTutorDistricts() {
    return tutorDistricts;
  }
  public void setTutorDistricts(ArrayList<Sigungu> tutorDistricts) {
    this.tutorDistricts = tutorDistricts;
  }
  public ArrayList<NarrowCategory> getTutorCategories() {
    return tutorCategories;
  }
  public void setTutorCategories(ArrayList<NarrowCategory> tutorCategories) {
    this.tutorCategories = tutorCategories;
  }
  public ArrayList<Question> getTutorQuestions() {
    return tutorQuestions;
  }
  public void setTutorQuestions(ArrayList<Question> tutorQuestions) {
    this.tutorQuestions = tutorQuestions;
  }
  public ArrayList<Feed> getFeeds() {
    return feeds;
  }
  public void setFeeds(ArrayList<Feed> feeds) {
    this.feeds = feeds;
  }
}
