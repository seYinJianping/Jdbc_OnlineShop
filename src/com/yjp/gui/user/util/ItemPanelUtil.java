package com.yjp.gui.user.util;

import com.yjp.entity.Item;
import com.yjp.entity.User;
import com.yjp.gui.user.BuyFrame;
import com.yjp.service.IObjectService;
import com.yjp.transaction.ITransaction;
import factory.ObjectFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ItemPanelUtil {
    IObjectService service = (IObjectService) ObjectFactory.getObject("IObjectService");
    static List<Item> list;
    static {
        IObjectService service = (IObjectService) ObjectFactory.getObject("IObjectService");
    }


    //获取所有的商品
    public List<Item> getAllItemList(){
        List<Item> list = service.listAllItem();
        return list;
    }

    //获取商品的数量
    public int getItemCount(){
        List<Item> list;
        list = service.listAllItem();
        return list.size();
    }

    //返回全部商品界面
    public JPanel getItemPanel(User user){
        List<Item> list;
        list = service.listAllItem();
        JPanel panel = addTools(user,list);
//        System.out.println(list);
//        JPanel itemPanel = new JPanel(new GridLayout(list.size()/3 + 1,3,10,10));
//        JPanel[] singlePanels = new JPanel[list.size()];
//        JPanel[] picPanel = new JPanel[list.size()];
//        ImageIcon[] singleImage = new ImageIcon[list.size()];
//        JLabel[] itemPic = new JLabel[list.size()];
//        JPanel[] itemInfoPanel = new JPanel[list.size()];
//        JLabel[] itemInfo = new JLabel[list.size()];
//        JPanel[] itemPricePanel = new JPanel[list.size()];
//        JLabel[] itemPrice = new JLabel[list.size()];
//        JPanel[] buttonPanel = new JPanel[list.size()];
//        JButton[] buyButton = new JButton[list.size()];
//
//        int i = 0;
//        for (Item item :
//                list) {
//            singleImage[i] = new ImageIcon(item.getItemPic());
//            singleImage[i].setImage(singleImage[i].getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
//            itemPic[i] = new JLabel(singleImage[i]);
//            itemInfo[i] = new JLabel(item.getItemBrand() + " " + item.getItemName());
//            itemPrice[i] = new JLabel("$" + item.getItemPrice());
//            if (item.getItemStock() >= 0){
//                buyButton[i] = new JButton("立即购买");
//                buyButton[i].addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        Item itemBuy = item;
//                        new BuyFrame(itemBuy,tempUser);
//                    }
//                });
//            } else {
//                buyButton[i] = new JButton("暂时无货");
//                buyButton[i].setEnabled(false);
//            }
//            picPanel[i] = new JPanel();
//            picPanel[i].setBackground(Color.white);
//            itemInfoPanel[i] = new JPanel();
//            itemInfoPanel[i].setBackground(Color.white);
//            itemPricePanel[i] = new JPanel();
//            itemPricePanel[i].setBackground(Color.white);
//            buttonPanel[i] = new JPanel();
//            buttonPanel[i].setBackground(Color.white);
//            picPanel[i].add(itemPic[i]);
//            itemInfoPanel[i].add(itemInfo[i]);
//            itemPricePanel[i].add(itemPrice[i]);
//            buttonPanel[i].add(buyButton[i]);
//            JPanel infoPanel = new JPanel(new GridLayout(2,1));
//            infoPanel.add(itemInfoPanel[i]);
//            infoPanel.add(itemPricePanel[i]);
//            singlePanels[i] = new JPanel(new BorderLayout());
//            singlePanels[i].setBackground(Color.white);
//            singlePanels[i].add(picPanel[i],BorderLayout.NORTH);
//            singlePanels[i].add(infoPanel,BorderLayout.CENTER);
//            singlePanels[i].add(buttonPanel[i],BorderLayout.SOUTH);
//
//            itemPanel.add(singlePanels[i]);
//            i++;
//        }
        return panel;
    }


    //获取品牌过滤后的商品
    public JPanel getItemByBrand(User user,String brandName){
        List<Item> list;
        list = service.getItemByBrand(brandName);
        JPanel jPanel = addTools(user,list);
        return jPanel;
    }

    //添加组件
    public JPanel addTools(User user,List list){
        User tempUser = user;
        List<Item> itemList = list;
        JPanel itemPanel = new JPanel(new GridLayout(list.size()/3 + 1,3,10,10));
        JPanel[] singlePanels = new JPanel[list.size()];
        JPanel[] picPanel = new JPanel[list.size()];
        ImageIcon[] singleImage = new ImageIcon[list.size()];
        JLabel[] itemPic = new JLabel[list.size()];
        JPanel[] itemInfoPanel = new JPanel[list.size()];
        JLabel[] itemInfo = new JLabel[list.size()];
        JPanel[] itemPricePanel = new JPanel[list.size()];
        JLabel[] itemPrice = new JLabel[list.size()];
        JPanel[] buttonPanel = new JPanel[list.size()];
        JButton[] buyButton = new JButton[list.size()];

        int i = 0;
        for (Item item :
                itemList) {
            singleImage[i] = new ImageIcon(item.getItemPic());
            singleImage[i].setImage(singleImage[i].getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
            itemPic[i] = new JLabel(singleImage[i]);
            itemInfo[i] = new JLabel(item.getItemBrand() + " " + item.getItemName());
            itemPrice[i] = new JLabel("$" + item.getItemPrice());
            if (item.getItemStock() >= 0){
                buyButton[i] = new JButton("立即购买");
                buyButton[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Item itemBuy = item;
                        new BuyFrame(itemBuy,tempUser);
                    }
                });
            } else {
                buyButton[i] = new JButton("暂时无货");
                buyButton[i].setEnabled(false);
            }
            picPanel[i] = new JPanel();
            picPanel[i].setBackground(Color.white);
            itemInfoPanel[i] = new JPanel();
            itemInfoPanel[i].setBackground(Color.white);
            itemPricePanel[i] = new JPanel();
            itemPricePanel[i].setBackground(Color.white);
            buttonPanel[i] = new JPanel();
            buttonPanel[i].setBackground(Color.white);
            picPanel[i].add(itemPic[i]);
            itemInfoPanel[i].add(itemInfo[i]);
            itemPricePanel[i].add(itemPrice[i]);
            buttonPanel[i].add(buyButton[i]);
            JPanel infoPanel = new JPanel(new GridLayout(2,1));
            infoPanel.add(itemInfoPanel[i]);
            infoPanel.add(itemPricePanel[i]);
            singlePanels[i] = new JPanel(new BorderLayout());
            singlePanels[i].setBackground(Color.white);
            singlePanels[i].add(picPanel[i],BorderLayout.NORTH);
            singlePanels[i].add(infoPanel,BorderLayout.CENTER);
            singlePanels[i].add(buttonPanel[i],BorderLayout.SOUTH);

            itemPanel.add(singlePanels[i]);
            i++;
        }
        return itemPanel;
    }
}
