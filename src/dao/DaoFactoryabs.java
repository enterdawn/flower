package dao;

import daolmp.*;

public abstract class DaoFactoryabs {
    private static daoFactory dfactory;

    public static daoFactory getInstance()
    {
        dfactory = new daoFactory();
        return dfactory;
    }

    public abstract flowerdao getDaoFlower();

    public abstract orderdao getDaoOrder();

    public abstract userdao getDaoUser();

    public abstract storedao getDaoWarehouse();
}
