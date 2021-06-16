package daolmp;

import java.util.List;
import dao.dbutil;
public class flowerdao implements flowerdaoint{
    dbutil co=new dbutil();
    public boolean addflower(String name,String color,String price,int storeid){
        String sql="insert into flower name,color,price,storeid values(,,,,)";
        return true;
    }
    public boolean changeflower(String flowerid,String name,String color,String price){
        return true;
    }
    public boolean inflower(int flowerid,int cnt){
        return true;
    }
    public boolean outflower(int flowerid,int cnt){
        return true;
    }

    public List<String> getflowerinfo(int storeid) {
        return null;
    }
    public List<String> findflowerinfo(List<String> list) {
        return null;
    }

}
