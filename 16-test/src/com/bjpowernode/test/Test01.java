package com.bjpowernode.test;

/**
 * Created by dlkyy on 2021/2/13 23:19
 */
public class Test01 {
  public void run(){
    System.out.println("run...");
  }
  public void run(String name) {
    System.out.println(name + "，run..." );
  }
  public void run(String name, int age){
    System.out.println(name + "," + age + "岁了，还在run...");
  }
  public void run(int age, String name){
    System.out.println(name + "，今年" + age + "岁");
  }
}
