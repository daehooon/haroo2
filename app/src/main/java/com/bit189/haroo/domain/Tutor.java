package com.bit189.haroo.domain;

import java.sql.Date;
import java.util.List;

public class Tutor extends Member {
  private String intro;
  private String application;
  private Date promotedDate;
  private List<TutorDistrict> tutorDistricts;
  private List<TutorCategory> tutorCategories;

  @Override
  public String toString() {
    return "Tutor [intro=" + intro + ", application=" + application + ", promotedDate="
        + promotedDate + ", tutorDistricts=" + tutorDistricts + ", tutorCategories="
        + tutorCategories + "]";
  }
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
  public List<TutorDistrict> getTutorDistricts() {
    return tutorDistricts;
  }
  public void setTutorDistricts(List<TutorDistrict> tutorDistricts) {
    this.tutorDistricts = tutorDistricts;
  }
  public List<TutorCategory> getTutorCategories() {
    return tutorCategories;
  }
  public void setTutorCategories(List<TutorCategory> tutorCategories) {
    this.tutorCategories = tutorCategories;
  }

}
