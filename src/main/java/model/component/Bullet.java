package model.component;

import javafx.scene.image.ImageView;

public class Bullet {
    private ImageView imageView;
    private int damage;
    private boolean exist;
    private boolean isBomb;

    public Bullet(ImageView imageView, int damage, boolean isBomb){
        this.isBomb = isBomb;
        exist = true;
        this.imageView = imageView;
        if (!isBomb) this.damage = damage;
        else this.damage = damage * 2;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }
}
