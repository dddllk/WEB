package com.bjpowernode.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by dlkyy on 2021/2/13 20:23
 */
public class OneListener implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("恭喜恭喜，来世走一趟！");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("兄弟不要怕！你二十年后又是一条好汉！");
  }
}
