package view;

import controller.AirPlaneAction;
import controller.transition.BossAnimation;
import controller.transition.BulletAnimation;
import controller.transition.GameTimeAnimation;
import controller.transition.MiniBossAnimation;
import javafx.animation.*;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.GameData;
import model.Images;
import model.component.AirPlane;
import model.component.Bird;
import model.component.Boss;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


public class PlayGame {

    private boolean isMute = false;
    ArrayList<Bird> allEnemyObjects;
    private GameData gameData;
    private static MediaPlayer mediaPlayer;
    private Stage stage;
    private static AirPlane airPlane;
    private static AirPlaneAction airPlaneAction;
    private ArrayList<ImageView> bullets;
    private static Images images;
    private boolean backgroundMove = true;

    public void run(GameData gameData, Stage stage, MediaPlayer mediaPlayer) throws IOException {
        images = new Images();
        allEnemyObjects = new ArrayList<>();
        PlayGame.mediaPlayer = mediaPlayer;
        playMainMenuAudio();
        bullets = new ArrayList<>();
        this.stage = stage;
        this.gameData = gameData;
        URL fxmlAddress = getClass().getResource("/Fxml/play-game.fxml");
        assert fxmlAddress != null;
        AnchorPane root = FXMLLoader.load(fxmlAddress);
        showAvatar(root);
        initialize(root);
        createAirplane(root);
        Boss boss = new Boss(new ImageView(), false, 15000, 100 - ((gameData.getActiveUser().getDifficulty() - 2) * 3));
        PlayGame.airPlaneAction = new AirPlaneAction(airPlane);
        Scene scene = new Scene(root);
        BulletAnimation bulletAnimation = new BulletAnimation(root, scene, allEnemyObjects, images, gameData);
        GameTimeAnimation gameTimeAnimation = new GameTimeAnimation(root, allEnemyObjects, bulletAnimation, images, airPlane, gameData, stage, PlayGame.mediaPlayer, boss);
        gameTimeAnimation.play();
        BossAnimation bossAnimation = new BossAnimation(gameData, root, allEnemyObjects, images, boss);
        bossAnimation.play();
        pauseButton(root, gameTimeAnimation, bulletAnimation, bossAnimation);
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                airPlaneAction.moveUp();
            }
            if (event.getCode() == KeyCode.S) {
                airPlaneAction.moveDown();
            }
            if (event.getCode() == KeyCode.D) {
                airPlaneAction.moveRight();
            }
            if (event.getCode() == KeyCode.A) {
                airPlaneAction.moveLeft();
            }
            if (event.getCode() == KeyCode.J || event.isControlDown()) {
                bulletAnimation.addBullet(airPlane.getImageView().getLayoutX() + 25, airPlane.getImageView().getLayoutY() + 30);
            }
            if (event.getCode() == KeyCode.ENTER && gameData.isEndGame()){
                createVictoryEndGame();
            }
            event.consume();
        });
        bulletAnimation.play();
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(AnchorPane vBox) {
        DoubleProperty xPosition = new SimpleDoubleProperty(0);
        xPosition.addListener((observable, oldValue, newValue) -> setBackgroundPositions(vBox, xPosition.get()));
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(xPosition, 0)),
                new KeyFrame(Duration.seconds(1200), new KeyValue(xPosition, -600000))
        );
        timeline.play();
    }
    private void setBackgroundPositions(Region region, double xPosition) {
        if (backgroundMove) {
            String style = "-fx-background-position: " +
                    "left " + xPosition / 8 + "px bottom," +
                    "left " + xPosition / 7 + "px bottom," +
                    "left " + xPosition / 6 + "px bottom," +
                    "left " + xPosition / 5 + "px bottom," +
                    "left " + xPosition / 4 + "px bottom," +
                    "left " + xPosition / 3 + "px bottom," +
                    "left " + xPosition / 2 + "px bottom," +
                    "left " + xPosition + "px bottom;";
            region.setStyle(style);
        }
    }

    private void createAirplane(AnchorPane root){
        Image image = new Image("/Media/color of plane/" + gameData.getActiveUser().getPlaneColor() + ".png");
        int lives;
        if (gameData.getActiveUser().getDifficulty() == 1) lives = 10;
        else if (gameData.getActiveUser().getDifficulty() == 2) lives = 5;
        else lives = 2;
        AirPlane airPlane = new AirPlane(new ImageView(image), lives);
        PlayGame.airPlane = airPlane;
        airPlane.getImageView().setFitHeight(65);
        airPlane.getImageView().setFitWidth(80);
        airPlane.getImageView().setLayoutX(20);
        airPlane.getImageView().setLayoutY(180);
        root.getChildren().add(airPlane.getImageView());
    }

    private void createVictoryEndGame(){
        mediaPlayer.stop();
        try {
            new MainMenu().run(stage, gameData);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void playMainMenuAudio(){
        String path = "E:\\programing\\JAVA\\tamrin 3\\graphic\\src\\main\\resources\\Media\\gameBackGroundSoundTrack.mpeg";
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
    }

    private void pauseButton(AnchorPane root, GameTimeAnimation gameTimeAnimation, BulletAnimation bulletAnimation, BossAnimation bossAnimation){
        Button stop = new Button("Pause");
        stop.setLayoutX(960);
        stop.setLayoutY(0);
        stop.getStyleClass().add("pause-button");
        root.getChildren().add(stop);
        stop.setOnMouseClicked(e ->{
            gameTimeAnimation.pause();
            bulletAnimation.pause();
            bossAnimation.pause();
            mediaPlayer.pause();
            backgroundMove = false;
            pauseMenu(root, gameTimeAnimation, bulletAnimation, bossAnimation);
        });
    }

    private void pauseMenu(AnchorPane root, GameTimeAnimation gameTimeAnimation, BulletAnimation bulletAnimation, BossAnimation bossAnimation){
        Button mute = new Button();
        ImageView muteView = new ImageView(images.mute);
        ImageView unmuteView = new ImageView(images.unmute);
        if (isMute)mute.setGraphic(muteView);
        else mute.setGraphic(unmuteView);
        mute.setPrefSize(60, 60);
        muteView.setFitHeight(60);
        muteView.setFitWidth(60);
        unmuteView.setFitHeight(60);
        unmuteView.setFitWidth(60);
        mute.setLayoutX(450);
        mute.setLayoutY(60);
        mute.getStyleClass().add("avatar-button");
        root.getChildren().add(mute);
        mute.setOnMouseClicked(actionEvent -> {
            isMute = !isMute;
            if (isMute)mute.setGraphic(muteView);
            else mute.setGraphic(unmuteView);
        });
        Button mainMenu = new Button("  Return Main Menu");
        mainMenu.getStyleClass().clear();
        mainMenu.getStyleClass().add("pause-button");
        mainMenu.setPrefSize(120, 35);
        mainMenu.setLayoutX(422);
        mainMenu.setLayoutY(140);
        mainMenu.setOnMouseClicked(e-> {
            mediaPlayer.stop();
            try {
                new MainMenu().run(stage, gameData);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        root.getChildren().add(mainMenu);
        Button resume = new Button("           Resume");
        resume.setPrefSize(120, 35);
        resume.setLayoutX(422);
        resume.setLayoutY(180);
        resume.getStyleClass().set(0, "pause-button");
        root.getChildren().add(resume);
        resume.setOnMouseClicked(e-> {
            gameTimeAnimation.play();
            bulletAnimation.play();
            bossAnimation.play();
            if (!isMute)mediaPlayer.play();
            backgroundMove = true;
            root.getChildren().remove(mainMenu);
            root.getChildren().remove(mute);
            root.getChildren().remove(resume);
        });

    }

    private void showAvatar(AnchorPane root){
        Image avatarImage = new Image(gameData.getActiveUser().getAvatarAddress());
        ImageView avatar = new ImageView(avatarImage);
        root.getChildren().add(avatar);
        avatar.setFitHeight(60);
        avatar.setFitWidth(60);
    }

}
