/*
 * Created by JFormDesigner on Thu Jun 24 15:34:44 CST 2021
 */

package UI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import BI.BIfactory;
import ent.customerent;
import ent.flower;
import ent.orders;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class storeorder extends JFrame {
    int storeid;
    ArrayList<orders> o;
    String a[][]={};
    int selectrow=-1;
    String columnNames[]={"客户姓名","客户电话","售出鲜花","数量","单价","下单时间","状态"};
    public storeorder(int storeid) {
        this.storeid=storeid;
        this.setSize(1000, 250);
        initComponents();
        table1.getTableHeader().setReorderingAllowed( false ) ;
        table1.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        o= BIfactory.getInstance().getStorerService().getorder(storeid);
        for(int i=0;i<o.size();i++){
            flower color=BIfactory.getInstance().getCustomerService().getflowerinfo(o.get(i).getFlowerid());
            customerent cust=BIfactory.getInstance().getStorerService().getuserinfo(o.get(i).getCustomerid());
            String status;
            String sta;
            if(o.get(i).getStatus()==true){
                sta="未出库";
            }
            else sta="已出库";
            String values[]={cust.getname(),cust.getphone(),color.getName()+"-"+color.getColor(), String.valueOf(o.get(i).getCount()), String.valueOf(o.get(i).getPrice()), String.valueOf(o.get(i).getTime()),sta};
            tableModel1.addRow(values);
        }

    }
    private void refreash(){
        tableModel1.getDataVector().clear();
        o= BIfactory.getInstance().getStorerService().getorder(storeid);
        for(int i=0;i<o.size();i++){
            flower color=BIfactory.getInstance().getCustomerService().getflowerinfo(o.get(i).getFlowerid());
            customerent cust=BIfactory.getInstance().getStorerService().getuserinfo(o.get(i).getCustomerid());
            String status;
            String sta;
            if(o.get(i).getStatus()==true){
                sta="未出库";
            }
            else sta="已出库";
            String values[]={cust.getname(),cust.getphone(),color.getName()+"-"+color.getColor(), String.valueOf(o.get(i).getCount()), String.valueOf(o.get(i).getPrice()), String.valueOf(o.get(i).getTime()),sta};
            tableModel1.addRow(values);
        }
    }
    private void button2MouseClicked(MouseEvent e) {
        refreash();
    }

    private void button1MouseClicked(MouseEvent e) {
        if(BIfactory.getInstance().getStorerService().outflower(o.get(selectrow))){
            JOptionPane.showMessageDialog(null,"出库成功","",JOptionPane.PLAIN_MESSAGE);
            refreash();
        }
        else{
            JOptionPane.showMessageDialog(null,"出库失败","失败",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void table1MouseClicked(MouseEvent e) {
        selectrow=table1.getSelectedRow();
    }

    private void initComponents() {
        tableModel1=new DefaultTableModel(a,columnNames){
            public boolean isCellEditable(int rowIndex, int ColIndex){
                return false;
            }
        };
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        button2 = new JButton();
        label1 = new JLabel();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable(tableModel1);

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]"));

        //---- button2 ----
        button2.setText("\u5237\u65b0");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });
        contentPane.add(button2, "cell 0 1 8 1");
        contentPane.add(label1, "cell 13 1 11 1");

        //---- button1 ----
        button1.setText("\u51fa\u5e93");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1, "cell 49 1 8 1");

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    table1MouseClicked(e);
                }
            });
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1, "cell 0 2 57 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JButton button2;
    private JLabel label1;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private DefaultTableModel tableModel1;
}
