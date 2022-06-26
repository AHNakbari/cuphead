package view;

import controller.RegisterMenuController;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.GameData;
import model.User;


import java.io.File;
import java.io.IOException;
import java.net.URL;

public class RegisterMenu {

    private RegisterMenuController registerMenuController = new RegisterMenuController();
    private GameData gameData;
    private static MediaPlayer mediaPlayer;

    public void run(Stage stage, boolean signUp, GameData gameData, MediaPlayer mediaPlayer) throws IOException {
        RegisterMenu.mediaPlayer = mediaPlayer;
        this.gameData = gameData;
        URL fxmlAddress = getClass().getResource("/Fxml/register-menu.fxml");
        assert fxmlAddress != null;
        AnchorPane root = FXMLLoader.load(fxmlAddress);
        playMainMenuAudio();
        if (signUp){
            signUp(stage, root);
        } else login(stage, root);
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public void signUp(Stage stage, AnchorPane root){
        GridPane boxes = new GridPane();
        boxes.setAlignment(Pos.TOP_CENTER);
        HBox buttons = new HBox();
        TextField usernameTextField = new TextField("username");
        TextField passwordTextField = new TextField("password");
        usernameTextField.setAlignment(Pos.CENTER);
        passwordTextField.setAlignment(Pos.CENTER);
        Button submit = new Button("   signup   ");
        Button mainMenu = new Button("main menu");
        boxes.addRow(0, usernameTextField);
        boxes.addRow(1, passwordTextField);
        buttons.getChildren().add(submit);
        buttons.setSpacing(1);
        buttons.getChildren().add(mainMenu);
        boxes.addRow(2, buttons);
        boxes.setLayoutX(330);
        boxes.setLayoutY(7);
        root.getChildren().add(boxes);
        Label label = new Label();
        label.setLayoutX(560);
        label.setLayoutY(17);
        root.getChildren().add(label);
        submit.setOnAction(e->{
            submit.setEffect(new DropShadow());
            if (!registerMenuController.addUser(usernameTextField.getText(), passwordTextField.getText(), gameData)){
                submit.setEffect(null);
                label.setText("username entered, used by another player!\n\tplease enter another one!");
                label.setStyle("-fx-text-fill: #ff0000");
                label.setEffect(new DropShadow());
            } else {
                label.setText("");
            }
        });
        mainMenu.setOnAction(e->{
            try {
                new MainMenu().run(stage, gameData);
                mediaPlayer.stop();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    public void login(Stage stage, AnchorPane root){
        GridPane boxes = new GridPane();
        boxes.setAlignment(Pos.TOP_CENTER);
        HBox buttons = new HBox();
        TextField usernameTextField = new TextField("username");
        TextField passwordTextField = new TextField("password");
        usernameTextField.setAlignment(Pos.CENTER);
        passwordTextField.setAlignment(Pos.CENTER);
        Button login = new Button("     Login     ");
        Button mainMenu = new Button("main menu");
        boxes.addRow(0, usernameTextField);
        boxes.addRow(1, passwordTextField);
        buttons.getChildren().add(login);
        buttons.setSpacing(1);
        buttons.getChildren().add(mainMenu);
        boxes.addRow(2, buttons);
        boxes.setLayoutX(330);
        boxes.setLayoutY(7);
        root.getChildren().add(boxes);
        Label label = new Label();
        label.setLayoutX(560);
        label.setLayoutY(17);
        root.getChildren().add(label);
        login.setOnAction(e->{
            login.setEffect(new DropShadow());
            if (!registerMenuController.isUsernameExist(usernameTextField.getText(), gameData)) {
                login.setEffect(null);
                label.setText("username doesnt exist in system!");
                label.setStyle("-fx-text-fill: #ff0000");
                label.setEffect(new DropShadow());
            } else if (!registerMenuController.login(usernameTextField.getText(), passwordTextField.getText(), gameData)){
                login.setEffect(null);
                label.setText("username and password doesnt matched!");
                label.setStyle("-fx-text-fill: #ff0000");
                label.setEffect(new DropShadow());
            } else {
                for (User user : gameData.getUsers()) {
                    if (user.getUsername().equals(usernameTextField.getText()))gameData.setActiveUser(user);
                }
                label.setText("");
            }
        });
        mainMenu.setOnAction(e->{
            try {
                new MainMenu().run(stage, gameData);
                mediaPlayer.stop();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private void playMainMenuAudio(){
        String path = "E:\\programing\\JAVA\\tamrin 3\\graphic\\src\\main\\resources\\Media\\registerMenu.mp3";
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
    }

}
