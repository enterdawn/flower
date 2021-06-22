package BI;
import dao.daofactoryabs;
import daolmp.flowerdao;
import ent.*;
public class BIfactory extends BIfactoryab{

    public login getlogin(){
        return new login();
    }


}
