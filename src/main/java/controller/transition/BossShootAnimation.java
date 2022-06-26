package controller.transition;

import javafx.animation.Transition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import model.Images;
import model.component.Bird;
import model.component.Boss;
import model.component.Egg;

import java.util.ArrayList;

public class BossShootAnimation extends Transition {

    private AnchorPane root;
    private ArrayList<Bird> allEnemyObjects;
    private static Images images;
    private Boss boss;

    public BossShootAnimation(AnchorPane root, ArrayList<Bird> allEnemyObjects, Images images, Boss boss) {
        this.setCycleDuration(Duration.millis(1200));
        this.boss = boss;
        BossShootAnimation.images = images;
        this.root = root;
        this.allEnemyObjects = allEnemyObjects;
    }

    @Override
    protected void interpolate(double v) {
        int frame = (int) Math.floor(v * 11);
        if (frame == 5 && boss.getEgg() == null){
            Egg egg = new Egg(new ImageView(), false, 100, false, 200, false);
            EggMoveAnimation eggMoveAnimation = new EggMoveAnimation(root, allEnemyObjects, images, boss, egg);
            eggMoveAnimation.play();
            boss.setEgg(egg);
        }
        boss.getImageView().setImage(images.bossShoot[frame]);
        if (v == 1)boss.setShoot(false);
    }
}
