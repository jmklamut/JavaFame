import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class GUI_EscapeRoom extends Application {

    private Scene roomScene;
    private Scene inventoryScene;
    private Scene overScene;
    private Group root;
    private Group root2;
    private Group root3;
    private YesButton yes;
    private NoButton no;



    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("EscapeRoom");

        root = new Group();
        root2 = new Group();
        root3 = new Group();
        Room easy = new Room(1);
        Room medium = new Room(2);
        Room hard = new Room(3);
        Inventory inventory = new Inventory();

        roomScene = new Scene(root, 1000, 512,true);
        inventoryScene = new Scene(root2, 512, 512, true);

        overScene = new Scene(root3, 512,512,true);

        Image overImage = new Image("file:Images/game over.png");
        ImageView overView = new ImageView(overImage);
        overView.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        overView.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        root3.getChildren().add(overView);

        yes = new YesButton();
        no = new NoButton();
        root.getChildren().add(easy);
        root2.getChildren().add(inventory);
        root.getChildren().add(yes);
        root2.getChildren().add(no);

        primaryStage.setScene(roomScene);
        //primaryStage.show();

        primaryStage.setMaximized(true);
        primaryStage.setFullScreen(true);
        primaryStage.setResizable(false);

        primaryStage.show();

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(yes.isDisplay_inventory() == true) {
                    primaryStage.setScene(inventoryScene);
                    yes.setDisplay_inventory(false);
                }
                else if(no.isDisplay_inventory() == false) {
                    primaryStage.setScene(roomScene);
                    no.setDisplay_inventory(true);
                }
                if(easy.getGameTime().isGame_over()) {
                    primaryStage.setScene(overScene);
                    stop();
                }
                if(easy.getPz1().getSafe().checkLock()){
                    inventory.addItem("file:Images/key.png");
                }

                primaryStage.show();
            }

        };
        animationTimer.start();
    }

    public Scene getRoomScene(){
        return roomScene;
    }

    public Scene getInventoryScene(){
        return inventoryScene;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
