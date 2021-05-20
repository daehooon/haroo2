package com.bit189.haroo.domain;

import java.util.List;

public class Product extends ServiceInfo {
  private int price;
  private String deliveryInfo;
  private String refundInfo;
  private int totalSoldCount;
  private List<AttachedFile> productPicture;
  private List<ProductOption> productOption;

  @Override
  public String toString() {
    return "Product [price=" + price + ", deliveryInfo=" + deliveryInfo + ", refundInfo="
        + refundInfo + ", totalSoldCount=" + totalSoldCount + ", productPicture=" + productPicture
        + ", productOption=" + productOption + ", getNo()=" + getNo() + ", getBroadCategory()="
        + getBroadCategory() + ", getNarrowCategory()=" + getNarrowCategory() + ", getName()="
        + getName() + ", getIntro()=" + getIntro() + ", getCoverImage()=" + getCoverImage()
        + ", getAverageRate()=" + getAverageRate() + ", isState()=" + isState() + ", getTutor()="
        + getTutor() + ", getRegisteredDate()=" + getRegisteredDate() + ", getQuestions()="
        + getQuestions() + ", getReviews()=" + getReviews() + "]";
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getDeliveryInfo() {
    return deliveryInfo;
  }

  public void setDeliveryInfo(String deliveryInfo) {
    this.deliveryInfo = deliveryInfo;
  }

  public String getRefundInfo() {
    return refundInfo;
  }

  public void setRefundInfo(String refundInfo) {
    this.refundInfo = refundInfo;
  }

  public int getTotalSoldCount() {
    return totalSoldCount;
  }

  public void setTotalSoldCount(int totalSoldCount) {
    this.totalSoldCount = totalSoldCount;
  }

  public List<AttachedFile> getProductPicture() {
    return productPicture;
  }

  public void setProductPicture(List<AttachedFile> productPicture) {
    this.productPicture = productPicture;
  }

  public List<ProductOption> getProductOption() {
    return productOption;
  }

  public void setProductOption(List<ProductOption> productOption) {
    this.productOption = productOption;
  }

}