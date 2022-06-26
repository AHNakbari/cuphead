package model.component;

import javafx.scene.image.ImageView;

public class Egg extends Bird{

    private int damage;
    private boolean isExplode;

    public Egg(ImageView imageView, boolean isYellow, int HP, boolean isBoss, int damage, boolean isExplode) {
        super(imageView, isYellow, HP + 20000, isBoss, true);
        this.damage = damage;
        this.isExplode = isExplode;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isExplode() {
        return isExplode;
    }

    public void setExplode(boolean explode) {
        isExplode = explode;
    }


}
