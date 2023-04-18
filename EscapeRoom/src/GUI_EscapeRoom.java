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
        Group root2 = new Group();
        Room easy = new Room(1);
        Room medium = new Room(2);
        Room hard = new Room(3);

        Inventory inventory = new Inventory();

        Scene scene = new Scene(root, 512, 512,true);
        Scene invent = new Scene(root2, 512, 512, true);
        root.getChildren().add(easy);

        if(easy.getDisplay() == false) {
            primaryStage.setScene(scene);
        }
        else{
            primaryStage.setScene(invent);
        }
        primaryStage.show();







    }


    public static void main(String[] args) {
        launch(args);
    }
}
