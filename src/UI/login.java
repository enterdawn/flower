package UI;

import javax.swing.*;
import java.awt.*;

public class login extends JFrame
{
    public login()
    {
        setTitle("登录");    //设置显示窗口标题
        setSize(600,1000);    //设置窗口显示尺寸
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //置窗口是否可以关闭
        JLabel jl=new JLabel("这是使用JFrame类创建的窗口");    //创建一个标签
        Container c=getContentPane();    //获取当前窗口的内容窗格
        c.add(jl);    //将标签组件添加到内容窗格上
        setVisible(true);    //设置窗口是否可见
    }
    public static void main(String[] agrs)
    {
        new login();    //创建一个实例化对象
    }
}