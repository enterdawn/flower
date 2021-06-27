package BI;

import java.util.ArrayList;
import java.util.List;
import dao.*;
import ent.customerent;
import ent.flower;
import ent.orders;

public class flowerstore implements FlowerStoreService{
    public ent.flowerstore login(String username, String password){
        return daoFactory.getInstance().getDaoWarehouse().login(username,password);
    }
    public boolean chaflower(flower d){
        return daoFactory.getInstance().getDaoFlower().changeflower(d);
    }

    public ArrayList<flower> getflower(int storeid) {
        return daoFactory.getInstance().getDaoFlower().getflowerinfo(storeid);
    }
    public int getflowersaledd(int flowerid){
        return daoFactory.getInstance().getDaoOrder().getflowerasled(flowerid);
    }
    public boolean setinfo(ent.flowerstore store){
        return daoFactory.getInstance().getDaoWarehouse().setinfo(store);
    }
    public boolean addflower(String name,String color,float price,int storeid){
        return daoFactory.getInstance().getDaoFlower().addflower(name,color,price,storeid);
    }
    public ArrayList<orders> getorder(int storeid) {
        return daoFactory.getInstance().getDaoOrder().storegetorder(storeid);
    }
    public customerent getuserinfo(int userid){
        return daoFactory.getInstance().getDaoUser().storegetuserinfo(userid);
    }

    public boolean inflower(int flowerid,  int count) {
        return daoFactory.getInstance().getDaoFlower().inflower(flowerid,count);
    }

    public boolean outflower(orders o) {
        return daoFactory.getInstance().getDaoOrder().outflower(o);
    }
}
