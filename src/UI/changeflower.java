/*
 * Created by JFormDesigner on Sun Jun 27 12:28:48 CST 2021
 */

package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import BI.BIfactory;
import ent.flower;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class changeflower extends JFrame {
    flower f;
    int storeid;
    public changeflower(flower f) {
        this.f=f;
        this.storeid=storeid;
        initComponents();
        textField1.setText(f.getName());
        label2.setText(String.valueOf(f.getId()));
        textField2.setText(f.getColor());
        textField3.setText(String.valueOf(f.getPrice()));
    }

    private void button1MouseClicked(MouseEvent e) {
        f.setName(textField1.getText());
        f.setColor(textField2.getText());
        f.setPrice(Float.parseFloat(textField3.getText()));
        if(BIfactory.getInstance().getStorerService().chaflower(f)){
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
            "[]"));

        //---- label1 ----
        label1.setText("\u7f16\u53f7");
        contentPane.add(label1, "cell 4 1");

        //---- label2 ----
        label2.setText("text");
        contentPane.add(label2, "cell 6 1");

        //---- label3 ----
        label3.setText("\u82b1\u540d");
        contentPane.add(label3, "cell 4 2");
        contentPane.add(textField1, "cell 6 2 5 1");

        //---- label4 ----
        label4.setText("\u989c\u8272");
        contentPane.add(label4, "cell 4 3");
        contentPane.add(textField2, "cell 6 3 5 1");

        //---- label5 ----
        label5.setText("\u5355\u4ef7");
        contentPane.add(label5, "cell 4 4");
        contentPane.add(textField3, "cell 6 4 5 1");

        //---- button1 ----
        button1.setText("\u4fdd\u5b58");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1, "cell 6 6");
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
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
