/*
 * Created by JFormDesigner on Thu Jun 24 15:11:31 CST 2021
 */

package UI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import BI.BIfactory;
import ent.flower;
import ent.flowerstore;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class store extends JFrame {
    flowerstore store;
    String a[][]={};
    int selectrow=-1;
    ArrayList<flower> flowers;
    String columnNames[]={"编号","名称","单价","库存","待出库","销量"};
    
    public store(flowerstore store) {
        this.store=store;
        initComponents();
        table1.getTableHeader().setReorderingAllowed( false ) ;
        table1.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        flowers= BIfactory.getInstance().getStorerService().getflower(store.getId());
        for (int i = 0; i < flowers.size(); i++) {
            String values[]={String.valueOf(flowers.get(i).getId()),flowers.get(i).getName()+"-"+flowers.get(i).getColor(), String.valueOf(flowers.get(i).getPrice()), String.valueOf(flowers.get(i).getStock()), String.valueOf(flowers.get(i).getSaled()), String.valueOf(BIfactory.getInstance().getStorerService().getflowersaledd(flowers.get(i).getId()))};
            tableModel1.addRow(values);
        }
    }

    private void button1MouseClicked(MouseEvent e) {
        new storeinfo(store).setVisible(true);
    }

    private void button2MouseClicked(MouseEvent e) {
        new storeorder(store.getId()).setVisible(true);
    }

    private void button4MouseClicked(MouseEvent e) {
        if(selectrow==-1){
            JOptionPane.showMessageDialog(null,"请选择鲜花","失败",JOptionPane.ERROR_MESSAGE);
            return;
        }
        new changeflower(flowers.get(selectrow)).setVisible(true);
    }
    private void refreash(){
        flowers= BIfactory.getInstance().getStorerService().getflower(store.getId());
        tableModel1.getDataVector().clear();
        for (int i = 0; i < flowers.size(); i++) {
            String values[]={String.valueOf(flowers.get(i).getId()),flowers.get(i).getName()+"-"+flowers.get(i).getColor(), String.valueOf(flowers.get(i).getPrice()), String.valueOf(flowers.get(i).getStock()), String.valueOf(flowers.get(i).getSaled()), String.valueOf(BIfactory.getInstance().getStorerService().getflowersaledd(flowers.get(i).getId()))};
            tableModel1.addRow(values);
        }
    }

    private void button3MouseClicked(MouseEvent e) {
        if(selectrow==-1){
            JOptionPane.showMessageDialog(null,"请选择鲜花","失败",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            if(BIfactory.getInstance().getStorerService().inflower(flowers.get(selectrow).getId(),(int)spinner1.getValue())){
                JOptionPane.showMessageDialog(null,"入库成功","",JOptionPane.PLAIN_MESSAGE);
                flowers= BIfactory.getInstance().getStorerService().getflower(store.getId());
                tableModel1.getDataVector().clear();
                for (int i = 0; i < flowers.size(); i++) {
                    String values[]={String.valueOf(flowers.get(i).getId()),flowers.get(i).getName()+"-"+flowers.get(i).getColor(), String.valueOf(flowers.get(i).getPrice()), String.valueOf(flowers.get(i).getStock()), String.valueOf(flowers.get(i).getSaled()), String.valueOf(BIfactory.getInstance().getStorerService().getflowersaledd(flowers.get(i).getId()))};
                    tableModel1.addRow(values);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"入库失败","失败",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void button5MouseClicked(MouseEvent e) {
        new addnewflowerUI(store.getId()).setVisible(true);
    }

    private void table1MouseClicked(MouseEvent e) {
        selectrow=table1.getSelectedRow();
        
    }

    private void button6MouseClicked(MouseEvent e) {
        refreash();
    }

    private void initComponents() {
        tableModel1=new DefaultTableModel(a,columnNames){
            public boolean isCellEditable(int rowIndex, int ColIndex){
                return false;
            }
        };
        SpinnerNumberModel  nModel = new SpinnerNumberModel(0, 0,0x7ffffff, 1);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        button1 = new JButton();
        button6 = new JButton();
        button2 = new JButton();
        button5 = new JButton();
        button4 = new JButton();
        spinner1 = new JSpinner(nModel);
        button3 = new JButton();
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
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- button1 ----
        button1.setText("\u5546\u5e97\u4fe1\u606f");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1, "cell 1 1");

        //---- button6 ----
        button6.setText("\u5237\u65b0\u5217\u8868");
        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button6MouseClicked(e);
            }
        });
        contentPane.add(button6, "cell 5 1");

        //---- button2 ----
        button2.setText("\u8ba2\u5355\u4fe1\u606f");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });
        contentPane.add(button2, "cell 10 1");

        //---- button5 ----
        button5.setText("\u6dfb\u52a0\u9c9c\u82b1");
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button5MouseClicked(e);
            }
        });
        contentPane.add(button5, "cell 14 1");

        //---- button4 ----
        button4.setText("\u4fee\u6539\u9c9c\u82b1");
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button4MouseClicked(e);
            }
        });
        contentPane.add(button4, "cell 18 1");
        contentPane.add(spinner1, "cell 23 1 4 1");

        //---- button3 ----
        button3.setText("\u5165\u5e93");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
            }
        });
        contentPane.add(button3, "cell 27 1");

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
        contentPane.add(scrollPane1, "cell 1 3 27 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JButton button1;
    private JButton button6;
    private JButton button2;
    private JButton button5;
    private JButton button4;
    private JSpinner spinner1;
    private JButton button3;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private DefaultTableModel tableModel1;
}
