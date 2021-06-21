package BI;

import java.util.List;

public class flowerstore implements FlowerStoreService{
    public boolean login(String username,String password){
        return true;
    }
    public boolean addflower() {
        return false;
    }

    public List<String> getflower(int storeid) {
        return null;
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
