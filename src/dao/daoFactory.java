package dao;

import daolmp.*;

public class daoFactory extends daofactoryabs {

    public flowerdao getDaoFlower(){
        return new flowerdao();
    }

    public orderdao getDaoOrder() {
        return new orderdao();
    }

    public userdao getDaoUser(){
        return new userdao();
    }

    public storedao getDaoWarehouse() {
        return new storedao();
    }

}