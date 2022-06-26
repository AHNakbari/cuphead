package model.component;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AirPlane {
    private int score;
    private ImageView imageView;
    private int HP;
    private int lives;
    private boolean isExist;

    public AirPlane(ImageView imageView, int lives){
        isExist = true;
        this.imageView = imageView;
        HP = 1;
        this.lives = lives;
    }

    public void setImageView(ImageView imageView) {
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

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isExist() {
        return isExist;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }
}
