/*
 * Created by JFormDesigner on Fri Jun 25 16:23:58 CST 2021
 */

package UI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import BI.BIfactory;
import ent.customerent;
import ent.flower;
import ent.flowerstore;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class userstore extends JFrame {
    customerent User;
    flowerstore store;
    ArrayList<flower> flowers;
    String a[][]={};
    int selectrow=-1;
    String columnNames[]={"名称","颜色","单价","库存"};
    public userstore(customerent User, flowerstore store) {
        this.User=User;
        this.store=store;
        initComponents();
        label1.setText(store.getName());
        label2.setText(store.getPhone());
        label3.setText(store.getAddress());
        flowers= BIfactory.getInstance().getCustomerService().getflower(store.getId());
        table1.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        for (int i = 0; i < flowers.size(); i++) {
            String values[]={flowers.get(i).getName(),flowers.get(i).getColor(), String.valueOf(flowers.get(i).getPrice()), String.valueOf(flowers.get(i).getStock()-flowers.get(i).getSaled())};
            tableModel1.addRow(values);
        }
    }

    private void table1MouseClicked(MouseEvent e) {
        selectrow=table1.getSelectedRow();
    }

    private void button1MouseClicked(MouseEvent e) {
        if(selectrow==-1){
            JOptionPane.showMessageDialog(null,"请选择鲜花","失败",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if((int)spinner1.getValue()>flowers.get(selectrow).getStock()-flowers.get(selectrow).getSaled()){
            JOptionPane.showMessageDialog(null,"库存不足","失败",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(BIfactory.getInstance().getCustomerService().addorder(store.getId(),flowers.get(selectrow).getId(),User.getid(),(int)spinner1.getValue(),flowers.get(selectrow).getPrice())==true){
            JOptionPane.showMessageDialog(null,"下单成功","",JOptionPane.PLAIN_MESSAGE);
            tableModel1.getDataVector().clear();
            for (int i = 0; i < flowers.size(); i++) {
                String values[]={flowers.get(i).getName(),flowers.get(i).getColor(), String.valueOf(flowers.get(i).getPrice()), String.valueOf(flowers.get(i).getStock()-flowers.get(i).getSaled())};
                tableModel1.addRow(values);
            }
        }
    }
    private boolean isDouble(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?\\d*[.]\\d+$");
        return pattern.matcher(str).matches();
    }

    private void button2MouseClicked(MouseEvent e) {
        tableModel1.getDataVector().clear();
        for (int i = 0; i < flowers.size(); i++) {
            if(!textField1.getText().equals("")){
                if(!flowers.get(i).getName().contains(textField1.getText())) continue;
            }
            if(!textField2.getText().equals("")){
                if(!flowers.get(i).getColor().contains(textField2.getText())) continue;
            }
            if(!textField3.getText().equals("")){
                if(!isDouble(textField3.getText())) JOptionPane.showMessageDialog(null,"最小价格非法","失败",JOptionPane.ERROR_MESSAGE);
                if(!(flowers.get(i).getPrice()<Float.parseFloat(textField3.getText()))) continue;
            }
            if(!textField4.getText().equals("")){
                if(!isDouble(textField4.getText())) JOptionPane.showMessageDialog(null,"最大价格非法","失败",JOptionPane.ERROR_MESSAGE);
                if(!(flowers.get(i).getPrice()>Float.parseFloat(textField4.getText()))) continue;
            }
            String values[]={flowers.get(i).getName(),flowers.get(i).getColor(), String.valueOf(flowers.get(i).getPrice()), String.valueOf(flowers.get(i).getStock()-flowers.get(i).getSaled())};
            tableModel1.addRow(values);
        }
    }

    private void initComponents() {
        tableModel1=new DefaultTableModel(a,columnNames){
            public boolean isCellEditable(int rowIndex, int ColIndex){
                return false;
            }
        } ;
        SpinnerNumberModel  nModel = new SpinnerNumberModel(0, 0,0x7ffffff, 1);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        textField1 = new JTextField();
        label5 = new JLabel();
        textField2 = new JTextField();
        label8 = new JLabel();
        spinner1 = new JSpinner(nModel);
        label6 = new JLabel();
        textField3 = new JTextField();
        label7 = new JLabel();
        textField4 = new JTextField();
        button2 = new JButton();
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

        //---- label1 ----
        label1.setText("text");
        contentPane.add(label1, "cell 0 0");

        //---- label2 ----
        label2.setText("text");
        contentPane.add(label2, "cell 15 0");

        //---- label3 ----
        label3.setText("text");
        contentPane.add(label3, "cell 0 1");

        //---- label4 ----
        label4.setText("\u82b1\u540d");
        contentPane.add(label4, "cell 0 2");
        contentPane.add(textField1, "cell 3 2 21 1");

        //---- label5 ----
        label5.setText("\u989c\u8272");
        contentPane.add(label5, "cell 26 2");
        contentPane.add(textField2, "cell 28 2 19 1");

        //---- label8 ----
        label8.setText("\u8d2d\u4e70\u6570\u91cf");
        contentPane.add(label8, "cell 48 2");
        contentPane.add(spinner1, "cell 50 2 5 1");

        //---- label6 ----
        label6.setText("\u4ef7\u683c");
        contentPane.add(label6, "cell 0 3");
        contentPane.add(textField3, "cell 3 3 8 1");

        //---- label7 ----
        label7.setText("\u5230");
        contentPane.add(label7, "cell 11 3");
        contentPane.add(textField4, "cell 15 3 7 1");

        //---- button2 ----
        button2.setText("\u67e5\u627e");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });
        contentPane.add(button2, "cell 45 3");

        //---- button1 ----
        button1.setText("\u4e0b\u8ba2\u5355");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1, "cell 53 3");

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
        contentPane.add(scrollPane1, "cell 0 4 55 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField1;
    private JLabel label5;
    private JTextField textField2;
    private JLabel label8;
    private JSpinner spinner1;
    private JLabel label6;
    private JTextField textField3;
    private JLabel label7;
    private JTextField textField4;
    private JButton button2;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private DefaultTableModel tableModel1;
    private JScrollPane jScrollPane;
}
