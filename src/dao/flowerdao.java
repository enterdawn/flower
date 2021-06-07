package dao;

import java.util.List;
public interface flowerdao {
    public boolean addorder(int storeid,int flowerid,int customerid,int cnt,float price);
    public boolean adduser(String name,int phone,String gender,String username,String password);
    public boolean addstore(String name,int phone,String address,String username,String password);
    public boolean addflower(String name,String color,String price,int storeid);
    public boolean changeflower(String flowerid,String name,String color,String price);
    public boolean inflower(int flowerid,int cnt);
    public boolean outflower(int flowerid,int cnt);
    public List<String> storegetorder(int storeid);
    public List<String> getstorelist();
    public List<String> getflowerinfo(int storeid);
    public List<String> getuserinfo(int userid);
    public List<String> findflowerinfo(List<String> list);
    public List<String> custgetorder(int id);

}
