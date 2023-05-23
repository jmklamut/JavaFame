import javafx.animation.*;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.util.Duration;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Earth extends Pane {

    private Image earth_image;
    private ImageView earth_view;
    private double startX;
    private double startY;
    private double start_posy;
    private double vertical_speed;
    private double vertical_position;
    private boolean collisoin;
    private boolean movement;

    public Earth(Stage layout, Hook hook, Label output){
        earth_image = new Image("file:Images/earth.png");
        earth_view = new ImageView(earth_image);
        collisoin = false;
        movement = true;
        earth_view.setTranslateX(1100);
        earth_view.setTranslateY(650);
        System.out.println(earth_view.getTranslateY());
        getChildren().add(earth_view);
        earth_view.toFront();

        Bounds bound = earth_view.getBoundsInParent();
        Bounds newbounds = new Bounds(bound.getMinX()/2, bound.getMinY()/2,bound.getMinZ()/2,
                bound.getWidth()/2, bound.getHeight()/2,bound.getDepth()/2) {
            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Point2D point2D) {
                return false;
            }

            @Override
            public boolean contains(Point3D point3D) {
                return false;
            }

            @Override
            public boolean contains(double v, double v1) {
                return false;
            }

            @Override
            public boolean contains(double v, double v1, double v2) {
                return false;
            }

            @Override
            public boolean contains(Bounds bounds) {
                return false;
            }

            @Override
            public boolean contains(double v, double v1, double v2, double v3) {
                return false;
            }

            @Override
            public boolean contains(double v, double v1, double v2, double v3, double v4, double v5) {
                return false;
            }

            @Override
            public boolean intersects(Bounds bounds) {
                return false;
            }

            @Override
            public boolean intersects(double v, double v1, double v2, double v3) {
                return false;
            }

            @Override
            public boolean intersects(double v, double v1, double v2, double v3, double v4, double v5) {
                return false;
            }
        };

        vertical_speed = 0;

        start_posy = earth_view.getTranslateY();

        earth_view.setOnMousePressed(e -> {
            if(movement){
                startX = e.getSceneX() - earth_view.getTranslateX();
                startY = e.getSceneY() - earth_view.getTranslateY();
            }
        });

        earth_view.setOnMouseDragged(e -> {
            if(movement) {
                earth_view.setTranslateX(e.getSceneX() - startX);
                earth_view.setTranslateY(e.getSceneY() - startY);
                earth_view.setLayoutX(startX);
                earth_view.setLayoutY(startY);
                System.out.println("Rising: " + earth_view.getTranslateY());
                vertical_position = earth_view.getTranslateY();
            }
            if(earth_view.getBoundsInParent().intersects(hook.getHookView().getBoundsInParent())) {
                collisoin = true;
                output.setText("Check Inventory");
                movement = false;
            }
        });



        earth_view.setOnMouseReleased(e -> {
            AnimationTimer timer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    vertical_speed = vertical_speed + 1;
                    if (vertical_speed > 300) {
                        vertical_speed = 300;
                    }
                    vertical_position = vertical_position + vertical_speed;
                    if(!movement){
                        stop();
                    }
                    else if (start_posy > earth_view.getTranslateY()) {
                        System.out.println("Falling: " + earth_view.getTranslateY());
                        earth_view.setTranslateY(vertical_position);
                    }
                    else{
                        earth_view.setTranslateY(650);
                        vertical_speed = 0;
                        stop();
                    }

                }
            };
            timer.start();
        });
    }

    public boolean getCollision(){
        return collisoin;
    }

    public boolean getMovement(){
        return movement;
    }

    public ImageView getEarthView(){
        return earth_view;
    }
}
