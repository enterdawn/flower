package BI;
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
    public boolean login(String username,String password);
    public boolean addflower();
    public List<String> getflower(int storeid);
    public List<String> getorder(int storeid);
    public List<String> getsale(int storeid);
    public boolean inflower(int flowerid,int storeid,int count);
    public boolean outflower(int flowerid,int storeid,int count);
}
