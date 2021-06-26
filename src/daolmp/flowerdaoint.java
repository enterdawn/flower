package daolmp;

import ent.flower;

import java.util.ArrayList;
import java.util.List;
public interface flowerdaoint {
    public boolean addflower(String name,String color,String price,int storeid);
    public boolean changeflower(String flowerid,String name,String color,String price);
    public boolean inflower(int flowerid,int cnt);
    public boolean outflower(int flowerid,int cnt);


    public ArrayList<flower> getflowerinfo(int storeid);

    public int getflowerasled(int flowerid);


}
