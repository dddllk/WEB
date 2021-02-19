package com.bjpowernode.entity;

/**
 * Created by dlkyy on 2021/2/19 13:26
 */
public class Student {
  private String id;
  private String sname;

  public Student() {
  }

  public Student(String id, String sname) {
    this.id = id;
    this.sname = sname;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSname() {
    return sname;
  }

  public void setSname(String sname) {
    this.sname = sname;
  }
}
