package com.yjp.entity;

public class Item {
    private int itemId;
    private String itemName;
    private String itemBrand;
    private int itemPrice;
    private String itemSupplier;
    private int itemStock;
    private String itemPic;

    public Item() {
    }

    public Item(int itemId, String itemName, String itemBrand, int itemPrice, String itemSupplier, int itemStock, String itemPic) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemBrand = itemBrand;
        this.itemPrice = itemPrice;
        this.itemSupplier = itemSupplier;
        this.itemStock = itemStock;
        this.itemPic = itemPic;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemBrand() {
        return itemBrand;
    }

    public void setItemBrand(String itemBrand) {
        this.itemBrand = itemBrand;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemSupplier() {
        return itemSupplier;
    }

    public void setItemSupplier(String itemSupplier) {
        this.itemSupplier = itemSupplier;
    }

    public int getItemStock() {
        return itemStock;
    }

    public void setItemStock(int itemStock) {
        this.itemStock = itemStock;
    }

    public String getItemPic() {
        return itemPic;
    }

    public void setItemPic(String itemPic) {
        this.itemPic = itemPic;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemBrand='" + itemBrand + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemSupplier='" + itemSupplier + '\'' +
                ", itemStock=" + itemStock +
                ", itemPic='" + itemPic + '\'' +
                '}';
    }
}
