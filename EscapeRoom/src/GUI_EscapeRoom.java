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

public class GUI_EscapeRoom extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Move the Planet");

        Group root = new Group();
        //Scene theScene = new Scene(root);
        // primaryStage.setScene(scene);

        Scene scene = new Scene(root, 512, 512,true);
        primaryStage.setScene(scene);
        primaryStage.show();

        Pane canvas = new Pane();
        Image background = new Image("file:Images/background.jpg");
        ImageView backgroundView = new ImageView(background);
        backgroundView.setViewport(new Rectangle2D(0,0,512,512));

        root.getChildren().add(canvas);
        root.getChildren().add(backgroundView);
        backgroundView.setX(0);
        backgroundView.setY(0);
        canvas.setTranslateX(0);
        Image earth = new Image("file:Images/earth.png");
        Image sun = new Image("file:Images/sun.png");

        ImageView ear = new ImageView(earth);
        ImageView s = new ImageView(sun);

        s.setX(512/2 - 64);
        s.setY(512/2 -64);
        ear.setX(300);
        ear.setY(100);
        root.getChildren().add(ear);
        root.getChildren().add(s);

        final long startNanoTime = System.nanoTime();
        new AnimationTimer(){
            public void handle(long currentNanoTime){
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                double x = 232 + 128 * Math.cos(t);
                double y = 232 + 128 * Math.sin(t);
                ear.setX(x);
                ear.setY(y);
                ear.setRotate(90*t);

            }
        }.start();



/*
            Canvas canvas = new Canvas(400, 250);
            root.getChildren().add(canvas);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.drawImage(earth,180,100);
            */


    }

    public static void main(String[] args) {
        launch(args);
    }
}
