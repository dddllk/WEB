package com.bjpowernode.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * Created by dlkyy on 2021/2/13 20:47
 */
public class ServletListener implements ServletContextAttributeListener {
  @Override
  public void attributeAdded(ServletContextAttributeEvent scae) {
    System.out.println("添加共享数据！");
  }

  @Override
  public void attributeRemoved(ServletContextAttributeEvent scae) {
    System.out.println("删除共享数据！");
  }

  @Override
  public void attributeReplaced(ServletContextAttributeEvent scae) {
    System.out.println("更新共享数据！");
  }
}
