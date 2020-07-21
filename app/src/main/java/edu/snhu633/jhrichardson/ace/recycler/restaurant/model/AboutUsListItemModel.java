package edu.snhu633.jhrichardson.ace.recycler.restaurant.model;

public class AboutUsListItemModel {

    private int listItemIconId;
    private String listItemTitle;
    private String listItemBluff;

    public AboutUsListItemModel ( int listItemIcon, String listItemTitle, String listItemBluff) {
        this.listItemIconId = listItemIcon;
        this.listItemTitle = listItemTitle;
        this.listItemBluff = listItemBluff;
    }

    public int getListItemIconId() {
        return listItemIconId;
    }

    public String getListItemTitle() {
        return listItemTitle;
    }

    public String getListItemBluff() {
        return listItemBluff;
    }

    public void setListItemBluff(String listItemBluff) {
        this.listItemBluff = listItemBluff;
    }

    public void setListItemIconId(int listItemIconId) {
        this.listItemIconId = listItemIconId;
    }

    public void setListItemTitle(String listItemTitle) {
        this.listItemTitle = listItemTitle;
    }
}
