package dao;

import java.util.List;

public interface daoFactory {
    public class DaoFactory extends DaoFactoryabs{

        public daoFlower getDaoFlower(){
            return new daoFlower();
        }

        public daoOrder getDaoOrder() {
            return new daoOrder();
        }

        public daoUser getDaoUser(){
            return new daoUser();
        }

        public daoWarehouse getDaoWarehouse() {
            return new daoWarehouse();
        }



    }

}