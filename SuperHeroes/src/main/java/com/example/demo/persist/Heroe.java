package com.example.demo.persist;

import javax.persistence.*;

@Entity
@Table(name="Heroe")
public class Heroe {
  @Id
  @Column(name = "ID")
  private int ID;

  @Column(name="LIKES")
  private int LIKES;

  public Heroe(int LIKES) {
    this.LIKES = LIKES;
  }

  public Heroe(int ID, int LIKES) {
    this.LIKES = LIKES;
    this.ID = ID;
  }

  public Heroe() {

  }

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public int getLIKES() {
    return LIKES;
  }

  public void setLIKES(int LIKES) {
    this.LIKES = LIKES;
  }
}
