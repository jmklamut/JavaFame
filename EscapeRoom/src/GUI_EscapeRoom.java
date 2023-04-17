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
        primaryStage.setTitle("EscapeRoom");

        Group root = new Group();
        Room easy = new Room(1);
        Room medium = new Room(2);
        Room hard = new Room(3);


        Scene scene = new Scene(root, 512, 512,true);
        primaryStage.setScene(scene);
        primaryStage.show();

        root.getChildren().add(easy);





    }

    public static void main(String[] args) {
        launch(args);
    }
}
