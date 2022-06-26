package controller.transition;

import javafx.animation.Transition;
import javafx.util.Duration;
import model.Images;
import model.component.Bullet;

public class BulletCollisionAnimation extends Transition {

    private Bullet bullet;
    private static Images images;

    public BulletCollisionAnimation(Bullet bullet, Images images){
        BulletCollisionAnimation.images = images;
        this.setCycleDuration(Duration.millis(200));
        this.bullet = bullet;
    }

    @Override
    protected void interpolate(double v) {
        int frame = (int) Math.floor(v * 11);
        bullet.getImageView().setImage(images.bulletCollision[frame]);
    }
}
