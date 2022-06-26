package model.component;

import javafx.scene.image.ImageView;

public class Boss extends Bird{
    private int damage;
    private ImageView imageView2;
    private ImageView imageView3;
    private boolean shoot;
    private Egg egg;

    public Boss(ImageView imageView, boolean isYellow, int HP, int damage) {
        super(imageView, isYellow, HP, true, false);
        shoot = false;
        this.damage = damage;
        imageView2 = new ImageView();
        imageView3 = new ImageView();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public ImageView getImageView2() {
        return imageView2;
    }

    public void setImageView2(ImageView imageView2) {
        this.imageView2 = imageView2;
    }

    public ImageView getImageView3() {
        return imageView3;
    }

    public void setImageView3(ImageView imageView3) {
        this.imageView3 = imageView3;
    }

    public boolean isShoot() {
        return shoot;
    }

    public void setShoot(boolean shoot) {
        this.shoot = shoot;
    }

    public Egg getEgg() {
        return egg;
    }

    public void setEgg(Egg egg) {
        this.egg = egg;
    }
}
