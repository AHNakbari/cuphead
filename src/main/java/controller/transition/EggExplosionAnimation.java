package controller.transition;

import javafx.animation.Transition;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import model.Images;
import model.component.Bird;
import model.component.Boss;
import model.component.Egg;

import java.util.ArrayList;

public class EggExplosionAnimation extends Transition {

    private AnchorPane root;
    private ArrayList<Bird> allEnemyObjects;
    private static Images images;
    private Egg egg;
    private Boss boss;

    public EggExplosionAnimation(AnchorPane root, ArrayList<Bird> allEnemyObjects, Images images, Egg egg, Boss boss) {
        this.boss = boss;
        this.egg = egg;
        this.setCycleDuration(Duration.millis(400));
        EggExplosionAnimation.images = images;
        this.root = root;
        this.allEnemyObjects = allEnemyObjects;
        egg.getImageView().setFitWidth(120);
        egg.getImageView().setFitHeight(120);
        egg.getImageView().setLayoutX(egg.getImageView().getLayoutX() - 30);
        egg.setExplode(true);
    }
    @Override
    protected void interpolate(double v) {
        int frame = (int) Math.floor(v * 8);
        egg.getImageView().setImage(images.eggExplosion[frame]);
        if (v == 1){
            root.getChildren().remove(egg.getImageView());
            boss.setEgg(null);
        }
    }
}
