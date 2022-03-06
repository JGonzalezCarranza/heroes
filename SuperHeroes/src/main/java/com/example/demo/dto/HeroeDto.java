package com.example.demo.dto;

import java.util.List;

public class HeroeDto {
  private String id;
  private String name;
  private String description;
  private ComicsDto comics;

  public ComicsDto getComics() {
    return comics;
  }

  public void setComics(ComicsDto comics) {
    this.comics = comics;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
