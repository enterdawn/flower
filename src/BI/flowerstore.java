package BI;

import java.util.ArrayList;
import java.util.List;
import dao.*;
import ent.flower;

public class flowerstore implements FlowerStoreService{
    public ent.flowerstore login(String username, String password){
        return daoFactory.getInstance().getDaoWarehouse().login(username,password);
    }
    public boolean addflower() {
        return false;
    }

    public ArrayList<flower> getflower(int storeid) {
        return daoFactory.getInstance().getDaoFlower().getflowerinfo(storeid);
    }
    public int getflowersaledd(int flowerid){
        return daoFactory.getInstance().getDaoOrder().getflowerasled(flowerid);
    }

    public List<String> getorder(int storeid) {
        return null;
    }

    public List<String> getsale(int storeid) {
        return null;
    }

    public boolean inflower(int flowerid, int storeid, int count) {
        return false;
    }

    public boolean outflower(int flowerid, int storeid, int count) {
        return false;
    }
}
