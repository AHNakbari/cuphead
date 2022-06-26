package view;

import controller.RegisterMenuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.GameData;
import model.User;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MainMenu {

    public Button profileButton;
    public Button startGame;
    public Button mute;
    private GameData gameData;
    private static MediaPlayer mediaPlayer;
    public Button exitButton;
    public VBox mainMenuButtons;
    public Button loginButton;
    public Button singUpButton;
    public Button guestStartButton;
    public Button leaderboardButton;
    private static Stage stage;
    private AnchorPane anchorPane;
    private boolean muted = false;

    public void run(Stage stage, GameData gameData) throws IOException {
        this.gameData = gameData;
        MainMenu.stage = stage;
        URL fxmlAddress = getClass().getResource("/Fxml/main-menu.fxml");
        assert fxmlAddress != null;
        AnchorPane root = FXMLLoader.load(fxmlAddress);
        mute = new Button("mute");
        mute.setLayoutX(780);
        mute.setLayoutY(440);
        mute.setPrefSize(45, 15);
        root.getChildren().add(mute);
        anchorPane = root;
        Scene scene = new Scene(root);
        stage.setScene(scene);
        playMainMenuAudio();
        initialiseButtons(root);
        clickOnButtonsAction();
        stage.show();
    }

    private void playMainMenuAudio(){
        String path = "E:\\programing\\JAVA\\tamrin 3\\graphic\\src\\main\\resources\\Media\\main menu.mp3";
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
    }

    private void initialiseButtons(AnchorPane root){
        mainMenuButtons = (VBox) root.getChildren().get(0);
        loginButton = (Button) mainMenuButtons.getChildren().get(0);
        singUpButton = (Button) mainMenuButtons.getChildren().get(1);
        startGame = (Button) mainMenuButtons.getChildren().get(2);
        guestStartButton = (Button) mainMenuButtons.getChildren().get(3);
        profileButton = (Button) mainMenuButtons.getChildren().get(4);
        leaderboardButton = (Button) mainMenuButtons.getChildren().get(5);
        exitButton = (Button) mainMenuButtons.getChildren().get(6);
    }

    private void clickOnButtonsAction(){
        exitButton.setOnMouseClicked(this::exitClicked);
        singUpButton.setOnMouseClicked(this::enterRegisterMenuSingUp);
        loginButton.setOnMouseClicked(this::enterRegisterMenuLogin);
        profileButton.setOnMouseClicked(this::enterProfileMenu);
        leaderboardButton.setOnMouseClicked(this::enterLeaderBoard);
        guestStartButton.setOnMouseClicked(this::enterGameStartMenuAsGuest);
        startGame.setOnMouseClicked(this::enterGameStartMenuAsUser);
        mute.setOnMouseClicked(this::muteMedia);
    }

    private void exitClicked(MouseEvent mouseEvent) {
        new RegisterMenuController().writeToJson(gameData);
        System.exit(0);
    }

    private void enterRegisterMenuSingUp(MouseEvent mouseEvent){
        mediaPlayer.stop();
        RegisterMenu registerMenu = new RegisterMenu();
        try {
            registerMenu.run(stage, true, gameData, mediaPlayer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void enterRegisterMenuLogin(MouseEvent mouseEvent){
        mediaPlayer.stop();
        RegisterMenu registerMenu = new RegisterMenu();
        try {
            registerMenu.run(stage, false, gameData, mediaPlayer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void enterProfileMenu(MouseEvent mouseEvent){
        mediaPlayer.stop();
        ProfileMenu profileMenu = new ProfileMenu();
        try {
            profileMenu.run(stage, gameData, mediaPlayer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void enterLeaderBoard(MouseEvent mouseEvent){
        mediaPlayer.stop();
        LeaderBoard leaderBoard = new LeaderBoard();
        try {
            leaderBoard.show(gameData, stage, mediaPlayer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void enterGameStartMenuAsGuest(MouseEvent mouseEvent){
        mediaPlayer.stop();
        GameStartMenu gameStartMenu = new GameStartMenu();
        User user = new User("guest", "guest");
        gameData.setActiveUser(user);
        try {
            if (gameData.getActiveUser() != null){
                if (!gameData.getActiveUser().getUsername().equals("guest")) {
                    Label label = new Label("you should logout first!");
                    label.setLayoutX(436);
                    label.setLayoutY(22);
                    label.getStyleClass().add("errorText");
                    anchorPane.getChildren().add(label);
                    return;
                }
            }
            gameStartMenu.run(gameData, stage, mediaPlayer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void enterGameStartMenuAsUser(MouseEvent mouseEvent){
        mediaPlayer.stop();
        GameStartMenu gameStartMenu = new GameStartMenu();
        try {
            if (gameData.getActiveUser() == null){
                Label label = new Label("you should login first!");
                label.setLayoutX(436);
                label.setLayoutY(22);
                label.getStyleClass().add("errorText");
                anchorPane.getChildren().add(label);
                return;
            }
            gameStartMenu.run(gameData, stage, mediaPlayer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void muteMedia(MouseEvent mouseEvent){
        if (!muted)mediaPlayer.stop();
        else mediaPlayer.play();
        muted = !muted;
    }
}
