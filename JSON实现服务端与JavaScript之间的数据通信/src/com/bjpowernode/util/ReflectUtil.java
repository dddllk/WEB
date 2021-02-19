package com.bjpowernode.util;

import java.lang.reflect.Field;
/**
 * Created by dlkyy on 2021/2/19 13:59
 */
public class ReflectUtil {
  //作用：将任意类型对象内容转换成JSON格式字符串返回
  //参数：一个高级引用类型对象Student对象
  public static String jsonObject(Object o) {
    Class classFile = null;
    Field filedArray[] = null;
    StringBuffer sb = new StringBuffer("{");
    //1.获得当前对象隶属的类文件【class文件】
    classFile = o.getClass(); // Student.class
    //2.获得【class文件】所有属性
    filedArray = classFile.getDeclaredFields();
    //3.获得当前对象所有的属性
    try {
      for(int i = 0; i < filedArray.length; i++){
        Field f = filedArray[i];
        f.setAccessible(true); //确保私有访问权限属性可以在class外部文件使用
        String filedName = f.getName(); // 获得属性名称
        Object value = f.get(o);
        //4.将获得属性及其值拼接为JSON格式字符串
        sb.append("\"");
        sb.append(filedName);
        sb.append("\" : ");
        sb.append("\"");
        sb.append(value);
        sb.append("\"");
        if(i < filedArray.length - 1){
          sb.append(",");
        }
      }
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }finally {
      sb.append("}");
    }
    return sb.toString();
  }
}
