package com.bit189.haroo.domain;

public class TutorDistrict {
  private String sido;
  private String sigungu;

  @Override
  public String toString() {
    return "TutorDistrict [sido=" + sido + ", sigungu=" + sigungu + "]";
  }

  public String getSido() {
    return sido;
  }
  public void setSido(String sido) {
    this.sido = sido;
  }
  public String getSigungu() {
    return sigungu;
  }
  public void setSigungu(String sigungu) {
    this.sigungu = sigungu;
  }
}
