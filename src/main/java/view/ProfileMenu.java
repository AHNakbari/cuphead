package view;

import controller.ProfileMenuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.MotionBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.GameData;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ProfileMenu {

    private static MediaPlayer mediaPlayer;
    private GameData gameData;
    VBox changePasswordPack = new VBox();
    VBox changeUsernamePack = new VBox();
    VBox deleteAccountPack = new VBox();
    Button avatar1;
    Button avatar2;
    Button avatar3;

    private ProfileMenuController controller = new ProfileMenuController();

    public void run(Stage stage, GameData gameData, MediaPlayer mediaPlayer) throws IOException {
        ProfileMenu.mediaPlayer = mediaPlayer;
        this.gameData = gameData;
        URL fxmlAddress = getClass().getResource("/Fxml/profile-menu.fxml");
        assert fxmlAddress != null;
        AnchorPane root = FXMLLoader.load(fxmlAddress);
        playMainMenuAudio();
        menuButtons(root, stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    private void menuButtons(AnchorPane root, Stage stage){
        //Delete account TextFields and button
        DeleteAccount(root);
        //Change password TextFields and button
        ChangePassword(root);
        //Change username TextFields and button
        ChangeUsername(root);
        //Avatars buttons
        ChooseAvatar(root);
        //Logout button
        LogoutButton(root);
        //Main menu button
        MainMenuButton(root, stage);
    }

    private void ChangeUsername(AnchorPane root){
        TextField currentUsername = new TextField("current username");
        TextField password1 = new TextField("password");
        TextField newUsername = new TextField("new username");
        Button changeUsername = new Button("change current username");
        changeUsernamePack.getChildren().add(currentUsername);
        changeUsernamePack.getChildren().add(password1);
        changeUsernamePack.getChildren().add(newUsername);
        changeUsernamePack.getChildren().add(changeUsername);
        changeUsernamePack.getChildren().add(new Label());
        changeUsernamePack.setLayoutX(50);
        changeUsernamePack.setLayoutY(40);
        root.getChildren().add(changeUsernamePack);
        changeUsername.setOnAction(e-> {
            buttonsAction(gameData, currentUsername.getText(), newUsername.getText(), password1.getText(), null, "changeUsername", root);
        });
    }

    private void ChangePassword(AnchorPane root){
        TextField username1 = new TextField("username");
        TextField currentPassword = new TextField("current password");
        TextField newPassword = new TextField("new password");
        Button changePassword = new Button("change current password");
        changePasswordPack.getChildren().add(username1);
        changePasswordPack.getChildren().add(currentPassword);
        changePasswordPack.getChildren().add(newPassword);
        changePasswordPack.getChildren().add(changePassword);
        changePasswordPack.getChildren().add(new Label());
        changePasswordPack.setLayoutX(600);
        changePasswordPack.setLayoutY(40);
        root.getChildren().add(changePasswordPack);
        changePassword.setOnAction(e->{
            buttonsAction(gameData, username1.getText(), "", currentPassword.getText(), newPassword.getText(), "changePassword", root);
        });
    }

    private void DeleteAccount(AnchorPane root){
        TextField username = new TextField("username");
        TextField password = new TextField("password");
        Button deleteAccount = new Button("delete the current account");
        deleteAccountPack.getChildren().add(username);
        deleteAccountPack.getChildren().add(password);
        deleteAccountPack.getChildren().add(deleteAccount);
        deleteAccountPack.getChildren().add(new Label());
        deleteAccountPack.setLayoutX(50);
        deleteAccountPack.setLayoutY(195);
        root.getChildren().add(deleteAccountPack);
        deleteAccount.setOnAction(e->{
            buttonsAction(gameData, username.getText(), null, password.getText(), null, "deleteAccount", root);
        });
    }

    private void ChooseAvatar(AnchorPane root){
        Button avatar11 = new Button();
        Button avatar22 = new Button();
        Button avatar33 = new Button();
        Button avatarFile = new Button("choose an Image");
        this.avatar1 = avatar11;
        this.avatar2 = avatar22;
        this.avatar3 = avatar33;
        Label label = new Label("choose your Avatar!");
        label.getStyleClass().add("avatar-text");
        label.setLayoutX(632);
        label.setLayoutY(175);
        initialiseButtons(avatarFile);
        root.getChildren().add(label);
        root.getChildren().add(avatar1);
        root.getChildren().add(avatar2);
        root.getChildren().add(avatar3);
        root.getChildren().add(avatarFile);
        setAvatar(avatarFile);
    }

    private void initialiseButtons(Button avatarFile){
        Image cupHead = new Image(String.valueOf(getClass().getResource("/Media/CupHead.jpeg")));
        Image evil = new Image(String.valueOf(getClass().getResource("/Media/Evil.jpeg")));
        Image kingDice = new Image(String.valueOf(getClass().getResource("/Media/KingDice.jpeg")));
        ImageView imageView1 = new ImageView(cupHead);
        ImageView imageView2 = new ImageView(evil);
        ImageView imageView3 = new ImageView(kingDice);
        imageView1.setFitHeight(70);
        imageView1.setFitWidth(70);
        imageView2.setFitHeight(70);
        imageView2.setFitWidth(70);
        imageView3.setFitHeight(70);
        imageView3.setFitWidth(70);
        imageView1.setPreserveRatio(true);
        avatar1.setGraphic(imageView1);
        avatar2.setGraphic(imageView2);
        avatar3.setGraphic(imageView3);
        avatar1.setPrefSize(70, 70);
        avatar2.setPrefSize(70, 70);
        avatar3.setPrefSize(70, 70);
        avatar1.setLayoutX(550);
        avatar1.setLayoutY(190);
        avatar2.setLayoutX(633);
        avatar2.setLayoutY(190);
        avatar3.setLayoutX(716);
        avatar3.setLayoutY(190);
        avatarFile.setLayoutX(585);
        avatarFile.setLayoutY(270);
        avatarFile.setPrefSize(166, 15);
        avatar1.getStyleClass().add("avatar-button");
        avatar2.getStyleClass().add("avatar-button");
        avatar3.getStyleClass().add("avatar-button");
    }

    private void setAvatar(Button avatarFile){
        avatar1.setOnAction(e -> {
            if (gameData.getActiveUser() == null)return;
            avatar2.getStyleClass().clear();
            avatar2.getStyleClass().add("button");
            avatar2.getStyleClass().add("avatar-button");
            avatar3.getStyleClass().clear();
            avatar3.getStyleClass().add("button");
            avatar3.getStyleClass().add("avatar-button");
            gameData.getActiveUser().setAvatarAddress(String.valueOf(getClass().getResource("/Media/CupHead.jpeg")));
            avatar1.getStyleClass().clear();
            avatar1.getStyleClass().add("avatar-button1");
        });
        avatar2.setOnAction(e -> {
            if (gameData.getActiveUser() == null)return;
            avatar1.getStyleClass().clear();
            avatar1.getStyleClass().add("button");
            avatar1.getStyleClass().add("avatar-button");
            avatar3.getStyleClass().clear();
            avatar3.getStyleClass().add("button");
            avatar3.getStyleClass().add("avatar-button");
            gameData.getActiveUser().setAvatarAddress(String.valueOf(getClass().getResource("/Media/Evil.jpeg")));
            avatar2.getStyleClass().clear();
            avatar2.getStyleClass().add("avatar-button1");
        });
        avatar3.setOnAction(e -> {
            if (gameData.getActiveUser() == null)return;
            avatar1.getStyleClass().clear();
            avatar1.getStyleClass().add("button");
            avatar1.getStyleClass().add("avatar-button");
            avatar2.getStyleClass().clear();
            avatar2.getStyleClass().add("button");
            avatar2.getStyleClass().add("avatar-button");
            gameData.getActiveUser().setAvatarAddress(String.valueOf(getClass().getResource("/Media/KingDice.jpeg")));
            avatar3.getStyleClass().clear();
            avatar3.getStyleClass().add("avatar-button1");
        });
        avatarFile.setOnAction(e->{
            if (gameData.getActiveUser() == null)return;
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(new Stage());
            if (file != null) {
                String path = file.toURI().toString();
                gameData.getActiveUser().setAvatarAddress(path);
                resetAvatarButtons();
            }
        });
    }

    private void MainMenuButton(AnchorPane root, Stage stage){
        Button mainMenuButton = new Button("main menu");
        mainMenuButton.setStyle("-fx-font-weight: bold");
        mainMenuButton.setTranslateX(600);
        mainMenuButton.setTranslateY(315);
        mainMenuButton.setPrefSize(155, 76);
        root.getChildren().add(mainMenuButton);
        mainMenuButton.setOnAction(e->{
            mediaPlayer.stop();
            try {
                new MainMenu().run(stage, gameData);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private void LogoutButton(AnchorPane root) {
        Button logoutButton = new Button("logout");
        logoutButton.setStyle("-fx-font-weight: bold");
        logoutButton.setTranslateX(50);
        logoutButton.setTranslateY(315);
        logoutButton.setPrefSize(155, 76);
        root.getChildren().add(logoutButton);
        Label logoutError = new Label();
        logoutError.getStyleClass().add("errorText");
        logoutError.setLayoutX(70);
        logoutError.setLayoutY(395);
        root.getChildren().add(logoutError);
        logoutButton.setOnAction(e->{
            if (gameData.getActiveUser() == null){
                logoutError.setText("you haven't login yet!");
            } else {
                logoutError.setText("you have logged out!");
                resetAvatarButtons();
                gameData.setActiveUser(null);
            }
        });
    }

    private void resetAvatarButtons(){
        avatar1.getStyleClass().clear();
        avatar1.getStyleClass().add("button");
        avatar1.getStyleClass().add("avatar-button");
        avatar2.getStyleClass().clear();
        avatar2.getStyleClass().add("button");
        avatar2.getStyleClass().add("avatar-button");
        avatar3.getStyleClass().clear();
        avatar3.getStyleClass().add("button");
        avatar3.getStyleClass().add("avatar-button");
    }

    private void playMainMenuAudio(){
        String path = "E:\\programing\\JAVA\\tamrin 3\\graphic\\src\\main\\resources\\Media\\profile menu.mp3";
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
    }

    private void buttonsAction(GameData gameData, String currentUsername, String newUsername, String currentPassword,
                               String newPassword, String which, AnchorPane root) {
        Label label = new Label();
        label.getStyleClass().add("errorText");
        switch (which) {
            case "changePassword" :
                if(!controller.isUsernameExist(gameData, currentUsername)) {
                    label.setText("username doesnt exist!");
                    changePasswordPack.getChildren().set(4, label);
                } else if (!controller.isPasswordCorrect(gameData, currentUsername, currentPassword)) {
                    label.setText("password is not correct");
                    changePasswordPack.getChildren().set(4, label);
                } else if (!controller.isPasswordNew(gameData, currentUsername, newPassword)) {
                    label.setText("enter a new password!");
                    changePasswordPack.getChildren().set(4, label);
                } else {
                    controller.changePassword(gameData, currentUsername, newPassword);
                    label.setText("");
                    changePasswordPack.getChildren().set(4, label);
                }
                break;
            case "changeUsername" :
                if (!controller.isUsernameExist(gameData, currentUsername)) {
                    label.setText("username doesnt exist!");
                    changeUsernamePack.getChildren().set(4, label);
                } else if (!controller.isPasswordCorrect(gameData, currentUsername, currentPassword)) {
                    label.setText("password is not correct");
                    changeUsernamePack.getChildren().set(4, label);
                } else {
                    controller.changeUsername(gameData, currentUsername, newUsername);
                    label.setText("");
                    changeUsernamePack.getChildren().set(4, label);
                }
                break;
            case "deleteAccount" :
                if (!controller.isUsernameExist(gameData, currentUsername)) {
                    label.setText("username doesnt exist!");
                    deleteAccountPack.getChildren().set(3, label);
                } else if (!controller.isPasswordCorrect(gameData, currentUsername, currentPassword)) {
                    label.setText("password is not correct");
                    deleteAccountPack.getChildren().set(3, label);
                } else {
                    controller.deleteAccount(gameData, currentUsername);
                    label.setText("");
                    deleteAccountPack.getChildren().set(3, label);
                }
                break;
        }
    }

}
