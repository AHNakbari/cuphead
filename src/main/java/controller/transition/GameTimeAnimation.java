package controller.transition;

import controller.RegisterMenuController;
import javafx.animation.Transition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.GameData;
import model.Images;
import model.component.*;
import view.MainMenu;
import view.PlayGame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class GameTimeAnimation extends Transition {

    private boolean upBird1;
    private boolean upBird2;
    private boolean upBird3;
    private boolean upBird4;
    private boolean downBird1;
    private boolean downBird2;
    private boolean downBird3;
    private boolean downBird4;
    private boolean centerBird1;
    private boolean centerBird2;
    private boolean centerBird3;
    private boolean centerBird4;
    private boolean bossShoot;
    private static AnchorPane root;
    ArrayList<Bird> allEnemyObjects;
    BulletAnimation bulletAnimation;
    private static Images images;
    private AirPlane airPlane;
    private GameData gameData;
    private static MediaPlayer mediaPlayer;
    private Stage stage;
    private Boss boss;
    private ImageView hp = new ImageView();
    private Label score = new Label();
    private Label BossHP = new Label();
    public GameTimeAnimation(AnchorPane root, ArrayList<Bird> Objects, BulletAnimation bulletAnimation, Images images, AirPlane airPlane
            , GameData gameData, Stage stage, MediaPlayer mediaPlayer, Boss boss){
        root.getChildren().add(BossHP);
        root.getChildren().add(hp);
        root.getChildren().add(score);
        this.boss = boss;
        bossShoot = true;
        GameTimeAnimation.mediaPlayer = mediaPlayer;
        this.stage = stage;
        this.gameData = gameData;
        GameTimeAnimation.images = images;
        this.airPlane = airPlane;
        this.bulletAnimation = bulletAnimation;
        allEnemyObjects = Objects;
        GameTimeAnimation.root = root;
        upBird1 = true;
        upBird2 = true;
        upBird3 = true;
        upBird4 = true;
        centerBird1 = true;
        centerBird2 = true;
        centerBird3 = true;
        centerBird4 = true;
        downBird1 = true;
        downBird2 = true;
        downBird3 = true;
        downBird4 = true;
        this.setAutoReverse(false);
        this.setCycleDuration(Duration.millis(15000));
        this.setCycleCount(-1);
    }
    @Override
    protected void interpolate(double v) {
        createBirds(v);
        if (checkForCollision()){
            gameData.setEndGame(true);
            this.stop();
        }
        if (airPlane.getLives() >= 0)showHP();
    }

    private void createBirds(double v){
        if (v == 1) {
            upBird1 = true;
            upBird2 = true;
            upBird3 = true;
            upBird4 = true;
            centerBird1 = true;
            centerBird2 = true;
            centerBird3 = true;
            centerBird4 = true;
            downBird1 = true;
            downBird2 = true;
            downBird3 = true;
            downBird4 = true;
            bossShoot = true;
        }
        if (v > 0.4 && v != 1 && bossShoot){
            AudioClip audioClip = new AudioClip(Objects.requireNonNull(getClass().getResource("/Media/shootingEgg.mp3")).toExternalForm());
            audioClip.play();
            boss.setShoot(true);
            bossShoot = false;
            BossShootAnimation bossShootAnimation = new BossShootAnimation(root, allEnemyObjects, images, boss);
            bossShootAnimation.play();
        }
        if (v > 0.167 && v != 1 && upBird1){
            upBird1 = false;
            MiniBossAnimation miniBossAnimation = new MiniBossAnimation(1, false, root, allEnemyObjects, images);
            miniBossAnimation.play();
        }
        if (v > 0.204 && v != 1 && upBird2){
            upBird2 = false;
            MiniBossAnimation miniBossAnimation = new MiniBossAnimation(1, false, root, allEnemyObjects, images);
            miniBossAnimation.play();
        }
        if (v > 0.241 && v != 1 && upBird3){
            upBird3 = false;
            MiniBossAnimation miniBossAnimation = new MiniBossAnimation(1, false, root, allEnemyObjects, images);
            miniBossAnimation.play();
        }
        if (v > 0.278 && v != 1 && upBird4){
            upBird4 = false;
            MiniBossAnimation miniBossAnimation = new MiniBossAnimation(1, true, root, allEnemyObjects, images);
            miniBossAnimation.play();
        }
        if (v > 0.4 && v != 1 && downBird1){
            downBird1 = false;
            MiniBossAnimation miniBossAnimation = new MiniBossAnimation(3, false, root, allEnemyObjects, images);
            miniBossAnimation.play();
        }
        if (v > 0.437 && v != 1 && downBird2){
            downBird2 = false;
            MiniBossAnimation miniBossAnimation = new MiniBossAnimation(3, false, root, allEnemyObjects, images);
            miniBossAnimation.play();
        }
        if (v > 0.474 && v != 1 && downBird3){
            downBird3 = false;
            MiniBossAnimation miniBossAnimation = new MiniBossAnimation(3, false, root, allEnemyObjects, images);
            miniBossAnimation.play();
        }
        if (v > 0.511 && v != 1 && downBird4){
            downBird4 = false;
            MiniBossAnimation miniBossAnimation = new MiniBossAnimation(3, true, root, allEnemyObjects, images);
            miniBossAnimation.play();
        }
        if (v > 0.65 && v != 1 && centerBird1){
            centerBird1 = false;
            MiniBossAnimation miniBossAnimation = new MiniBossAnimation(2, false, root, allEnemyObjects, images);
            miniBossAnimation.play();
        }
        if (v > 0.687 && v != 1 && centerBird2){
            centerBird2 = false;
            MiniBossAnimation miniBossAnimation = new MiniBossAnimation(2, false, root, allEnemyObjects, images);
            miniBossAnimation.play();
        }
        if (v > 0.724 && v != 1 && centerBird3){
            centerBird3 = false;
            MiniBossAnimation miniBossAnimation = new MiniBossAnimation(2, false, root, allEnemyObjects, images);
            miniBossAnimation.play();
        }
        if (v > 0.761 && v != 1 && centerBird4){
            centerBird4 = false;
            MiniBossAnimation miniBossAnimation = new MiniBossAnimation(2, true, root, allEnemyObjects, images);
            miniBossAnimation.play();
        }
    }

    private boolean checkForCollision(){
        for (Bullet bullet : bulletAnimation.getBullets()) {
            if (bullet.isExist())
            for (Bird bird : allEnemyObjects) {
                if (bird.isExist())
                if (bullet.getImageView().getBoundsInParent().intersects(bird.getImageView().getBoundsInParent())){
                    bird.setHP(bird.getHP() - bullet.getDamage());
                    if (bird.getHP() <= 0){
                        AudioClip birdDeath = new AudioClip(Objects.requireNonNull(getClass().getResource("/Media/birdDeath.mp3")).toExternalForm());
                        birdDeath.play();
                        BirdDeathAnimation birdDeathAnimation = new BirdDeathAnimation(bird.isYellow(), images, bird);
                        birdDeathAnimation.setOnFinished(actionEvent -> root.getChildren().remove(bird.getImageView()));
                        birdDeathAnimation.play();
                        bird.setExist(false);
                        gameData.getActiveUser().setScore(gameData.getActiveUser().getScore() + gameData.getActiveUser().getDifficulty() * 10);
                        if (bird.isBoss()){
                            VictoryAnimation victoryAnimation = new VictoryAnimation(images, root);
                            victoryAnimation.play();
                            gameData.getActiveUser().setScore(gameData.getActiveUser().getScore() + gameData.getActiveUser().getDifficulty() * 500);
                            return true;
                        }
                        airPlane.setScore(airPlane.getScore() + 2);
                        if (airPlane.getScore() >= gameData.getActiveUser().getDifficulty() * 5){
                            airPlane.setScore(0);
                            airPlane.setLives(airPlane.getLives() + 1);
                        }
                    }
                    BulletCollisionAnimation bulletCollisionAnimation = new BulletCollisionAnimation(bullet, images);
                    bullet.setExist(false);
                    bulletCollisionAnimation.setOnFinished(actionEvent -> root.getChildren().remove(bullet.getImageView()));
                    bulletCollisionAnimation.play();
                }
            }
        }
        for (Bird bird : allEnemyObjects) {
            if (bird.isExist()){
                if (bird.getImageView().getBoundsInParent().intersects(airPlane.getImageView().getBoundsInParent())) {
                    if (bird.isEgg()){
                        bird.setExist(false);
                        EggExplosionAnimation eggExplosionAnimation = new EggExplosionAnimation(root, allEnemyObjects, images, boss.getEgg(), boss);
                        eggExplosionAnimation.play();
                        AudioClip eggBomb = new AudioClip(Objects.requireNonNull(getClass().getResource("/Media/eggbomb.mp3")).toExternalForm());
                        eggBomb.play();
                        airPlane.setHP(airPlane.getHP() - 150);
                        if (airPlane.getHP() <= 0) {
                            AudioClip audioClip = new AudioClip(Objects.requireNonNull(getClass().getResource("/Media/death.mp3")).toExternalForm());
                            audioClip.play();
                            airPlane.setHP(150);
                            airPlane.setLives(airPlane.getLives() - 1);
                            if (airPlane.getLives() < 0){
                                airPlane.setExist(false);
                                root.getChildren().remove(airPlane.getImageView());
                                gameData.setLoose(true);
                                createDefeatEndGame(root);
                                return true;
                            }
                        }
                        continue;
                    }
                    AudioClip birdDeath = new AudioClip(Objects.requireNonNull(getClass().getResource("/Media/birdDeath.mp3")).toExternalForm());
                    birdDeath.play();
                    BirdDeathAnimation birdDeathAnimation = new BirdDeathAnimation(bird.isYellow(), images, bird);
                    birdDeathAnimation.setOnFinished(actionEvent -> root.getChildren().remove(bird.getImageView()));
                    birdDeathAnimation.play();
                    gameData.getActiveUser().setScore(gameData.getActiveUser().getScore() + gameData.getActiveUser().getDifficulty() * 10);
                    bird.setExist(false);
                    airPlane.setHP(airPlane.getHP() - 100);
                    if (airPlane.getHP() <= 0) {
                        AudioClip audioClip = new AudioClip(Objects.requireNonNull(getClass().getResource("/Media/death.mp3")).toExternalForm());
                        audioClip.play();
                        airPlane.setHP(150);
                        airPlane.setLives(airPlane.getLives() - 1);
                        if (airPlane.getLives() < 0){
                            airPlane.setExist(false);
                            root.getChildren().remove(airPlane.getImageView());
                            gameData.setLoose(true);
                            createDefeatEndGame(root);
                            return true;
                        }
                    }
                    airPlane.setScore(airPlane.getScore() + 2);
                    if (airPlane.getScore() >= gameData.getActiveUser().getDifficulty() * 5){
                        airPlane.setScore(0);
                        airPlane.setLives(airPlane.getLives() + 1);
                    }
                }
            }
        }
        return false;
    }

    private void createDefeatEndGame(AnchorPane root){
        Button retry = new Button("    Retry");
        retry.setLayoutX(441);
        retry.setLayoutY(261);
        retry.setPrefSize(130, 15);
        retry.getStyleClass().set(0,"defeat-button");
        Button mainMenu = new Button("  Exit to the main menu");
        mainMenu.setLayoutX(360);
        mainMenu.setLayoutY(305);
        mainMenu.setPrefSize(320, 15);
        mainMenu.getStyleClass().set(0, "defeat-button");
        Button exit = new Button("     Exit the game   ");
        exit.setLayoutX(385);
        exit.setLayoutY(350);
        exit.setPrefSize(246, 15);
        exit.getStyleClass().set(0, "defeat-button");
        ImageView imageView = new ImageView(images.defeat);
        imageView.setFitWidth(650);
        imageView.setFitHeight(420);
        imageView.setLayoutX(175);
        imageView.setLayoutY(0);
        root.getChildren().add(imageView);
        root.getChildren().add(retry);
        root.getChildren().add(mainMenu);
        root.getChildren().add(exit);
        buttonEffect(retry, mainMenu, exit);
        buttonAction(retry, mainMenu, exit);
    }

    private void buttonEffect(Button retry, Button mainMenu, Button exit){
        retry.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> {
                    retry.setEffect(new DropShadow());
                    retry.getStyleClass().set(0, "defeat-button-effect");
                });
        retry.addEventHandler(MouseEvent.MOUSE_EXITED,
                e -> {
                    retry.setEffect(null);
                    retry.getStyleClass().set(0, "defeat-button");
                });
        mainMenu.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> {
                    mainMenu.setEffect(new DropShadow());
                    mainMenu.getStyleClass().set(0, "defeat-button-effect");
                });
        mainMenu.addEventHandler(MouseEvent.MOUSE_EXITED,
                e -> {
                    mainMenu.setEffect(null);
                    mainMenu.getStyleClass().set(0, "defeat-button");
                });
        exit.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> {
                    exit.setEffect(new DropShadow());
                    exit.getStyleClass().set(0, "defeat-button-effect");
                });
        exit.addEventHandler(MouseEvent.MOUSE_EXITED,
                e -> {
                    exit.setEffect(null);
                    exit.getStyleClass().set(0, "defeat-button");
                });
    }

    private void buttonAction(Button retry, Button mainMenu, Button exit){
        exit.setOnAction(e-> {
            new RegisterMenuController().writeToJson(gameData);
            System.exit(0);
        });
        mainMenu.setOnAction(e-> {
            mediaPlayer.stop();
            try {
                new MainMenu().run(stage, gameData);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        retry.setOnAction(e-> {
            gameData.getActiveUser().setScore(0);
            mediaPlayer.stop();
            try {
                new PlayGame().run(gameData, stage, mediaPlayer);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private void showHP(){
        hp.setImage(images.hp[airPlane.getLives()]);
        hp.setFitWidth(70);
        hp.setFitHeight(25);
        hp.setLayoutX(60);
        hp.setLayoutY(0);
        score.setText(String.valueOf(gameData.getActiveUser().getScore()));
        score.setLayoutX(65);
        score.setLayoutY(30);
        score.setPrefSize(40, 20);
        score.getStyleClass().add("score-style");
        score.setAlignment(Pos.CENTER);
        BossHP.setText(String.valueOf(boss.getHP()));
        BossHP.setLayoutX(880);
        BossHP.setLayoutY(2);
        BossHP.setPrefSize(60, 20);
        if (boss.getHP() > 10000)BossHP.getStyleClass().add("boss-hp1");
        else if (boss.getHP() > 5000)BossHP.getStyleClass().add("boss-hp2");
        else BossHP.getStyleClass().add("boss-hp3");
        BossHP.setAlignment(Pos.CENTER);
    }
}
