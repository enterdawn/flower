package BI;

import java.util.*;
public interface CustomerService {

  /*  1 查询鲜花
    2 购买鲜花
    3 查看订单
    4 登录
    */
    public boolean login(String username,String possword);
    public List<String> getflower(String flowerid,String name,String color,float lowprice);
    public boolean addorder(String flowerid,int userid,int count);
    public List<String> seeorder(int userid);

}
