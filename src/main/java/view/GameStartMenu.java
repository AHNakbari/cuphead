package view;

import controller.transition.GameTimeAnimation;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.GameData;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class GameStartMenu {
    private GameData gameData;
    private static MediaPlayer mediaPlayer;
    private Stage stage;
    private boolean easyButtonClicked = false;
    private boolean difficultButtonClicked = false;
    private boolean evilButtonClicked = false;

    public void run(GameData gameData, Stage stage, MediaPlayer mediaPlayer) throws IOException {
        GameStartMenu.mediaPlayer = mediaPlayer;
        this.stage = stage;
        this.gameData = gameData;
        URL fxmlAddress = getClass().getResource("/Fxml/game-start-menu.fxml");
        assert fxmlAddress != null;
        AnchorPane root = FXMLLoader.load(fxmlAddress);
        playMainMenuAudio();
        createButtons(root);
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    private void createButtons(AnchorPane root){
        Label label = new Label("Choose your Difficulty...");
        label.getStyleClass().add("difficulty-text");
        label.setLayoutX(15);
        label.setLayoutY(5);
        root.getChildren().add(label);
        Button easyMode = new Button();
        Button difficultMode = new Button();
        Button evilMode = new Button();
        Image easy = new Image(String.valueOf(getClass().getResource("/Media/Easy.png")));
        Image difficult = new Image(String.valueOf(getClass().getResource("/Media/Difficult.jpg")));
        Image evil = new Image(String.valueOf(getClass().getResource("/Media/EvilMode.jpg")));
        ImageView easyView = new ImageView(easy);
        ImageView difficultView = new ImageView(difficult);
        ImageView evilView = new ImageView(evil);
        easyView.setFitHeight(100);
        easyView.setFitWidth(180);
        difficultView.setFitHeight(100);
        difficultView.setFitWidth(180);
        evilView.setFitHeight(100);
        evilView.setFitWidth(180);
        easyMode.setGraphic(easyView);
        difficultMode.setGraphic(difficultView);
        evilMode.setGraphic(evilView);
        initButtons(easyMode, difficultMode, evilMode, root);
        showInfo(easyMode, difficultMode, evilMode, root);
        buttonActions(easyMode, difficultMode, evilMode, root);
    }

    private void initButtons(Button easyMode, Button difficultMode, Button evilMode, AnchorPane root){
        easyMode.setLayoutX(10);
        easyMode.setLayoutY(20);
        difficultMode.setLayoutX(10);
        difficultMode.setLayoutY(130);
        evilMode.setLayoutX(10);
        evilMode.setLayoutY(240);
        easyMode.setPrefSize(180, 100);
        difficultMode.setPrefSize(180, 100);
        evilMode.setPrefSize(180, 100);
        easyMode.getStyleClass().add("avatar-button");
        evilMode.getStyleClass().add("avatar-button");
        difficultMode.getStyleClass().add("avatar-button");
        root.getChildren().add(easyMode);
        root.getChildren().add(difficultMode);
        root.getChildren().add(evilMode);
    }

    private void showInfo(Button easyMode, Button difficultMode, Button evilMode, AnchorPane root){
        Label label = new Label();
        Label title = new Label();
        label.getStyleClass().add("difficulty-info");
        root.getChildren().add(label);
        root.getChildren().add(title);
        easyMode.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> {
                    title.setText("it's EASY mode!");
                    title.getStyleClass().clear();
                    title.getStyleClass().add("easy-mode-title");
                    if (!easyButtonClicked)easyMode.setEffect(new DropShadow());
                    label.setText("Number of initial lives : 8\n" +
                            "Boss damage coefficient : 50%\n" + "Your Damage Coefficient : 150%");
                    label.setLayoutX(205);
                    label.setLayoutY(58);
                    title.setLayoutX(205);
                    title.setLayoutY(37);
                });
        easyMode.addEventHandler(MouseEvent.MOUSE_EXITED,
                e -> {
                    title.setText("");
                    if (!easyButtonClicked)easyMode.setEffect(null);
                    label.setText("");
                });
        difficultMode.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> {
                    title.setText("it's DIFFICULT mode");
                    title.getStyleClass().clear();
                    title.getStyleClass().add("difficult-mode-title");
                    if (!difficultButtonClicked)difficultMode.setEffect(new DropShadow());
                    label.setText("Number of initial lives : 5\n" +
                            "Boss damage coefficient : 100%\n" + "Your Damage Coefficient : 100%");
                    label.setLayoutX(205);
                    label.setLayoutY(168);
                    title.setLayoutX(205);
                    title.setLayoutY(147);
                });
        difficultMode.addEventHandler(MouseEvent.MOUSE_EXITED,
                e -> {
                    title.setText("");
                    if (!difficultButtonClicked)difficultMode.setEffect(null);
                    label.setText("");
                });
        evilMode.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> {
                    title.setText("it's EVIL mode");
                    title.getStyleClass().clear();
                    title.getStyleClass().add("evil-mode-title");
                    if (!evilButtonClicked)evilMode.setEffect(new DropShadow());
                    label.setText("Number of initial lives : 2\n" +
                            "Boss damage coefficient : 150%\n" + "Your Damage Coefficient : 50%");
                    label.setLayoutX(205);
                    label.setLayoutY(278);
                    title.setLayoutX(205);
                    title.setLayoutY(258);
                });
        evilMode.addEventHandler(MouseEvent.MOUSE_EXITED,
                e -> {
                    title.setText("");
                    if (!evilButtonClicked)evilMode.setEffect(null);
                    label.setText("");
                });
    }

    private void buttonActions(Button easyMode, Button difficultMode, Button evilMode, AnchorPane root){
        Button mainMenu = new Button("main menu");
        mainMenu.setLayoutX(750);
        mainMenu.setLayoutY(435);
        root.getChildren().add(mainMenu);
        mainMenu.setOnAction(e ->{
            mediaPlayer.stop();
            try {
                new MainMenu().run(stage, gameData);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        easyMode.setOnAction(e-> {
            easyMode.setEffect(new Bloom());
            easyButtonClicked = true;
            difficultButtonClicked = false;
            difficultMode.setEffect(null);
            evilButtonClicked = false;
            evilMode.setEffect(null);
            gameData.getActiveUser().setDifficulty(1);
            chooseColor(root);
        });
        difficultMode.setOnAction(e -> {
            difficultMode.setEffect(new Bloom());
            easyButtonClicked = false;
            easyMode.setEffect(null);
            difficultButtonClicked = true;
            evilButtonClicked = false;
            evilMode.setEffect(null);
            gameData.getActiveUser().setDifficulty(2);
            chooseColor(root);
        });
        evilMode.setOnAction(e -> {
            evilMode.setEffect(new Bloom());
            easyButtonClicked = false;
            easyMode.setEffect(null);
            difficultButtonClicked = false;
            difficultMode.setEffect(null);
            evilButtonClicked = true;
            gameData.getActiveUser().setDifficulty(3);
            chooseColor(root);
        });
    }

    private void chooseColor(AnchorPane root){
        Button bluePlane = new Button();
        Button redPlane = new Button();
        Image blue = new Image(String.valueOf(getClass().getResource("/Media/color of plane/blue.png")));
        Image red = new Image(String.valueOf(getClass().getResource("/Media/color of plane/red.png")));
        ImageView blueView = new ImageView(blue);
        ImageView redView = new ImageView(red);
        blueView.setFitWidth(80);
        blueView.setFitHeight(65);
        redView.setFitWidth(80);
        redView.setFitHeight(65);
        bluePlane.setGraphic(blueView);
        redPlane.setGraphic(redView);
        initPlanes(bluePlane, redPlane, root);
        planeAction(bluePlane, redPlane, root);
    }

    private void initPlanes(Button bluePlane, Button redPlane, AnchorPane root){
        bluePlane.setLayoutX(10);
        bluePlane.setLayoutY(350);
        redPlane.setLayoutX(100);
        redPlane.setLayoutY(350);
        bluePlane.getStyleClass().add("avatar-button");
        redPlane.getStyleClass().add("avatar-button");
        bluePlane.setPrefSize(80, 65);
        redPlane.setPrefSize(80, 65);
        root.getChildren().add(bluePlane);
        root.getChildren().add(redPlane);
    }

    private void planeAction(Button bluePlane, Button redPlane, AnchorPane root){
        bluePlane.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> {
                    bluePlane.setEffect(new DropShadow());
                });
        bluePlane.addEventHandler(MouseEvent.MOUSE_EXITED,
                e -> {
                    bluePlane.setEffect(null);
                });
        bluePlane.addEventHandler(MouseEvent.MOUSE_CLICKED,
                e -> {
                    gameData.getActiveUser().setPlaneColor("blue");
                    mediaPlayer.stop();
                    try {
                        new PlayGame().run(gameData, stage, mediaPlayer);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
        redPlane.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> {
                    redPlane.setEffect(new DropShadow());
                });
        redPlane.addEventHandler(MouseEvent.MOUSE_EXITED,
                e -> {
                    redPlane.setEffect(null);
                });
        redPlane.addEventHandler(MouseEvent.MOUSE_CLICKED,
                e -> {
                    gameData.getActiveUser().setPlaneColor("red");
                    mediaPlayer.stop();
                    try {
                        new PlayGame().run(gameData, stage, mediaPlayer);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
    }

    private void playMainMenuAudio(){
        String path = "E:\\programing\\JAVA\\tamrin 3\\graphic\\src\\main\\resources\\Media\\game start menu.mp3";
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(10);
    }
}
