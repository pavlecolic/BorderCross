package com.example.bordercrossing;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class MainController  {

    @FXML
    GridPane gridPane;
    @FXML
    Button startButton;
    @FXML
    Button initButton;

    TranslateTransition transition;
    TranslateTransition transition_1;
    TranslateTransition[] moveColumnTransition = new TranslateTransition[4];

    private static final int GRID_WIDTH = 7;
    private static final int GRID_HEIGHT = 14;
    private static final int MAIN_COL_LENGTH = 5;
    private static final int LAST_IN_COLUMN = GRID_HEIGHT - MAIN_COL_LENGTH;
    private static final int POLICE_TERMINAL_ROW = 5;
    private static final int CUSTOMS_TERMINAL_ROW = 2;
    private static final int CARS_COLUMN = 3;

    private static ArrayList<Rectangle> rectangleArrayList = new ArrayList<>();
    private static int counter = 0;

    public void start(ActionEvent actionEvent) {
        method1(rectangleArrayList.get(counter));
        counter++;
    }
    public static void shiftUp(Rectangle rectangle) {

    }
    public void method1(Rectangle rectangle) {
        transition = new TranslateTransition();
        transition.setNode(rectangle);
        transition.setDuration(Duration.seconds(3));
        transition.setToY(rectangle.getY() - 210);
        transition.setToX(rectangle.getX() - 450);

        transition_1 = new TranslateTransition();
        transition_1.setNode(rectangle);
        transition_1.setDuration(Duration.seconds(1.5));
        transition_1.setToY(rectangle.getY() - 410);

        transition.play();

        for(int i = 0; i < 4 - counter; i++)  {
            moveColumnTransition[i].play();
        }
        transition.setOnFinished(actionEvent1 -> {
            try {
                Thread.sleep(2000);
//                rectangleArrayList.get(0).setX(rectangleArrayList.get(0).getX() - 450);
//                rectangleArrayList.get(0).setY(rectangleArrayList.get(0).getY() - 210);
                transition_1.play();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        transition_1.setOnFinished(event -> {
//            rectangleArrayList.get(0).setY(rectangleArrayList.get(0).getY() - 200);
            rectangleArrayList.remove(0);

        });

    }

    private static void inc() {
        counter++;
    }
    public void initTransition_1(int nodeIndex) {

    }
    public void initialize(ActionEvent actionEvent) {
        for(int i = 0; i  < 2; i++) {
            Rectangle rectangle = new Rectangle(200, 50);
            rectangle.setFill(Color.AQUAMARINE);
            gridPane.add(rectangle, i*4 + 1, 2);
        }

        for(int i = 0; i < 3; i++) {
            Rectangle rectangle = new Rectangle(200, 50);
            rectangle.setFill(Color.DARKGRAY);
            gridPane.add(rectangle, i * 2 + 1 , 5);
        }

        for (int i = 0; i < 5; i++) {
            Rectangle rectangle = new Rectangle(50, 50);
            Random rand = new Random();
            int val = rand.nextInt(3);
            if(val == 0) {
                rectangle.setFill(Color.YELLOW);
            }
            else if(val == 1) {
                rectangle.setFill(Color.BLUE);
            }
            else {
                rectangle.setFill(Color.RED);
            }
            rectangleArrayList.add(rectangle);
            gridPane.add(rectangle, 3, LAST_IN_COLUMN + i);
        }
        gridPane.setHgap(5);
        gridPane.setVgap(5);

//        for(int i = 0; i < 5; i++) {
//            transition[i]=new TranslateTransition();
//            transition[i].setNode(rectangleArrayList.get(i));
//            transition[i].setDuration(Duration.seconds(3));
//
//            transition[i].setToY(rectangleArrayList.get(i).getY() -210);
//            transition[i].setToX(rectangleArrayList.get(i).getX() -450);
//        }
//        for(int i = 0; i < 5; i++) {
//            transition_1[i] = new TranslateTransition();
//            transition_1[i].setNode(rectangleArrayList.get(i));
//            transition_1[i].setDuration(Duration.seconds(1.5));
//            transition_1[i].setToY(rectangleArrayList.get(i).getY() - 410);
//        }



//        transition = new TranslateTransition();
//        transition.setNode(rectangleArrayList.get(0));
//        transition.setDuration(Duration.seconds(3));
//        transition.setToY(rectangleArrayList.get(0).getY() - 210);
//        transition.setToX(rectangleArrayList.get(0).getX() - 450);
//
//        transition_1 = new TranslateTransition();
//        transition_1.setNode(rectangleArrayList.get(0));
//        transition_1.setDuration(Duration.seconds(1.5));
//        transition_1.setToY(rectangleArrayList.get(0).getY() - 410);

        for(int i = 0; i < 4; i++) {
            moveColumnTransition[i] = new TranslateTransition();
            moveColumnTransition[i].setNode(rectangleArrayList.get(i + 1));
            moveColumnTransition[i].setDuration(Duration.seconds(2));
            moveColumnTransition[i].setToY(rectangleArrayList.get(i + 1).getY() - 40);
        }
    }

}
