import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.image.*;

import java.awt.*;

public class Safe extends Pane {

    private boolean isLocked;
    private String solution;
    private String image;
    private Image safe;
    private ImageView safeView;


    public Safe() {
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
        safeView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Label message = new Label("");

                PasswordField passwordField = new PasswordField();
                passwordField.setPromptText("Enter Code Here");
                getChildren().add(passwordField);
                passwordField.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        if (!passwordField.getText().equals(solution)) {
                            message.setText("Your password is incorrect!");
                            System.out.println("Your password is incorrect!");
                            isLocked = true;
                        } else {
                            message.setText("Your password has been confirmed");
                            System.out.println("Your password has been confirmed");
                            isLocked = false;
                        }

                        passwordField.clear();
                    }
                });
            }
        });
    }

    public void setSolution(String ans) {
        solution = ans;
    }

    public void check(String ans) {
        if (solution == ans) {
            isLocked = false;
        }
    }

    public Image getImage() {
        return safe;

    }

    public boolean checkLock() {
        return isLocked;
    }
}