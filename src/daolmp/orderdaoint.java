package daolmp;

import java.util.List;

public interface orderdaoint {
    public boolean addorder(int storeid,int flowerid,int customerid,int cnt,float price);
    public List<String> storegetorder(int storeid);
    public List<String> custgetorder(int id);
}
