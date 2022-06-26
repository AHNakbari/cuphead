package view;


import controller.RegisterMenuController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import model.GameData;
import model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameView extends Application {

    private static MediaPlayer mediaPlayer;
    private static MediaView mediaView;
    public static GameData gameData;

    @Override
    public void start(Stage stage) {
        gameData = new GameData();
        ArrayList<User> users = new RegisterMenuController().readFromJson();
        if (users != null) gameData.setUsers(users);
        Group root = new Group();
        playOpeningVideo();
        root.getChildren().add(mediaView);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        mediaPlayer.setAutoPlay(true);
        enterMainMenu(scene, stage);
        stage.setTitle("CupHead!");
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }

    private void playOpeningVideo(){
        String path = "E:\\programing\\JAVA\\tamrin 3\\graphic\\src\\main\\resources\\Media\\Opening.mp4";
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView = new MediaView(mediaPlayer);
        mediaView.setFitHeight(440);
        mediaView.setFitWidth(780);
    }

    public void enterMainMenu(Scene scene, Stage stage) {
        scene.setOnKeyPressed(e -> {
            MainMenu mainMenu = new MainMenu();
            try {
                mediaPlayer.stop();
                mainMenu.run(stage, gameData);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

    }
}
