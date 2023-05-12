import com.sun.webkit.graphics.WCGraphicsContext;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.*;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;



public class GUI_EscapeRoom extends Application {

    public Integer seconds;
    private Scene RoomScene;
    private Scene InventoryScene;
    private Group root;
    private Group root2;
    private YesButton yes;
    private NoButton no;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("EscapeRoom");

        root = new Group();
        root2 = new Group();
        Room easy = new Room(1);
        Room medium = new Room(2);
        Room hard = new Room(3);
        Inventory inventory = new Inventory();

        RoomScene = new Scene(root, 1000, 512,true);

        InventoryScene = new Scene(root2, 512, 512, true);
        yes = new YesButton();
        no = new NoButton();
        root.getChildren().add(easy);
        root2.getChildren().add(inventory);
        root.getChildren().add(yes);
        root2.getChildren().add(no);

        primaryStage.setScene(RoomScene);
        primaryStage.setMaximized(true);
        primaryStage.show();


        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(yes.isDisplay_inventory() == true) {
                    primaryStage.setScene(InventoryScene);
                    yes.setDisplay_inventory(false);
                }
                else if(no.isDisplay_inventory() == false) {
                    primaryStage.setScene(RoomScene);

                    no.setDisplay_inventory(true);
                }
                primaryStage.setMaximized(true);
            }

        };
        animationTimer.start();

        seconds = 10;
        Timer countdown = new Timer();
        Label display = new Label(seconds.toString());
        System.out.println(display.getText());

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(0 < seconds) {
                    System.out.println(seconds);
                    Platform.runLater(() -> display.setText(seconds.toString()));
                    seconds--;
                }
                else{
                    countdown.cancel();
                }
            }
        };

        countdown.scheduleAtFixedRate(timerTask,1000,1000);



    }

    public Scene getRoomScene(){
        return RoomScene;
    }

    public Scene getInventoryScene(){
        return InventoryScene;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
