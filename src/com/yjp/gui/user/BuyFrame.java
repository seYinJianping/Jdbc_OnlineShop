package com.yjp.gui.user;


import com.yjp.entity.Item;
import com.yjp.entity.Order;
import com.yjp.entity.User;
import com.yjp.gui.user.util.ItemPanelUtil;
import com.yjp.service.IObjectService;
import factory.ObjectFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuyFrame extends JFrame {
    IObjectService service = (IObjectService) ObjectFactory.getObject("IObjectService");
    public BuyFrame(Item itemBuy, User tempUser){
        setSize(600,400);
        setTitle("请填写订单");
        int x = (int) ((getToolkit().getScreenSize().getWidth()-this.getWidth())/2);
        int y = (int) ((getToolkit().getScreenSize().getHeight()-this.getHeight())/2);
        setLocation(x,y);


        //商品图片以及信息
        JPanel topInfo = new JPanel(new BorderLayout());
        this.add(topInfo,BorderLayout.NORTH);
        //图片
        JLabel topBlank = new JLabel("填写订单，即刻订购！");
        topInfo.add(topBlank,BorderLayout.NORTH);
        ImageIcon itemPic = new ImageIcon(itemBuy.getItemPic());
        itemPic.setImage(itemPic.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT));
        JLabel itemPicLable = new JLabel(itemPic);
        topInfo.add(itemPicLable,BorderLayout.CENTER);
        JPanel mainInfoPanel = new JPanel();
        JLabel mainInfo = new JLabel(itemBuy.getItemName() + "的当前售价为 $" + itemBuy.getItemPrice() + " ,将由 " + itemBuy.getItemSupplier() + " 为您提供服务。");
        mainInfoPanel.add(mainInfo);
        topInfo.add(mainInfoPanel,BorderLayout.SOUTH);


        //中部填写部位
        JPanel buyerInfo = new JPanel(new GridLayout(4,1));
        this.add(buyerInfo,BorderLayout.CENTER);
        //购买数量
        JPanel itemCount = new JPanel();
        JLabel countLable = new JLabel("数量：");
        JLabel itemStock = new JLabel("当前库存：" + itemBuy.getItemStock());
        JTextField countJtf = new JTextField(2);
        itemCount.add(countLable);
        itemCount.add(countJtf);
        itemCount.add(itemStock);
        buyerInfo.add(itemCount);
        //姓名栏
        JPanel buyerName = new JPanel();
        JLabel nameLable = new JLabel("姓名：");
        JTextField nameJtf = new JTextField(40);
        buyerName.add(nameLable);
        buyerName.add(nameJtf);
        buyerInfo.add(buyerName);
        //电话栏
        JPanel buyerTel = new JPanel();
        JLabel telLable = new JLabel("电话：");
        JTextField telJtf = new JTextField(40);
        buyerTel.add(telLable);
        buyerTel.add(telJtf);
        buyerInfo.add(buyerTel);
        //地址栏
        JPanel buyerAdd = new JPanel();
        JLabel addLable = new JLabel("地址：");
        JTextField addJtf = new JTextField(40);
        buyerAdd.add(addLable);
        buyerAdd.add(addJtf);
        buyerInfo.add(buyerAdd);


        //底部按钮
        JPanel buyButton = new JPanel();
        this.add(buyButton,BorderLayout.SOUTH);
        JButton buyBtn = new JButton("提交订单");
        buyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //判断库存合法性
                Pattern countP = Pattern.compile("^[0-9]*$");
                Matcher isNum = countP.matcher(countJtf.getText());
                if (countJtf.getText() != null) {
                    if (!isNum.matches()) {
                        JOptionPane.showMessageDialog(BuyFrame.this, "填入的数量必须是数字！");
                        return;
                    }else {
                        int count = Integer.parseInt(countJtf.getText());
                        if (count >= itemBuy.getItemStock()){
                            JOptionPane.showMessageDialog(BuyFrame.this,"库存不足!");
                            return;
                        }
                    }
                }else {
                    JOptionPane.showMessageDialog(BuyFrame.this,"请输入购买数量！");
                    return;
                }


                //判断姓名是否为空
                if (nameJtf.getText() == null){
                    JOptionPane.showMessageDialog(BuyFrame.this,"姓名不能为空！");
                    return;
                }

                //判断电话号码合法性
                Pattern telP = Pattern.compile("^([1][3,4,5,6,7,8,9])\\d{9}$");
                Matcher isTel = telP.matcher(telJtf.getText());
                if (telJtf.getText() != null){
                    if (!isTel.matches()){
                        JOptionPane.showMessageDialog(BuyFrame.this,"电话号码非法！");
                        return;
                    }
                }else {
                    JOptionPane.showMessageDialog(BuyFrame.this,"电话不能为空！");
                    return;
                }

                //判断地址是否为空
                if (addJtf.getText() == null){
                    JOptionPane.showMessageDialog(BuyFrame.this,"地址不能为空！");
                    return;
                }

                //在数据库中创建订单
                Order order = new Order();
                order.setOrderAccount(tempUser.getUserName());
                order.setOrderName(nameJtf.getText());
                order.setOrderTel(telJtf.getText());
                order.setOrderAdd(addJtf.getText());
                order.setOrderItemBrand(itemBuy.getItemBrand());
                order.setOrderItemName(itemBuy.getItemName());
                order.setOrderCount(Integer.parseInt(countJtf.getText()));
                order.setOrderBill(Integer.parseInt(countJtf.getText()) * itemBuy.getItemPrice());
                int result = service.createNewOrder(order);
                if (result != -1){
                    int resultStock = service.updateItemStock(order);
                    JOptionPane.showMessageDialog(BuyFrame.this,"购买成功！");
                    BuyFrame.this.dispose();
                }
            }
        });
        JButton buyCancel = new JButton("取消订单");
        buyCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuyFrame.this.dispose();
            }
        });
        buyButton.add(buyBtn);
        buyButton.add(buyCancel);







        setVisible(true);
    }


}
