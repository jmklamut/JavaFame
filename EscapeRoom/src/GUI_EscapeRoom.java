import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
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
    private Inventory inventory;
    private Puzzle1 easy;
   // private NoButton no;



    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("EscapeRoom");

        root = new Group();
       // root2 = new Group();
        root3 = new Group();
        inventory = new Inventory();
        easy = new Puzzle1(inventory, root);
        Room medium = new Room();
        Room hard = new Room();


        roomScene = new Scene(root, 1000, 512,true);

        //inventoryScene = new Scene(root2, 512, 512, true);

        overScene = new Scene(root3, 512,512,true);

        Image overImage = new Image("file:Images/game over.png");
        ImageView overView = new ImageView(overImage);
        overView.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        overView.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        root3.getChildren().add(overView);

        yes = new YesButton();
       // no = new NoButton();
        root.getChildren().add(easy);
       // root2.getChildren().add(inventory);


        root.getChildren().add(yes);

       // root2.getChildren().add(no);

        primaryStage.setScene(roomScene);
        //primaryStage.show();

      //  primaryStage.setMaximized(true);
      //  primaryStage.setFullScreen(true);


        primaryStage.show();

        easy.getSafe().getSafeView().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Hello");
            }
        });

        yes.getImageYes().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                inventory.getStage().show();
                inventory.getStage().setMaximized(true);
                inventory.getStage().setFullScreen(true);
            }
        });


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(easy.getGameTime().isGame_over()){
                    primaryStage.setScene(overScene);
                    primaryStage.setMaximized(true);
                    primaryStage.setFullScreen(true);
                    stop();
                }
            }
        };
        timer.start();

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
