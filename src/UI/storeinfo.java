/*
 * Created by JFormDesigner on Sat Jun 26 20:26:49 CST 2021
 */

package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import BI.BIfactory;
import ent.flowerstore;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class storeinfo extends JFrame {
    flowerstore store;
    public storeinfo(flowerstore store) {
        this.store=store;
        initComponents();
        label2.setText(store.getUsername());
        textField2.setText(store.getPhone());
        textField3.setText(store.getAddress());
        textField4.setText(store.getName());
    }

    private void button1MouseClicked(MouseEvent e) {
        if(!"".equals(textField1.getText())){
            store.setPassword(textField1.getText());
        }
        store.setPhone(textField2.getText());
        store.setAddress(textField3.getText());
        store.setName(textField4.getText());
        if(BIfactory.getInstance().getStorerService().setinfo(store)){
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
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        label4 = new JLabel();
        textField2 = new JTextField();
        label5 = new JLabel();
        textField3 = new JTextField();
        label6 = new JLabel();
        textField4 = new JTextField();
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
            "[]"));

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d");
        contentPane.add(label1, "cell 3 1");

        //---- label2 ----
        label2.setText("text");
        contentPane.add(label2, "cell 5 1");

        //---- label3 ----
        label3.setText("\u5bc6\u7801");
        contentPane.add(label3, "cell 3 2");
        contentPane.add(textField1, "cell 5 2 5 1");

        //---- label4 ----
        label4.setText("\u7535\u8bdd");
        contentPane.add(label4, "cell 3 3");
        contentPane.add(textField2, "cell 5 3 5 1");

        //---- label5 ----
        label5.setText("\u5730\u5740");
        contentPane.add(label5, "cell 3 4");
        contentPane.add(textField3, "cell 5 4 7 1");

        //---- label6 ----
        label6.setText("\u540d\u79f0");
        contentPane.add(label6, "cell 3 5");
        contentPane.add(textField4, "cell 5 5 7 1");

        //---- button1 ----
        button1.setText("\u4fdd\u5b58");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1, "cell 5 6");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JLabel label4;
    private JTextField textField2;
    private JLabel label5;
    private JTextField textField3;
    private JLabel label6;
    private JTextField textField4;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
