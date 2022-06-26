package controller;

import javafx.scene.image.Image;
import model.GameData;
import model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RegisterMenuController {


    public RegisterMenuController(){
    }

    public boolean addUser(String username, String password, GameData gameData){
        if (isUsernameUnique(username, gameData)){
            User user = new User(username, password);
            user.setAvatarAddress(String.valueOf(getClass().getResource("/Media/CupHead.jpeg")));
            gameData.addUser(user);
            return true;
        } else return false;
    }

    private boolean isUsernameUnique(String username, GameData gameData){
        for (User user : gameData.getUsers()) {
            if (user.getUsername().equals(username))return false;
        }
        return true;
    }

    public boolean isUsernameExist(String username, GameData gameData){
        for (User user : gameData.getUsers()) {
            if (user.getUsername().equals(username))return true;
        }
        return false;
    }

    public boolean login(String username, String password, GameData gameData){
        for (User user : gameData.getUsers()) {
            if (user.getUsername().equals(username))
                return user.getPassword().equals(password);
        }
        return false;
    }

    public void writeToJson(GameData gameData){
        try {
            FileWriter fileWriter = new FileWriter("usersInformation.json");
            if (gameData.getUsers().size() > 0){
                fileWriter.write(new Gson().toJson(gameData.getUsers()));
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> readFromJson(){
        Gson gson = new Gson();
        try {
            String usersJson = new String(Files.readAllBytes(Paths.get("usersInformation.json")));
            ArrayList<User> usersFromJson = gson.fromJson(usersJson, new TypeToken<List<User>>(){}.getType());
            if (usersFromJson != null)
                return usersFromJson;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
