package model;

import javafx.scene.image.Image;

public class User {
    private String username;
    private String password;
    private double score;
    private String avatarAddress;
    private int Difficulty;
    private String planeColor;

    public User(String username, String password) {
        this.avatarAddress = String.valueOf(getClass().getResource("/Media/CupHead.jpeg"));
        this.username = username;
        this.password = password;
        score = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String  getAvatarAddress() {
        return avatarAddress;
    }

    public void setAvatarAddress(String avatarAddress) {
        this.avatarAddress = avatarAddress;
    }

    public int getDifficulty() {
        return Difficulty;
    }

    public void setDifficulty(int difficulty) {
        Difficulty = difficulty;
    }

    public String getPlaneColor() {
        return planeColor;
    }

    public void setPlaneColor(String planeColor) {
        this.planeColor = planeColor;
    }
}
