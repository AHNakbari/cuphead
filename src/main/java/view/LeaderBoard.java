package view;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.GameData;
import model.User;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;

public class LeaderBoard {

    private GameData gameData;
    private static MediaPlayer mediaPlayer;
    private Stage stage;

    public void show(GameData gameData, Stage stage, MediaPlayer mediaPlayer) throws IOException {
        LeaderBoard.mediaPlayer = mediaPlayer;
        this.stage = stage;
        this.gameData = gameData;
        URL fxmlAddress = getClass().getResource("/Fxml/leaderboard.fxml");
        assert fxmlAddress != null;
        AnchorPane root = FXMLLoader.load(fxmlAddress);
        playMainMenuAudio();
        createTable(root);
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    private void createTable(AnchorPane root){
        TableView<User> table = new TableView<>();
        TableColumn<User, String> nameColumn = new TableColumn<>("Username");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        TableColumn<User, Double> scoreColumn = new TableColumn<>("Score");
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        table.getColumns().add(nameColumn);
        table.getColumns().add(scoreColumn);
        ArrayList<User> users = gameData.getUsers();
        users.sort(new Sort());
        for (User user : users) {
            table.getItems().add(user);
        }
        table.setStyle(".table-view");
        VBox vBox = new VBox(table);
        vBox.setPadding(new Insets(25, 50, 50, 275));
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        Button mainMenuButton = new Button("Main Menu");
        mainMenuButton.setTranslateX(725);
        mainMenuButton.setTranslateY(442);
//        vBox.getChildren().add(mainMenuButton);
        mainMenuButton.setOnAction(e->{
            mediaPlayer.stop();
            try {
                new MainMenu().run(stage, gameData);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        root.getChildren().add(mainMenuButton);
        root.getChildren().add(vBox);
    }

    private void playMainMenuAudio(){
        String path = "E:\\programing\\JAVA\\tamrin 3\\graphic\\src\\main\\resources\\Media\\leaderboard.mp3";
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
    }

    static class Sort implements Comparator<User> {
        public int compare(User user1, User user2)
        {
            return (int)user2.getScore() - (int)user1.getScore();
        }
    }

}


