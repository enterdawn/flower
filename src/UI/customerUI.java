/*
 * Created by JFormDesigner on Thu Jun 24 18:46:44 CST 2021
 */

package UI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import BI.BIfactory;
import ent.customerent;
import ent.flowerstore;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class customerUI extends JFrame {
    private customerent User;
    String a[][]={};
    int selectrow=-1;
    ArrayList<flowerstore> stores;
    String columnNames[]={"商店名称","电话","地址"};
    public customerUI(customerent User) {
        initComponents();
        this.User=User;
        table1.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        stores= BIfactory.getInstance().getCustomerService().getstorelist();
        //System.out.println(stores.size());
        //tableModel1.isCellEditable(stores.size()-1,2);
        for (int i = 0; i < stores.size(); i++) {
            String values[]={stores.get(i).getName(),stores.get(i).getPhone(),stores.get(i).getAddress()};
            tableModel1.addRow(values);
        }

    }

    private void table1MouseClicked(MouseEvent e) {
        selectrow=table1.getSelectedRow();
        //System.out.println(selectrow);
    }

    private void button1MouseClicked(MouseEvent e) {
        new myorder(User).setVisible(true);
    }

    private void button3MouseClicked(MouseEvent e) {
        new userinfo(User).setVisible(true);
    }

    private void button2MouseClicked(MouseEvent e) {
        if(selectrow==-1){
            JOptionPane.showMessageDialog(null,"请选择商店","失败",JOptionPane.ERROR_MESSAGE);
            return;
        }
        new userstore(User, stores.get(selectrow)).setVisible(true);
    }

    private void initComponents() {
        tableModel1=new DefaultTableModel(a,columnNames){
            public boolean isCellEditable(int rowIndex, int ColIndex){
                return false;
            }
        } ;

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        button1 = new JButton();
        button3 = new JButton();
        button2 = new JButton();
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
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- button1 ----
        button1.setText("\u67e5\u770b\u8ba2\u5355");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1, "cell 1 1");

        //---- button3 ----
        button3.setText("\u4e2a\u4eba\u4fe1\u606f");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
            }
        });
        contentPane.add(button3, "cell 8 1");

        //---- button2 ----
        button2.setText("\u8fdb\u5165\u5546\u5e97");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });
        contentPane.add(button2, "cell 17 1");

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
        contentPane.add(scrollPane1, "cell 0 3 18 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JButton button1;
    private JButton button3;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private DefaultTableModel tableModel1;
}
