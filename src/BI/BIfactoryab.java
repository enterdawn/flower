package BI;

import dao.daoFactory;
import daolmp.userdao;

public abstract class BIfactoryab {

    private static BIfactory BIfactory;

    public static BIfactoryab getInstance()
    {
        BIfactory= new BIfactory();
        return BIfactory;
    }
    public abstract customer getCustomerService ();
    public abstract flowerstore getStorerService ();

}
