package com.bit189.haroo.domain;

import java.sql.Date;
import java.util.List;

public class Member {
  private int no;
  private String email;
  private String password;
  private String name;
  private String nickname;
  private String profilePicture;
  private String tel;  
  private int sex;
  private Date birthDate;
  private String zipcode;
  private String address;
  private String detailAddress; 
  private Date registeredDate;
  private int rank;
  private boolean state;
  private List<Tutor> following;
  private List<ServiceInfo> myHaroo;
  private List<Question> myQuestion;
  private List<Review> myReview;

  @Override
  public String toString() {
    return "Member [no=" + no + ", email=" + email + ", name=" + name + ", nickname=" + nickname
        + ", profilePicture=" + profilePicture + ", tel=" + tel + ", sex=" + sex + ", birthDate="
        + birthDate + ", zipcode=" + zipcode + ", address=" + address + ", detailAddress="
        + detailAddress + ", registeredDate=" + registeredDate + ", rank=" + rank + ", state="
        + state + ", following=" + following + ", myHaroo=" + myHaroo + ", myQuestion=" + myQuestion
        + ", myReview=" + myReview + "]";
  }


  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }


  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }


  public String getPassword() {
    return password;
  }


  public void setPassword(String password) {
    this.password = password;
  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public String getNickname() {
    if (nickname == null || nickname.equals("")) {
      return getName();
    }
    return nickname;
  }


  public void setNickname(String nickname) {
    this.nickname = nickname;
  }


  public String getProfilePicture() {
    return profilePicture;
  }


  public void setProfilePicture(String profilePicture) {
    this.profilePicture = profilePicture;
  }


  public String getTel() {
    return tel;
  }


  public void setTel(String tel) {
    this.tel = tel;
  }


  public int getSex() {
    return sex;
  }


  public void setSex(int sex) {
    this.sex = sex;
  }


  public Date getBirthDate() {
    return birthDate;
  }


  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }


  public String getZipcode() {
    return zipcode;
  }


  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }


  public String getAddress() {
    return address;
  }


  public void setAddress(String address) {
    this.address = address;
  }


  public String getDetailAddress() {
    return detailAddress;
  }


  public void setDetailAddress(String detailAddress) {
    this.detailAddress = detailAddress;
  }


  public Date getRegisteredDate() {
    return registeredDate;
  }


  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }


  public int getRank() {
    return rank;
  }


  public void setRank(int rank) {
    this.rank = rank;
  }


  public boolean isState() {
    return state;
  }


  public void setState(boolean state) {
    this.state = state;
  }


  public List<Tutor> getFollowing() {
    return following;
  }


  public void setFollowing(List<Tutor> following) {
    this.following = following;
  }


  public List<ServiceInfo> getMyHaroo() {
    return myHaroo;
  }


  public void setMyHaroo(List<ServiceInfo> myHaroo) {
    this.myHaroo = myHaroo;
  }


  public List<Question> getMyQuestion() {
    return myQuestion;
  }


  public void setMyQuestion(List<Question> myQuestion) {
    this.myQuestion = myQuestion;
  }


  public List<Review> getMyReview() {
    return myReview;
  }


  public void setMyReview(List<Review> myReview) {
    this.myReview = myReview;
  }


  public static String getStatusLabel(int status) {
    switch (status) {
      case 1:
        return "남";
      default:
        return "여";
    }
  }

}
