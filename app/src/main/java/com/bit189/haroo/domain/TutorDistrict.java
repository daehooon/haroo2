package com.bit189.haroo.domain;

public class TutorDistrict {
  private int tno;
  private String sido;
  private String sigungu;
  private int sigunguNo;
  private int sidoNo;

  @Override
  public String toString() {
    return "TutorDistrict [tno=" + tno + ", sido=" + sido + ", sigungu=" + sigungu + ", sigunguNo="
        + sigunguNo + ", sidoNo=" + sidoNo + "]";
  }
  public int getTno() {
    return tno;
  }
  public void setTno(int tno) {
    this.tno = tno;
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
  public int getSigunguNo() {
    return sigunguNo;
  }
  public void setSigunguNo(int sigunguNo) {
    this.sigunguNo = sigunguNo;
  }
  public int getSidoNo() {
    return sidoNo;
  }
  public void setSidoNo(int sidoNo) {
    this.sidoNo = sidoNo;
  }


}
