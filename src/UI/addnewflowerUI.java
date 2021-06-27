/*
 * Created by JFormDesigner on Sat Jun 26 20:27:06 CST 2021
 */

package UI;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;
import javax.swing.*;

import BI.BIfactory;
import ent.flower;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class addnewflowerUI extends JFrame {
    flower f;
    int storeid;
    public addnewflowerUI(int storeid) {
        this.storeid=storeid;
        initComponents();
    }
    private boolean isDouble(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?\\d*[.]\\d+$");
        return pattern.matcher(str).matches();
    }

    private void button1MouseClicked(MouseEvent e) {
        if(!isDouble(textField3.getText())){
            JOptionPane.showMessageDialog(null,"输入数据非法","失败",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(BIfactory.getInstance().getStorerService().addflower(textField1.getText(),textField2.getText(),Float.parseFloat(textField3.getText()),storeid)){
            JOptionPane.showMessageDialog(null,"添加成功","",JOptionPane.PLAIN_MESSAGE);
            this.setVisible(false);
            return;
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
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
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("\u82b1\u540d");
        contentPane.add(label1, "cell 3 1");
        contentPane.add(textField1, "cell 5 1 8 1");

        //---- label2 ----
        label2.setText("\u989c\u8272");
        contentPane.add(label2, "cell 3 2");
        contentPane.add(textField2, "cell 5 2 8 1");

        //---- label3 ----
        label3.setText("\u4ef7\u683c");
        contentPane.add(label3, "cell 3 3");
        contentPane.add(textField3, "cell 5 3 8 1");

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1, "cell 6 5");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
