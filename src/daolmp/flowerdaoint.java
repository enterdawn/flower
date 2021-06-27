package daolmp;

import ent.flower;

import java.util.ArrayList;
import java.util.List;
public interface flowerdaoint {
    public boolean addflower(String name,String color,float price,int storeid);
    public boolean changeflower(flower f);
    public boolean outflower(int flowerid,int cnt);


    public ArrayList<flower> getflowerinfo(int storeid);

    public int getflowerasled(int flowerid);
    public boolean inflower(int flowerid,  int count);


}
