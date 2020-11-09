package com.yjp.gui.user.util;

import com.yjp.entity.Brand;
import com.yjp.service.IObjectService;
import factory.ObjectFactory;

import javax.swing.*;
import java.util.List;


//获得品牌的JComboBox
public class JComboBoxUtil {

    private IObjectService service= (IObjectService) ObjectFactory.getObject("IObjectService");
    static List<Brand> list;
    static {
        IObjectService service = (IObjectService) ObjectFactory.getObject("IObjectService");
    }

    public JComboBox getComboBox(){
        List<Brand> list = service.listAllBrand();
        Object[] datas = new Object[list.size()+1];
        int i = 0;
        datas[0] = "全部";
        for (Brand b :
                list) {
            datas[i+1] = b.getBrandName();
            i ++;
        }
        JComboBox jcbBrand = new JComboBox(datas);
        return jcbBrand;
    }
}
