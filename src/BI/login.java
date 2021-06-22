package BI;

import dao.daofactoryabs;
import ent.customerent;

public class login {
    public static boolean logina(String username,String password){
            customerent userinfo;
            userinfo= daofactoryabs.getInstance().getDaoUser().getuserinfo(username);
            if(userinfo.getid()==0){

                return false;
            }
            else if(password.equals(userinfo.getpassword())){
                return true;
            }
            else{
                return false;
            }


    }
}
