package com.yjp.gui.admin;

import com.yjp.gui.UserLoginFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaffFrame extends JFrame {


    public StaffFrame() {
        setSize(1200,800);
        setTitle("在线黑店");
        int x = (int) ((getToolkit().getScreenSize().getWidth()-this.getWidth())/2);
        int y = (int) ((getToolkit().getScreenSize().getHeight()-this.getHeight())/2);
        setLocation(x,y);


        //顶部标题
        JPanel top = new JPanel(new GridLayout(2,1));
        this.add(top, BorderLayout.NORTH);
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.white);
        JLabel topTitle = new JLabel("在线商城后台管理系统");
        Font titleFont = new Font("微软雅黑",Font.BOLD,40);
        topTitle.setFont(titleFont);
        titlePanel.add(topTitle);
        JPanel userInfoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
        String userInfoText = "欢迎您，";
        JMenuBar topBar = new JMenuBar();
        topBar.setBackground(Color.white);
        JMenuItem userInfo = new JMenuItem(userInfoText);
        JMenuItem outlog = new JMenuItem("注销用户");
        outlog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StaffFrame.this.dispose();
                new UserLoginFrame();
            }
        });
        JMenuItem allOrder = new JMenuItem("当前权限");
        topBar.add(userInfo);
        topBar.add(allOrder);
        topBar.add(outlog);
        userInfoPanel.add(topBar);
        top.add(userInfoPanel);
        top.add(titlePanel);

        //左侧按钮
        JPanel leftButtons = new JPanel(new GridLayout(5,1,50,50));
        leftButtons.setBackground(Color.white);
        this.add(leftButtons,BorderLayout.WEST);
        JButton billBtn = new JButton("订单管理");
        billBtn.setPreferredSize(new Dimension(200,50));
        leftButtons.add(billBtn);
        JButton supplierBtn = new JButton("供应商管理");
        supplierBtn.setPreferredSize(new Dimension(200,50));
        leftButtons.add(supplierBtn);
        JButton userButton = new JButton("用户管理");
        userButton.setPreferredSize(new Dimension(200,50));
        leftButtons.add(userButton);
        JButton itemBtn = new JButton("商品管理");
        itemBtn.setPreferredSize(new Dimension(200,50));
        leftButtons.add(itemBtn);
        JButton exitBtn = new JButton("退出系统");
        exitBtn.setPreferredSize(new Dimension(200,50));
        leftButtons.add(exitBtn);

        setVisible(true);
    }

    public static void main(String[] args) {
        new StaffFrame();
    }
}
