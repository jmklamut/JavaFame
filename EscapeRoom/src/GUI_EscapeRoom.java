import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI_EscapeRoom extends Application {


    private Scene RoomScene;
    private Scene InventoryScene;
    private Group root;
    private Group root2;
    private Button yes;
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

        RoomScene = new Scene(root, 512, 512,true);
        InventoryScene = new Scene(root2, 512, 512, true);
        yes = new Button();
        no = new NoButton();
        root.getChildren().add(easy);
        root2.getChildren().add(inventory);
        root.getChildren().add(yes);
        root2.getChildren().add(no);

        primaryStage.setScene(RoomScene);
        primaryStage.show();

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(yes.isDisplay_inventory() == true) {
                    primaryStage.setScene(InventoryScene);
                    yes.setDisplay_inventory(false);
                } else if(no.isDisplay_inventory() == false) {
                    primaryStage.setScene(RoomScene);
                    no.setDisplay_inventory(true);
                }
            }

        };
        animationTimer.start();
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
