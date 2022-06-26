package controller.transition;

import javafx.animation.Transition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import model.Images;

public class ShootEffect extends Transition {
    private ImageView imageView;
    private static Images images;
    private AnchorPane root;

    public ShootEffect (ImageView imageView, Images images, AnchorPane root){
        this.root = root;
        ShootEffect.images = images;
        this.imageView = imageView;
        this.setCycleDuration(Duration.millis(100));
    }
    @Override
    protected void interpolate(double v) {
        int frame = (int) Math.floor(v * 4);
        imageView.setImage(images.shootEffect[frame]);
        if (frame == 4){
            root.getChildren().remove(imageView);
        }
    }
}
