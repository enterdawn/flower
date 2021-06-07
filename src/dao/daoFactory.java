package dao;

import java.util.List;

public interface daoFactory {
    public class DaoFactory extends DaoFactoryabs{

        public DaoFlower getDaoFlower(){
            return new DaoFlower();
        }

        public DaoOrder getDaoOrder() {
            return new DaoOrder();
        }

        public DaoUser getDaoUser(){
            return new DaoUser();
        }

        public DaoWarehouse getDaoWarehouse() {
            return new DaoWarehouse();
        }



    }

}