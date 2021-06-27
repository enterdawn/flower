package BI;
import ent.customerent;
import ent.flower;
import ent.flowerstore;
import ent.orders;

import java.util.*;
public interface FlowerStoreService {
    /*
    1 销售鲜花
    2 培育新品种鲜花
    3 查看库存
    4 查看订单
    5 查看销售情况
    6 登录
    7 入库
    8 出库
     */
    //public boolean addorder(int flowerid,int userid,int count);
    public flowerstore login(String username, String password);
    public boolean chaflower(flower d);
    public boolean addflower(String name,String color,float price,int storeid);
    public ArrayList<flower> getflower(int storeid);
    public ArrayList<orders> getorder(int storeid);
    public int getflowersaledd(int flowerid);
    public boolean inflower(int flowerid,int count);
    public boolean outflower(orders o);
    public customerent getuserinfo(int userid);
    public boolean setinfo(flowerstore store);
}
