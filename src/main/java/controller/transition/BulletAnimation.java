package controller.transition;

import javafx.animation.Transition;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import model.GameData;
import model.Images;
import model.component.Bird;
import model.component.Bullet;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class BulletAnimation extends Transition {

    private ArrayList<Bullet> bullets;
    private ArrayList<Bird> allEnemyObjects;
    private static AnchorPane root;
    private Scene scene;
    private static Images images;
    private GameData gameData;
    private MediaPlayer mediaPlayer;

    public BulletAnimation(AnchorPane root, Scene scene, ArrayList<Bird> objects, Images images, GameData gameData){
        this.gameData = gameData;
        BulletAnimation.images = images;
        allEnemyObjects = objects;
        this.setCycleDuration(Duration.millis(100));
        this.setCycleCount(-1);
        BulletAnimation.root = root;
        bullets = new ArrayList<>();
        this.scene = scene;
    }

    public void addBullet(double x, double y){
        AudioClip audioClip = new AudioClip(Objects.requireNonNull(getClass().getResource("/Media/BulletSound.mpeg")).toExternalForm());
        audioClip.play();
        if (bullets.size() > 200){
            for (int i = 0; i < 50; i++)bullets.remove(bullets.get(i));
        }
        ImageView bulletView = new ImageView(images.bulletImage);
        Bullet bullet = new Bullet(bulletView, 10 - ((gameData.getActiveUser().getDifficulty() - 2) * 5), false);
        bulletView.setFitWidth(35);
        bulletView.setFitHeight(15);
        switch (bullets.size() % 6){
            case 0:
            case 4:
                bulletView.setLayoutX(x);
                bulletView.setLayoutY(y - 12);
                break;
            case 1:
            case 3:
                bulletView.setLayoutX(x);
                bulletView.setLayoutY(y + 12);
                break;
            case 5:
            case 2:
                bulletView.setLayoutX(x);
                bulletView.setLayoutY(y);
                break;
        }
        root.getChildren().add(bulletView);
        bullets.add(bullet);
        shootEffectOnAirPlane(x, y);
    }

    private void shootEffectOnAirPlane(double x, double y){
        ImageView imageView = new ImageView();
        imageView.setLayoutY(y - 18);
        imageView.setLayoutX(x + 38);
        root.getChildren().add(imageView);
        ShootEffect shootEffect = new ShootEffect(imageView, images, root);
        shootEffect.play();
    }

    @Override
    protected void interpolate(double v) {
        for (Bullet bullet : bullets) {
            if (bullet.isExist())
            bullet.getImageView().setLayoutX(bullet.getImageView().getLayoutX() + 9);
        }
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

    public void addBomb(double x, double y){

    }
}
