package com.yjp.gui;


import com.yjp.entity.Staff;
import com.yjp.gui.admin.StaffFrame;
import com.yjp.service.IObjectService;
import factory.ObjectFactory;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StaffLoginFrame extends JFrame {
    private IObjectService service = (IObjectService) ObjectFactory.getObject("IObjectService");
    public StaffLoginFrame(){
        this.setTitle("请登录");
        this.setSize(600, 300);
        //屏幕中央显示
        int x = (int)(this.getToolkit().getScreenSize().getWidth()-this.getWidth())/2;
        int y = (int)(this.getToolkit().getScreenSize().getHeight()-this.getHeight())/2;
        this.setLocation(x,y);

        //顶部标题
        JPanel topPanel = new JPanel();
        this.add(topPanel, BorderLayout.NORTH);
        JLabel jlTitle = new JLabel("欢迎使用后台管理系统");
        Font titleFont = new Font("微软雅黑", Font.BOLD,40);
        jlTitle.setBackground(Color.white);
        jlTitle.setFont(titleFont);
        topPanel.add(jlTitle,BorderLayout.CENTER);

        //用户名密码填写
        JPanel inputPanel = new JPanel(new GridLayout(3,1));
        this.add(inputPanel,BorderLayout.CENTER);
        //用户名
        JPanel usernamePanel = new JPanel();
        inputPanel.add(usernamePanel);
        JLabel usernameLable = new JLabel("用户名：");
        JTextField usernameJtf = new JTextField(40);
        usernamePanel.add(usernameLable);
        usernamePanel.add(usernameJtf);
        //密码
        JPanel passwordPanel = new JPanel();
        inputPanel.add(passwordPanel);
        JLabel passwordLable = new JLabel("密 码：");
        JTextField passwordJtf = new JTextField(40);
        passwordPanel.add(passwordLable);
        passwordPanel.add(passwordJtf);
        //职位
        JPanel positionPanel = new JPanel();
        inputPanel.add(positionPanel);
        JLabel positionLable = new JLabel("身 份：");
        String[] position = new String[2];
        position[0] = "平台管理员";
        position[1] = "供应商";
        JComboBox positionJcb = new JComboBox(position);
        positionPanel.add(positionLable);
        positionPanel.add(positionJcb);

        //登陆按钮
        JButton loginButton = new JButton("登陆");
        this.add(loginButton, BorderLayout.SOUTH);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Staff> list;
                String username = usernameJtf.getText().trim();
                if (username == null){
                    JOptionPane.showMessageDialog(StaffLoginFrame.this,"用户名不得为空！");
                    return;
                }
                String password = passwordJtf.getText().trim();
                if (password == null){
                    JOptionPane.showMessageDialog(StaffLoginFrame.this,"密码不得为空！");
                    return;
                }
                if (positionJcb.getSelectedItem().equals("平台管理员")){
                    list = service.adminLoginCheck(username,password);
                    if (list.size() > 0){
                        JOptionPane.showMessageDialog(StaffLoginFrame.this,"登陆成功");
                        StaffLoginFrame.this.dispose();
                        new StaffFrame();
                    }else {
                        JOptionPane.showMessageDialog(StaffLoginFrame.this,"输入有误！");
                        return;
                    }
                }
            }
        });







        this.setVisible(true);
    }

    public static void main(String[] args) {
        new StaffLoginFrame();
    }
}
