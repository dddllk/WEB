package com.bjpowernode.entity;

/**
 * Created by dlkyy on 2021/2/15 13:04
 */
public class Student {
  private String name;
  private Integer id;

  public Student() {
  }

  public Student(String name) {
    this.name = name;
  }

  public Student(Integer id) {
    this.id = id;
  }

  public Student(String name, Integer id) {
    this.name = name;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
