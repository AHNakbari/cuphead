package controller;

import model.GameData;
import model.User;

public class ProfileMenuController {

    public boolean isUsernameUnique(GameData gameData, String username) {
        for (User user : gameData.getUsers()) {
            if (user.getUsername().equals(username))return false;
        }
        return true;
    }

    public boolean isUsernameExist(GameData gameData, String username) {
        for (User user : gameData.getUsers()) {
            if (user.getUsername().equals(username))return true;
        }
        return false;
    }

    public boolean isPasswordCorrect(GameData gameData, String username, String password) {
        for (User user : gameData.getUsers()) {
            if (user.getUsername().equals(username))
                if (user.getPassword().equals(password))return true;
        }
        return false;
    }

    public boolean isPasswordNew(GameData gameData, String username, String password) {
        for (User user : gameData.getUsers()) {
            if (user.getUsername().equals(username))
                if (user.getPassword().equals(password))return false;
        }
        return true;
    }

    public void changeUsername(GameData gameData, String currentUsername, String newUsername) {
        for (User user : gameData.getUsers()) {
            if (user.getUsername().equals(currentUsername))user.setUsername(newUsername);
        }
    }

    public void changePassword(GameData gameData, String username, String newPassword) {
        for (User user : gameData.getUsers()) {
            if (user.getUsername().equals(username))user.setPassword(newPassword);
        }
    }

    public void deleteAccount(GameData gameData, String username) {
        gameData.getUsers().removeIf(user -> user.getUsername().equals(username));
    }
}
