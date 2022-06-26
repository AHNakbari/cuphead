package controller.transition;

import javafx.animation.Transition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import model.Images;

public class VictoryAnimation extends Transition {

    private static Images images;
    private ImageView imageView;

    public VictoryAnimation(Images images, AnchorPane root){
        imageView = new ImageView();
        root.getChildren().add(imageView);
        imageView.setFitHeight(420);
        imageView.setFitWidth(1000);
        imageView.setLayoutX(0);
        this.setCycleDuration(Duration.millis(5000));
        VictoryAnimation.images = images;
    }


    @Override
    protected void interpolate(double v) {
        int frame = (int) Math.floor(v * 26);
        imageView.setImage(images.victory[frame]);
    }
}
