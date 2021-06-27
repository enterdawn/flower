package daolmp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import dao.dbutil;
import ent.flower;
import ent.flowerstore;

import javax.swing.*;

public class flowerdao implements flowerdaoint{
    private Connection c;
    public flowerdao(){
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
    public boolean addflower(String name,String color,float price,int storeid){
        String sql="INSERT INTO flower (name,color,price,store,stock,saled) VALUES ('"+name+"','"+color+"','"+price+"','"+storeid+"','"+"0"+"','"+ "0"+"');";
        System.out.println(sql);
        try {
            int t = c.createStatement().executeUpdate(sql);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"添加失败","fail",JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    public boolean changeflower(flower f){
        try {
            String sql = "UPDATE flower SET name = '"+f.getName()+"',color='"+f.getColor()+"',price='"+ f.getPrice()+"' WHERE id = '"+f.getId()+ "';";
            //System.out.println(sql);
            int t = c.createStatement().executeUpdate(sql);
        }
        catch (Exception e) {return false;}
        return true;
    }
    public boolean outflower(int flowerid,int cnt){
        return true;
    }

    public ArrayList<flower> getflowerinfo(int storeid) {
        ArrayList<flower> tmp=new ArrayList<>();
        try {
            String sql="select * from flower where store='"+storeid+"';";
            PreparedStatement t = c.prepareStatement(sql);
            ResultSet s=t.executeQuery();
            while(s.next()){
                flower tm=new flower();
                tm.setId(s.getInt("id"));
                tm.setName(s.getString("name"));
                tm.setColor(s.getString("color"));
                tm.setPrice(s.getFloat("price"));
                tm.setStock(s.getInt("stock"));
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
    public int getflowerasled(int flowerid){
        String sql="select sum(count) from orders where flowerid='"+flowerid+"' and status=1;";
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
    public boolean inflower(int flowerid, int count){
        try {
            String sql = "UPDATE flower SET stock = stock+"+count+" WHERE id = '"+flowerid+ "';";
            //System.out.println(sql);
            int t = c.createStatement().executeUpdate(sql);
        }
        catch (Exception e) {return false;}
        return true;
    }

}
