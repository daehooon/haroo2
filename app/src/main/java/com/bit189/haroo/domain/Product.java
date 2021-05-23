package com.bit189.haroo.domain;

import java.util.List;

public class Product extends ServiceInfo {
  private int price;
  private String deliveryInfo;
  private String refundInfo;
  private int totalSoldCount;
  private List<AttachedFile> productPicture;
  private List<ProductOption> productOption;



}