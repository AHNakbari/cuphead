package controller;

import javafx.scene.image.ImageView;
import model.component.AirPlane;

import java.util.ArrayList;

public class AirPlaneAction {

    private static AirPlane airPlane;
    public AirPlaneAction(AirPlane airPlane){
        AirPlaneAction.airPlane = airPlane;
    }

    public void moveUp(){
        if (airPlane.getImageView().getLayoutY() > 20)
            airPlane.getImageView().setLayoutY(airPlane.getImageView().getLayoutY() - 20);
    }

    public void moveDown(){
        if (airPlane.getImageView().getLayoutY() < 320)
            airPlane.getImageView().setLayoutY(airPlane.getImageView().getLayoutY() + 20);
    }

    public void moveLeft(){
        if (airPlane.getImageView().getLayoutX() > 20)
            airPlane.getImageView().setLayoutX(airPlane.getImageView().getLayoutX() - 20);
    }

    public void moveRight(){
        if (airPlane.getImageView().getLayoutX() < 500){
            airPlane.getImageView().setLayoutX(airPlane.getImageView().getLayoutX() + 20);
        }
    }

    public void shootBullet(ArrayList<ImageView> bullets){

    }

}
