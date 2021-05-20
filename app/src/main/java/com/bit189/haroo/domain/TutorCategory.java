package com.bit189.haroo.domain;

public class TutorCategory {
  private String narrowCategory;
  private String broadCategory;

  @Override
  public String toString() {
    return "TutorCategory [narrowCategory=" + narrowCategory + ", broadCategory=" + broadCategory
        + "]";
  }

  public String getNarrowCategory() {
    return narrowCategory;
  }
  public void setNarrowCategory(String narrowCategory) {
    this.narrowCategory = narrowCategory;
  }
  public String getBroadCategory() {
    return broadCategory;
  }
  public void setBroadCategory(String broadCategory) {
    this.broadCategory = broadCategory;
  }
}
