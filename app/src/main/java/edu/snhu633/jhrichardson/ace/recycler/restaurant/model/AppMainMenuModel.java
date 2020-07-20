package edu.snhu633.jhrichardson.ace.recycler.restaurant.model;

public class AppMainMenuModel {
    private String text;
    private int drawable;
    private String color;

    public AppMainMenuModel(String text, int drawable, String color) {
        this.text = text;
        this.color = color;
        this.drawable = drawable;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDrawable() {
        return drawable;
    }

    public String getColor() {
        return color;
    }

    public String getText() {
        return text;
    }
}
