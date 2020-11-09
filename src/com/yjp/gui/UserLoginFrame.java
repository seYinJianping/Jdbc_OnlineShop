package com.yjp.gui;

import com.yjp.entity.User;
import com.yjp.gui.user.ShoppingFrame;
import com.yjp.service.IObjectService;
import factory.ObjectFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLoginFrame extends JFrame {

    private IObjectService service = (IObjectService) ObjectFactory.getObject("IObjectService");
    public UserLoginFrame(){

        setSize(400,200);
        setTitle("韭菜商城-登陆 ");
        int x = (int) ((getToolkit().getScreenSize().getWidth()-this.getWidth())/2);
        int y = (int) ((getToolkit().getScreenSize().getHeight()-this.getHeight())/2);
        setLocation(x,y);

        //顶部标题
        JPanel top = new JPanel();
        this.add(top,BorderLayout.NORTH);
        JLabel topLable = new JLabel("登陆或注册新账号");
        top.add(topLable);
        Font titleFont = new Font("微软雅黑",Font.ITALIC,30);
        topLable.setFont(titleFont);

        //输入框
        JPanel textPanel = new JPanel(new BorderLayout());
        this.add(textPanel,BorderLayout.CENTER);
        JPanel accountPanel = new JPanel();
        textPanel.add(accountPanel,BorderLayout.NORTH);
        JLabel accountLable = new JLabel("账号：");
        accountPanel.add(accountLable);
        JTextField jtfAccount = new JTextField(30);
        accountPanel.add(jtfAccount);
        JPanel passwordPanel = new JPanel();
        textPanel.add(passwordPanel,BorderLayout.CENTER);
        JLabel passwordLable = new JLabel("密码：");
        passwordPanel.add(passwordLable);
        JTextField jtfPassword = new JTextField(30);
        passwordPanel.add(jtfPassword);

        //登录注册按钮
        JPanel btnPanel = new JPanel(new GridLayout(1,2));
        this.add(btnPanel,BorderLayout.SOUTH);
        JButton btnLogin = new JButton("登陆");
        btnPanel.add(btnLogin);
        JButton btnRegister = new JButton("注册");
        btnPanel.add(btnRegister);

        //登录按钮事件
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<User> list = null;
                String username = jtfAccount.getText();
                if (username == null) {
                    JOptionPane.showMessageDialog(UserLoginFrame.this,"用户名不得为空！");
                    return;
                }
                String password = jtfPassword.getText();
                if (password == null){
                    JOptionPane.showMessageDialog(UserLoginFrame.this,"密码不能为空！");
                }
                list = service.loginCheck(username,password);
//                System.out.println(list);
                if (list.size() > 0){
                    User user = new User();
                    user.setUserId(list.get(0).getUserId());
                    user.setUserName(list.get(0).getUserName());
                    JOptionPane.showMessageDialog(UserLoginFrame.this,"登陆成功！");
                    new ShoppingFrame(user);
                    UserLoginFrame.this.dispose();
                } else if (list.size() == 0){
                    JOptionPane.showMessageDialog(UserLoginFrame.this,"无效的用户名或密码！");
                    return;
                }
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = -1;
                List list = service.registerCheck();
                String username = jtfAccount.getText();
                if (username == null){
                    JOptionPane.showMessageDialog(UserLoginFrame.this,"非法用户名！");
                    return;
                }else {
                    if (list.contains(username)){
                        JOptionPane.showMessageDialog(UserLoginFrame.this,"用户名已存在！");
                        return;
                    }
                }
                String password = jtfPassword.getText();
                if (username == null){
                    JOptionPane.showMessageDialog(UserLoginFrame.this,"密码不能为空！");
                    return;
                }else {
                    Pattern p = Pattern.compile("^[a-zA-Z]\\w{5,17}$");
                    Matcher isRight = p.matcher(password);
                    if (!isRight.matches()){
                        JOptionPane.showMessageDialog(UserLoginFrame.this,"密码开头应为字母，且在6-18位之间！");
                        return;
                    }
                }
                User user = new User();
                user.setUserName(username);
                user.setUserPassword(password);
                result = service.register(user);
                if (result != -1){
                    JOptionPane.showMessageDialog(UserLoginFrame.this,"注册成功！请重新登陆！");
                    return;
                }
            }
        });




        setVisible(true);
    }
}
