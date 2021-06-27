package daolmp;

import ent.flower;
import ent.flowerstore;

import java.util.ArrayList;
import java.util.List;

public interface storedaoint {
    public boolean addstore(String name,int phone,String address,String username,String password);
    public ArrayList<flowerstore> getstorelist();
    public flowerstore login(String username,String password);
    public boolean setinfo(flowerstore store);
}
