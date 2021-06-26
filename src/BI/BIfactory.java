package BI;
import dao.daofactoryabs;
import daolmp.flowerdao;
import ent.*;
public class BIfactory extends BIfactoryab{

    public customer getCustomerService(){
        return new customer();
    }
    public flowerstore getStorerService (){
        return new flowerstore();
    }


}
