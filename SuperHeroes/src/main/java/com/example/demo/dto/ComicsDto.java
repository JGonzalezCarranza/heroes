package com.example.demo.dto;

import java.util.List;

public class ComicsDto {

  private ComicItemDto[] items;
  private String available;


  public ComicItemDto[] getItems() {
    return items;
  }

  public void setItems(ComicItemDto[] items) {
    this.items = items;
  }


  public String getAvailable() {
    return available;
  }

  public void setAvailable(String available) {
    this.available = available;
  }




}
