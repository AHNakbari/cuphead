package controller.transition;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import model.Images;
import model.component.Bird;

import java.util.ArrayList;

public class MiniBossAnimation extends Transition {

    private ArrayList<Bird> allEnemyObjects;
    private int pos;
    private boolean isPurple;
    private Bird bird;
    private int upAndDown;
    private static Images images;

    public MiniBossAnimation(int pos, boolean isPurple, AnchorPane root, ArrayList<Bird> objects, Images images){
        MiniBossAnimation.images = images;
        allEnemyObjects = objects;
        upAndDown = 0;
        this.setCycleDuration(Duration.millis(600));
        this.setCycleCount(-1);
        ImageView imageView = new ImageView();
        this.bird = new Bird(imageView, !isPurple, 60, false, false);
        allEnemyObjects.add(bird);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        root.getChildren().add(imageView);
        this.isPurple = isPurple;
        this.pos = pos;
        initialiseImages();
    }

    private void initialiseImages(){
        if (pos == 1) bird.getImageView().setLayoutY(50);
        else if (pos == 3) bird.getImageView().setLayoutY(340);
        else bird.getImageView().setLayoutY(180);
        bird.getImageView().setLayoutX(1050);
    }

    @Override
    protected void interpolate(double v) {
        int frame = (int) Math.floor(v * 16);
        if (bird.isExist()) {
            if (isPurple) {
                bird.getImageView().setImage(images.pinkBirdFly[frame]);
            } else {
                bird.getImageView().setImage(images.yellowBirdFly[frame]);
            }
            bird.getImageView().setLayoutX(bird.getImageView().getLayoutX() - 2);
            if (upAndDown < 30) {
                bird.getImageView().setLayoutY(bird.getImageView().getLayoutY() - 1);
            } else {
                bird.getImageView().setLayoutY(bird.getImageView().getLayoutY() + 1);
            }
            upAndDown++;
            if (upAndDown == 60) {
                upAndDown = 0;
            }
        } else this.stop();
    }
}
