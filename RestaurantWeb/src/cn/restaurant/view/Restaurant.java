package cn.restaurant.view;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.restaurant.dao.WaiterDao;
import cn.restaurant.dao.impl.BusinessDaoImpl;
import cn.restaurant.dao.impl.FoodDaoImpl;
import cn.restaurant.dao.impl.WaiterDaoImpl;
import cn.restaurant.entity.Food;
import cn.restaurant.entity.Waiter;

public class Restaurant {
	private static void countSubString(){  
        String string1="f1,f2";  
        String string2="f1,f2";  
        String string3="f1,f2";  
        StringBuffer stringBuffer=new StringBuffer();  
        stringBuffer.append(string1).append(",").append(string2).append(",").append(string3).append(",");  
        String totalString=stringBuffer.toString();  
        System.out.println("组拼后的字符串为:"+totalString);  
          
        while (totalString.length()>0) {  
            //得到第一个字符串比如"香蕉、"  
            int index=totalString.indexOf(",");  
            String foodName=totalString.substring(0,index+1);  
              if(foodName.length()>0)
              {
            	  Pattern pattern = Pattern.compile(foodName);    
                  Matcher matcher = pattern.matcher(totalString);    
                  int count=0;  
                  while(matcher.find()){  
                      count++;  
                  }  
                  totalString= totalString.replaceAll(foodName, "");  
                  System.out.println("食品名字为:"+foodName+",出现次数为:"+count);  
                  System.out.println("统计删除后字符串为:totalString="+totalString);  
                  System.out.println("===============================");  
              }
           
        }  
    } 
public static void main(String[] args) {
	countSubString();
}
}
