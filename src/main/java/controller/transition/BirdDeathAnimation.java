package controller.transition;

import javafx.animation.Transition;
import javafx.util.Duration;
import model.Images;
import model.component.Bird;

public class BirdDeathAnimation extends Transition {

    private static Images images;
    private boolean isYellow;
    private Bird bird;

    public BirdDeathAnimation(boolean isYellow, Images images, Bird bird){
        this.bird = bird;
        this.setCycleDuration(Duration.millis(200));
        BirdDeathAnimation.images = images;
        this.isYellow = isYellow;
    }

    @Override
    protected void interpolate(double v) {
        int frame = (int) Math.floor(v * 10);
        if (isYellow){
            bird.getImageView().setImage(images.yellowBirdDeath[frame]);
        } else {
            bird.getImageView().setImage(images.pinkBirdDeath[frame]);
        }
    }


}
