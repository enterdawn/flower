package BI;

import java.util.List;
import dao.*;

public class customer implements CustomerService{
    public boolean login(String username,String possword){
        return true;
    }
    public List<String> getflower(String flowerid, String name, String color, float lowprice) {
        return null;
    }

    public boolean addorder(String flowerid, int userid, int count) {
        return false;
    }

    public List<String> seeorder(int userid) {
        return null;
    }
}
