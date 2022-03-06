package com.example.demo.dto;

public class Data {
  private int total;
  private HeroeDto[] results;

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public HeroeDto[] getResults() {
    return results;
  }

  public void setResults(HeroeDto[] results) {
    this.results = results;
  }

  @Override
  public String toString() {
    return "Data{" +
        "total=" + total +
        '}';
  }
}
