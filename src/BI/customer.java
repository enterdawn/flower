package BI;

import java.util.ArrayList;
import java.util.List;
import dao.*;
import ent.*;
import ent.flowerstore;

public class customer implements CustomerService{
    public customerent login(String username,String password){
        customerent User=new customerent();
        User= daofactoryabs.getInstance().getDaoUser().getuserinfo(username);
        return User;
    }
    public ArrayList<flowerstore> getstorelist(){
        return daofactoryabs.getInstance().getDaoWarehouse().getstorelist();
    }
    public ArrayList<flower> getflower(int storeid) {
        return daoFactory.getInstance().getDaoFlower().getflowerinfo(storeid);
    }

    public boolean change(customerent User) {
        return daoFactory.getInstance().getDaoUser().change(User);
    }
    public boolean addorder(int storeid, int flowerid, int customerid, int cnt, float price){
        return daoFactory.getInstance().getDaoOrder().addorder(storeid,flowerid, customerid,cnt, price);
    }
    public flower getflowerinfo(int flowerid){
        return daoFactory.getInstance().getDaoOrder().getflowerinfo(flowerid);
    }
    public String getstorename(int storeid){
        return daoFactory.getInstance().getDaoOrder().getstorename(storeid);
    }

    public ArrayList<orders> seeorder(int userid) {
        return daoFactory.getInstance().getDaoOrder().custgetorder(userid);
    }
}
