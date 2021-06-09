package daolmp;

import java.util.List;
public interface flowerdaoint {
    public boolean addflower(String name,String color,String price,int storeid);
    public boolean changeflower(String flowerid,String name,String color,String price);
    public boolean inflower(int flowerid,int cnt);
    public boolean outflower(int flowerid,int cnt);


    public List<String> getflowerinfo(int storeid);

    public List<String> findflowerinfo(List<String> list);


}
