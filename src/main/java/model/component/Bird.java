package model.component;

import javafx.scene.image.ImageView;

public class Bird {
    private ImageView imageView;
    private int HP;
    private boolean exist;
    private boolean isYellow;
    private boolean isBoss;
    private boolean isEgg;

    public Bird(ImageView imageView, boolean isYellow, int HP, boolean isBoss, boolean isEgg){
        this.isEgg = isEgg;
        this.isBoss = isBoss;
        this.isYellow = isYellow;
        exist = true;
        this.HP = HP;
        if (!isYellow)this.HP += 20;
        this.imageView = imageView;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public boolean isYellow() {
        return isYellow;
    }

    public boolean isBoss() {
        return isBoss;
    }

    public void setYellow(boolean yellow) {
        isYellow = yellow;
    }

    public boolean isEgg() {
        return isEgg;
    }
}
