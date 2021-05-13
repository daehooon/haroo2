package com.bit189.haroo.domain;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

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
  private String detailAddress; // 오타나서 바꿈
  private Date registeredDate;
  private Time registeredTime;
  private String rank;
  private boolean state;
  private ArrayList<Tutor> following;
  private ArrayList<ServiceInfo> myHaroo;
  private ArrayList<ServiceInfo> wishlist;
  private ArrayList<ServiceInfo> myBasket;
  private ArrayList<Question> myQuestion;
  private ArrayList<Review> myReview;

  @Override
  public String toString() {
    return "no=" + no + ", email=" + email + ", name=" + name + ", nickname=" + nickname
        + ", profilePicture=" + profilePicture + ", tel=" + tel + ", sex=" + sex + ", birthDate="
        + birthDate + ", zipcode=" + zipcode + ", address=" + address + ", detatilAddress="
        + detailAddress + ", registeredDate=" + registeredDate + ", registeredTime="
        + registeredTime + ", rank=" + rank + ", state=" + state + ", following=" + following
        + ", myHaroo=" + myHaroo + ", wishlist=" + wishlist + ", myBasket=" + myBasket
        + ", myQuestion=" + myQuestion + ", myReview=" + myReview;
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
  public Time getRegisteredTime() {
    return registeredTime;
  }
  public void setRegisteredTime(Time registeredTime) {
    this.registeredTime = registeredTime;
  }
  public String getRank() {
    return rank;
  }
  public void setRank(String rank) {
    this.rank = rank;
  }
  public boolean isState() {
    return state;
  }
  public void setState(boolean state) {
    this.state = state;
  }
  public ArrayList<Tutor> getFollowing() {
    return following;
  }
  public void setFollowing(ArrayList<Tutor> following) {
    this.following = following;
  }
  public ArrayList<ServiceInfo> getMyHaroo() {
    return myHaroo;
  }
  public void setMyHaroo(ArrayList<ServiceInfo> myHaroo) {
    this.myHaroo = myHaroo;
  }
  public ArrayList<ServiceInfo> getWishlist() {
    return wishlist;
  }
  public void setWishlist(ArrayList<ServiceInfo> wishlist) {
    this.wishlist = wishlist;
  }
  public ArrayList<ServiceInfo> getMyBasket() {
    return myBasket;
  }
  public void setMyBasket(ArrayList<ServiceInfo> myBasket) {
    this.myBasket = myBasket;
  }
  public ArrayList<Question> getMyQuestion() {
    return myQuestion;
  }
  public void setMyQuestion(ArrayList<Question> myQuestion) {
    this.myQuestion = myQuestion;
  }
  public ArrayList<Review> getMyReview() {
    return myReview;
  }
  public void setMyReview(ArrayList<Review> myReview) {
    this.myReview = myReview;
  }
}

