import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.image.*;

import java.awt.*;

public class Safe extends Pane{

    private boolean isLocked;
    private String solution;
    private String image;
    private Image safe;
    private ImageView safeView;

    public Safe(){
        super();
        isLocked = true;
        image = "file:Images/Safe.png";
        solution = "";
        safe = new Image(image);
        safeView = new ImageView(safe);
        safeView.setX(100);
        safeView.setY(300);
        safeView.setScaleX(.1);
        safeView.setScaleY(.1);
        getChildren().add(safeView);
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                PasswordField passwordField = new PasswordField();
                passwordField.setPromptText("Your password");

            }
        });
    }

    public void setSolution(String ans){
        solution = ans;
    }

    public void check(String ans){
        if(solution == ans){
            isLocked = false;
        }
    }

    public Image getImage(){
        return safe;
    }

}