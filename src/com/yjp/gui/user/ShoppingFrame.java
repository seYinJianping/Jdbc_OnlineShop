package com.yjp.gui.user;

import com.yjp.entity.User;
import com.yjp.gui.UserLoginFrame;
import com.yjp.gui.user.util.ItemPanelUtil;
import com.yjp.gui.user.util.JComboBoxUtil;
import com.yjp.service.IObjectService;
import factory.ObjectFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//用户购买主界面
public class ShoppingFrame extends JFrame {
    private IObjectService service = (IObjectService) ObjectFactory.getObject("IObjectService");
    List list = null;
    JComboBox jcbBrand;
    JScrollPane jScrollPane;
    JPanel itemPanel = new JPanel();
    public ShoppingFrame(User user){
        User tempUser = user;
        setSize(800,600);
        setTitle("买手机，就到韭菜商城！");
        int x = (int) ((getToolkit().getScreenSize().getWidth()-this.getWidth())/2);
        int y = (int) ((getToolkit().getScreenSize().getHeight()-this.getHeight())/2);
        setLocation(x,y);

        //顶部标题
        JPanel top = new JPanel(new GridLayout(2,1));
        this.add(top, BorderLayout.NORTH);
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.white);
        JLabel topTitle = new JLabel("欢迎来到在线商城");
        Font titleFont = new Font("微软雅黑",Font.BOLD,40);
        topTitle.setFont(titleFont);
        titlePanel.add(topTitle);
        JPanel userInfoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
        String userInfoText = "欢迎您，"+tempUser.getUserName()+"!";
//        JLabel userInfoLabel = new JLabel(userInfoText);
        JMenuBar topBar = new JMenuBar();
        topBar.setBackground(Color.white);
        JMenuItem userInfo = new JMenuItem(userInfoText);
        JMenuItem outlog = new JMenuItem("注销用户");
        outlog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShoppingFrame.this.dispose();
                new UserLoginFrame();
            }
        });
        JMenuItem allOrder = new JMenuItem("查看所有订单");
        topBar.add(userInfo);
        topBar.add(allOrder);
        topBar.add(outlog);
        userInfoPanel.add(topBar);
        top.add(userInfoPanel);
        top.add(titlePanel);

        //中部Panel
        JPanel jpMid = new JPanel(new BorderLayout());
        this.add(jpMid,BorderLayout.CENTER);


        //商品筛选
        JPanel jPanelChoose = new JPanel(new FlowLayout(FlowLayout.LEFT,30,30));
        jpMid.add(jPanelChoose,BorderLayout.NORTH);
        JLabel jLabelBrand = new JLabel("品牌：");
        jPanelChoose.add(jLabelBrand);
        jcbBrand = new JComboBoxUtil().getComboBox();
        jPanelChoose.add(jcbBrand);
        JButton searchBtn = new JButton("按品牌信息查找");
        jPanelChoose.add(searchBtn);
//        JButton refreshBtn = new JButton("刷新");
//        jPanelChoose.add(refreshBtn,new FlowLayout(FlowLayout.RIGHT));



        //商品显示模块
        int itemCount = new ItemPanelUtil().getItemCount();

        System.out.println(itemCount);
        itemPanel = new ItemPanelUtil().getItemPanel(tempUser);
        jScrollPane = new JScrollPane(itemPanel);
//        JPanel jPanel = new JPanel();
        jpMid.add(jScrollPane,BorderLayout.CENTER);


        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel newItemPanel;
                String brandChoose = jcbBrand.getSelectedItem().toString();
                if (brandChoose.equals("全部")) {
                    newItemPanel = new ItemPanelUtil().getItemPanel(tempUser);
                } else {
                    newItemPanel = new ItemPanelUtil().getItemByBrand(tempUser,brandChoose);
                }
                itemPanel.removeAll();
                itemPanel.add(newItemPanel);
                itemPanel.updateUI();
            }
        });

        setVisible(true);
    }

//    public ShoppingFrame(JPanel newPanel){
//        itemPanel.removeAll();
//        itemPanel.add(newPanel);
//        itemPanel.updateUI();
//    }

}
