/*
 * Created by JFormDesigner on Thu Jun 24 15:09:45 CST 2021
 */

package UI;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import BI.BIfactory;
import ent.customerent;
import ent.flower;
import ent.flowerstore;
import ent.orders;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class myorder extends JFrame {
    customerent User;
    String a[][]={};
    int selectrow=-1;
    String columnNames[]={"商店","鲜花","单价","数量","时间","状态"};
    ArrayList<orders> myorder;
    public myorder(customerent User) {
        this.User=User;
        initComponents();
        table1.getTableHeader().setReorderingAllowed( false ) ;
        table1.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        myorder= BIfactory.getInstance().getCustomerService().seeorder(User.getid());
        for (int i = 0; i < myorder.size(); i++) {
            String name=BIfactory.getInstance().getCustomerService().getstorename(myorder.get(i).getStoreid());
            flower color=BIfactory.getInstance().getCustomerService().getflowerinfo(myorder.get(i).getFlowerid());
            String sta;
            if(myorder.get(i).getStatus()==true){
                sta="未出库";
            }
            else sta="已出库";
            String values[]={name, color.getName()+"-"+color.getColor(), String.valueOf(myorder.get(i).getPrice()), String.valueOf(myorder.get(i).getCount()),myorder.get(i).getTime().toString(),sta};
            tableModel1.addRow(values);
        }

    }

    private void initComponents() {
        tableModel1=new DefaultTableModel(a,columnNames){
            public boolean isCellEditable(int rowIndex, int ColIndex){
                return false;
            }
        } ;
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
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
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1, "cell 0 1 45 3");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private DefaultTableModel tableModel1;
}
