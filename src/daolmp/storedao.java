package daolmp;

import dao.dbutil;
import ent.customerent;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import ent.*;

public class storedao implements storedaoint{
    private Connection c;
    public storedao(){
        try {
            c = dbutil.getConn();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "数据库连接失败", JOptionPane.ERROR_MESSAGE);
        }
    }
    protected void finalize() throws Throwable {
        super.finalize();
        if(c==null) return;
        try {
            c=dbutil.CloseConnection(c);
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"连接关闭失败","fail",JOptionPane.ERROR_MESSAGE);
        }
    }
    public boolean addstore(String name, int phone, String address, String username, String password) {
        return false;
    }

    public flowerstore login(String username,String password){
        flowerstore tm=new flowerstore();
        try {
            String sql="select * from flowerstore where username='"+username+"';";
            PreparedStatement t = c.prepareStatement(sql);
            ResultSet s=t.executeQuery();
            s.next();
            tm.setName(s.getString("name"));
            tm.setId(s.getInt("id"));
            tm.setPhone(s.getString("id"));
            tm.setAddress(s.getString("address"));
            tm.setUsername(username);
            tm.setPassword(s.getString("password"));

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage()+"查询失败", "fail", JOptionPane.ERROR_MESSAGE);
        }
        return tm;
    }
    public ArrayList<flowerstore> getstorelist() {
        ArrayList<flowerstore> tmp=new ArrayList<>();
        try {
            String sql="select * from flowerstore;";
            PreparedStatement t = c.prepareStatement(sql);
            ResultSet s=t.executeQuery();
            while(s.next()){
                //System.out.println(1);
                flowerstore tm=new flowerstore();
                tm.setId(s.getInt("id"));
                tm.setAddress(s.getString("address"));
                tm.setName(s.getString("name"));
                tm.setPhone(s.getString("phone"));
                tmp.add(tm);
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage()+"查询失败", "fail", JOptionPane.ERROR_MESSAGE);
        }

        try {
            this.finalize();
        } catch (Throwable throwable) {
            JOptionPane.showMessageDialog(null,"连接关闭失败","fail",JOptionPane.ERROR_MESSAGE);
        }
        return tmp;
    }

}
