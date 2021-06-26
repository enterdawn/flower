/*
 * Created by JFormDesigner on Tue Jun 22 15:36:05 CST 2021
 */

package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import BI.BIfactoryab;
import ent.customerent;
import ent.flowerstore;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class loginUI extends JFrame {
    public loginUI() {
        initComponents();
    }
    private int s=0;
    private void button1ActionPerformed(ActionEvent e) {
        if(s==0){
            JOptionPane.showMessageDialog(null,"请选择用户角色","失败",JOptionPane.ERROR_MESSAGE);
        }
        else if(s==1){
            flowerstore store=BIfactoryab.getInstance().getStorerService().login(textField1.getText().toString(), passwordField1.getText().toString());
            if(store.getId()!=0){
                JOptionPane.showMessageDialog(null,"登录成功","",JOptionPane.PLAIN_MESSAGE);
                this.setVisible(false);
                new store(store).setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(null,"登录失败","失败",JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            customerent User=BIfactoryab.getInstance().getCustomerService().login(textField1.getText().toString(), passwordField1.getText().toString());
            if(User.getid()!=0){
                JOptionPane.showMessageDialog(null,"登录成功","",JOptionPane.PLAIN_MESSAGE);
                this.setVisible(false);
                new customerUI(User).setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(null,"登录失败","失败",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void radioButton1ActionPerformed(ActionEvent e) {
        s=1;
    }

    private void radioButton2ActionPerformed(ActionEvent e) {
        s=2;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        passwordField1 = new JPasswordField();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        button1 = new JButton();
        group1 =new ButtonGroup();


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
            "[fill]",
            // rows
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
        contentPane.add(label1, "cell 2 1 2 1");
        contentPane.add(textField1, "cell 5 1 5 1");

        //---- label2 ----
        label2.setText("\u5bc6\u7801");
        contentPane.add(label2, "cell 2 3");
        contentPane.add(passwordField1, "cell 5 3 5 1");

        //---- radioButton1 ----
        radioButton1.setText("\u5546\u5e97");
        radioButton1.addActionListener(e -> radioButton1ActionPerformed(e));
        contentPane.add(radioButton1, "cell 5 5");

        //---- radioButton2 ----
        radioButton2.setText("\u7528\u6237");
        radioButton2.addActionListener(e -> radioButton2ActionPerformed(e));
        contentPane.add(radioButton2, "cell 7 5");
        group1.add(radioButton1);
        group1.add(radioButton2);
        //---- button1 ----
        button1.setText("\u767b\u5f55");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1, "cell 5 7");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JPasswordField passwordField1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JButton button1;
    private ButtonGroup group1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public static void main(String[] args) {
        new loginUI().setVisible(true);
    }
}
