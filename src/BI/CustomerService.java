package BI;

import ent.customerent;
import ent.flower;
import ent.flowerstore;
import ent.orders;

import java.util.*;
public interface CustomerService {

  /*  1 查询鲜花
    2 购买鲜花
    3 查看订单
    4 登录
    */
    public customerent login(String username, String possword);
    public ArrayList<flowerstore> getstorelist();
    public ArrayList<flower> getflower(int storeid);
    public boolean change(customerent User);
    public ArrayList<orders> seeorder(int userid);
    public String getstorename(int storeid);
    public flower getflowerinfo(int flowerid);
    public boolean addorder(int storeid, int flowerid, int customerid, int cnt, float price);

}
