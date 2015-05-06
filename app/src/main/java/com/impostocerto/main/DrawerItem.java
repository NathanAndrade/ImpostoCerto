package com.impostocerto.main;

public class DrawerItem {
    
    String ItemName;
    int imgResID;
    private int id;
    
    public DrawerItem(int id, String itemName, int imgResID) {
        super();
        this.id = id;
        this.ItemName = itemName;
        this.imgResID = imgResID;
    }
    
    public DrawerItem(int id, String itemName) {
        super();
        this.id = id;
        this.ItemName = itemName;
        this.imgResID = -1;
    }
    
    public String getItemName() {
        return ItemName;
    }
    
    public void setItemName(String itemName) {
        ItemName = itemName;
    }
    
    public int getImgResID() {
        return imgResID;
    }
    
    public void setImgResID(int imgResID) {
        this.imgResID = imgResID;
    }
    
    public int getId() {
        return this.id;
    }
    
}
