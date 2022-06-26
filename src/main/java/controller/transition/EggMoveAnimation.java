package controller.transition;

import javafx.animation.Transition;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import model.Images;
import model.component.Bird;
import model.component.Boss;
import model.component.Egg;

import java.util.ArrayList;

public class EggMoveAnimation extends Transition {

    private AnchorPane root;
    private ArrayList<Bird> allEnemyObjects;
    private static Images images;
    private Boss boss;
    private Egg egg;

    public EggMoveAnimation(AnchorPane root, ArrayList<Bird> allEnemyObjects, Images images, Boss boss, Egg egg) {
        this.egg = egg;
        this.setCycleDuration(Duration.millis(1200));
        this.boss = boss;
        EggMoveAnimation.images = images;
        this.root = root;
        this.allEnemyObjects = allEnemyObjects;
        allEnemyObjects.add(egg);
        root.getChildren().add(egg.getImageView());
        egg.getImageView().setFitHeight(90);
        egg.getImageView().setFitWidth(90);
        egg.getImageView().setLayoutX(boss.getImageView().getLayoutX());
        egg.getImageView().setLayoutY(boss.getImageView().getLayoutY() + 50);
    }

    @Override
    protected void interpolate(double v) {
        int frame = (int) Math.floor(v * 31);
        if (!egg.isExplode()) {
            egg.getImageView().setImage(images.eggMove[frame]);
            egg.getImageView().setLayoutX(egg.getImageView().getLayoutX() - 16);
            egg.getImageView().setLayoutY(egg.getImageView().getLayoutY() + 3);
            if (v == 1) {
                boss.setEgg(null);
            }
        }
    }
}
