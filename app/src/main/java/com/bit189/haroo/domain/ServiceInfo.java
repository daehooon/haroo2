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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(averageRate);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + ((broadCategory == null) ? 0 : broadCategory.hashCode());
    result = prime * result + ((coverImage == null) ? 0 : coverImage.hashCode());
    result = prime * result + ((intro == null) ? 0 : intro.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((narrowCategory == null) ? 0 : narrowCategory.hashCode());
    result = prime * result + no;
    result = prime * result + ((questions == null) ? 0 : questions.hashCode());
    result = prime * result + ((registeredDate == null) ? 0 : registeredDate.hashCode());
    result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
    result = prime * result + (state ? 1231 : 1237);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ServiceInfo other = (ServiceInfo) obj;
    if (Double.doubleToLongBits(averageRate) != Double.doubleToLongBits(other.averageRate))
      return false;
    if (no != other.no)
      return false;
    return true;
  }

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
