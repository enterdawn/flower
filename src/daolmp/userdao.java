package daolmp;

import dao.dbutil;
import ent.*;

import javax.swing.*;
import java.sql.*;
import java.util.List;

public class userdao implements userdaoint{
    private Connection c;
    public userdao(){
        try {
            c = dbutil.getConn();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "数据库连接失败", JOptionPane.ERROR_MESSAGE);
        }
    }
    protected void finalize() throws Throwable {
        super.finalize();
        try {
            c=dbutil.CloseConnection(c);
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"连接关闭失败","fail",JOptionPane.ERROR_MESSAGE);
        }
    }
    public boolean adduser(String name, int phone, String gender, String username, String password) {
        return false;
    }

    public customerent getuserinfo(String username){
        customerent tmp=new customerent ();
        try {
            String sql="select * from customer where username='"+username+"';";
            PreparedStatement t = c.prepareStatement(sql);
            ResultSet s=t.executeQuery();
            s.next();
            tmp.setid(s.getInt("id"));
            tmp.setgender(s.getInt("gender"));
            tmp.setpassword(s.getString("password"));
            tmp.setusername(s.getString("username"));
            tmp.setname(s.getString("name"));
            tmp.setphone(s.getString("phone"));

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage()+"登录失败", "fail", JOptionPane.ERROR_MESSAGE);
        }
        return tmp;
    };
}
