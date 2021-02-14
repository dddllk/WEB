package com.bjpowernode.test;

/**
 * Created by dlkyy on 2021/2/13 23:23
 */
public class TestMain {
  public static void main(String[] args) {
    Test01 t = new Test01();
    t.run();
    t.run("dlkyy");
    t.run(16, "dlkyy");
    t.run("dlkyy",16);
  }
}
