/*
 * Created by JFormDesigner on Thu Jun 24 15:03:16 CST 2021
 */

package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import BI.BIfactory;
import ent.customerent;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class userinfo extends JFrame {
    customerent User;
    String[] sexs = { "未设置","男", "女" };
    public userinfo(customerent User) {
        initComponents();
        this.User=User;
        textField3.setText(User.getname());
        textField1.setText(User.getphone());
        label5.setText(User.getusername());
        comboBox1.addItem("未设置");
        comboBox1.addItem("男");
        comboBox1.addItem("女");
        comboBox1.setSelectedIndex(User.getgender());
    }

    private void button1MouseClicked(MouseEvent e) {
        User.setname(textField3.getText());
        if("".equals(textField2.getText())==false)User.setpassword(textField2.getText());
        User.setphone(textField1.getText());
        User.setgender(comboBox1.getSelectedIndex());
        if(BIfactory.getInstance().getCustomerService().change(User)){
            JOptionPane.showMessageDialog(null,"修改成功","",JOptionPane.PLAIN_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"修改失败","失败",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        label5 = new JLabel();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        comboBox1 = new JComboBox();
        label6 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();

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
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d");
        contentPane.add(label1, "cell 3 3");

        //---- label5 ----
        label5.setText("text");
        contentPane.add(label5, "cell 6 3");

        //---- label2 ----
        label2.setText("\u5bc6\u7801");
        contentPane.add(label2, "cell 3 6");
        contentPane.add(textField2, "cell 6 6 5 1");

        //---- label3 ----
        label3.setText("\u59d3\u540d");
        contentPane.add(label3, "cell 3 8");
        contentPane.add(textField3, "cell 6 8 5 1");

        //---- label4 ----
        label4.setText("\u6027\u522b");
        contentPane.add(label4, "cell 3 10");
        contentPane.add(comboBox1, "cell 6 10 5 1");

        //---- label6 ----
        label6.setText("\u624b\u673a");
        contentPane.add(label6, "cell 3 12");
        contentPane.add(textField1, "cell 6 12 5 1");

        //---- button1 ----
        button1.setText("\u4fdd\u5b58");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1, "cell 6 15");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JLabel label5;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JComboBox comboBox1;
    private JLabel label6;
    private JTextField textField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
