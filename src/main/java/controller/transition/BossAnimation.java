package controller.transition;

import javafx.animation.Transition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import model.GameData;
import model.Images;
import model.component.Bird;
import model.component.Boss;

import java.util.ArrayList;

public class BossAnimation extends Transition {

    private AnchorPane root;
    private ArrayList<Bird> allEnemyObjects;
    private static Images images;
    private Boss boss;
    private boolean goUp;

    public BossAnimation(GameData gameData, AnchorPane root, ArrayList<Bird> objects, Images images, Boss boss){
        goUp = true;
        this.setCycleDuration(Duration.millis(260));
        this.setCycleCount(-1);
        this.setAutoReverse(true);
        BossAnimation.images = images;
        this.root = root;
        this.allEnemyObjects = objects;
        this.boss = boss;
        allEnemyObjects.add(boss);
        boss.getImageView().setFitHeight(240);
        boss.getImageView().setFitWidth(300);
        boss.getImageView().setLayoutX(700);
        boss.getImageView().setLayoutY(180);
        root.getChildren().add(boss.getImageView());
    }

    @Override
    protected void interpolate(double v) {
        int frame = (int) Math.floor(v * 5);
        if (!boss.isShoot()) {
            boss.getImageView().setImage(images.bossFly[frame]);
            if (boss.getImageView().getLayoutY() > 240) goUp = true;
            if (boss.getImageView().getLayoutY() < 1) goUp = false;
            if (goUp) {
                boss.getImageView().setLayoutY(boss.getImageView().getLayoutY() - 3);
            } else boss.getImageView().setLayoutY(boss.getImageView().getLayoutY() + 3);
        }
    }
}
