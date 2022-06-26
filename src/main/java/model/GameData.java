package model;

import java.util.ArrayList;

public class GameData {
    private ArrayList<User> users;
    private User activeUser;
    private boolean endGame;
    private boolean loose;
    private int timesDeath;

    public GameData(){
        timesDeath = 0;
        loose = false;
        endGame = false;
        users = new ArrayList<>();
        activeUser = null;
    }

    public void addUser(User user){
        users.add(user);
    }
    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public boolean isEndGame() {
        return endGame;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    public boolean isLoose() {
        return loose;
    }

    public void setLoose(boolean loose) {
        this.loose = loose;
    }

    public int getTimesDeath() {
        return timesDeath;
    }

    public void setTimesDeath(int timesDeath) {
        this.timesDeath = timesDeath;
    }
}
