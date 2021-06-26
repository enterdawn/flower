package daolmp;

import dao.dbutil;
import ent.customerent;
import ent.flower;
import ent.orders;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class orderdao implements orderdaoint{
    private Connection c;
    public orderdao(){
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
    public boolean addorder(int storeid, int flowerid, int customerid, int cnt, float price) {
        Date d=new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        String sql="INSERT INTO orders (storeid,customerid,flowerid,count,price,time,status) VALUES ('"+storeid+"','"+customerid+"','"+flowerid+"','"+cnt+"','"+price+"','"+ sdf.format(d)+"','1');";
        System.out.println(sql);
        try {
            int t = c.createStatement().executeUpdate(sql);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"下单失败","fail",JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    public int getflowerasled(int flowerid){
        String sql="select sum(count) from orders where flowerid='"+flowerid+"' and status=2;";
        //System.out.println(sql);
        try{
            PreparedStatement t = c.prepareStatement(sql);
            ResultSet s=t.executeQuery();
            s.next();
            //System.out.println(s.getInt("sum(count)"));
            return s.getInt("sum(count)");

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,e,"fail",JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }
    public ArrayList<orders> storegetorder(int storeid){
        return null;
    }
    public ArrayList<orders> custgetorder(int id){
        ArrayList<orders> tmp=new ArrayList<>();
        try {
            String sql="select * from orders where customerid='"+id+"';";
            PreparedStatement t = c.prepareStatement(sql);
            ResultSet s=t.executeQuery();
            while(s.next()){
                orders tm=new orders();
                tm.setId(s.getInt("id"));
                tm.setPrice(s.getFloat("price"));
                tm.setCount(s.getInt("count"));
                tm.setCustomerid(s.getInt("customerid"));
                tm.setStatus(s.getBoolean("status"));
                tm.setFlowerid(s.getInt("flowerid"));
                tm.setTime(s.getTimestamp("time"));
                tm.setStoreid(s.getInt("storeid"));
                tmp.add(tm);
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage()+"查询失败", "fail", JOptionPane.ERROR_MESSAGE);
        }
        return tmp;
    }
    public String getstorename(int storeid){
        try {
            String sql="select name from flowerstore where id='"+storeid+"';";
            PreparedStatement t = c.prepareStatement(sql);
            ResultSet s=t.executeQuery();
            s.next();
            return s.getString("name");

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage()+"查询失败", "fail", JOptionPane.ERROR_MESSAGE);
            return "";
        }


    }
    public flower getflowerinfo(int flowerid){
        flower tmp=new flower();
        try {
            String sql="select * from flower where id='"+flowerid+"';";
            PreparedStatement t = c.prepareStatement(sql);
            ResultSet s=t.executeQuery();
            s.next();
            tmp.setId(s.getInt("id"));
            tmp.setName(s.getString("name"));
            tmp.setColor(s.getString("color"));
            tmp.setPrice(s.getFloat("price"));
            tmp.setStock(s.getInt("stock"));
            return tmp;

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage()+"查询失败", "fail", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }
}
