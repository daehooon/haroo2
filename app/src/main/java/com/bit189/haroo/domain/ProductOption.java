package com.bit189.haroo.domain;

public class ProductOption {
  private int no;
  private String name;
  private int price;
  private int stockSize;
  private int soldCountPerOption;

  @Override
  public String toString() {
    return "ProductOption [no=" + no + ", name=" + name + ", price=" + price + ", stockSize="
        + stockSize + ", soldCountPerOption=" + soldCountPerOption + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getStockSize() {
    return stockSize;
  }

  public void setStockSize(int stockSize) {
    this.stockSize = stockSize;
  }

  public int getSoldCountPerOption() {
    return soldCountPerOption;
  }

  public void setSoldCountPerOption(int soldCountPerOption) {
    this.soldCountPerOption = soldCountPerOption;
  }

}