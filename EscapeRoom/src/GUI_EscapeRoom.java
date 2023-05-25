import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.File;
import java.util.Collections;

//At the time of turning this in I realized that most of this stuff is repetitive and unoptimized
//If give more time I would put most of this in the Room class(for example label and vbox


public class GUI_EscapeRoom extends Application {

    private Scene pz1_scene;
    private Scene over_scene;
    private Scene pz2_scene;
    private Scene pz3_scene;
    private Scene vic_scene;

    private Group pz1_root;
    private Group pz2_root;
    private Group pz3_root;
    private Group invent_root;
    private Group vic_root;

    private VBox vbox;
    private VBox vbox1;
    private VBox vbox2;

    private Label output;
    private Label output_med;
    private Label output_hard;

    private Inventory inventory;
    private Puzzle1 easy;
    private Puzzle2 medium;
    private Puzzle3 hard;
   // private NoButton no;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("EscapeRoom");
        output = new Label("Click On Something");
        output_med = new Label("Click On Something");
        output_hard = new Label("Click On Something");

        invent_root = new Group();
        pz1_root = new Group();
        pz2_root = new Group();
        pz3_root = new Group();
        vic_root =  new Group();

        inventory = new Inventory(primaryStage);

        easy = new Puzzle1(inventory, pz1_root, output);
        medium = new Puzzle2(inventory, pz2_root, output_med, primaryStage);
        hard = new Puzzle3(inventory, pz3_root, output_hard);



        pz1_scene = new Scene(pz1_root, 1000, 512,true);
        pz2_scene = new Scene(pz2_root,1000,512, true);
        pz3_scene = new Scene(pz3_root,1000,512, true);

        over_scene = new Scene(invent_root, 512,512,true);

        vic_scene = new Scene(vic_root, 512, 512, true);

        Image overImage = new Image("file:Images/game over.png");
        ImageView overView = new ImageView(overImage);
        overView.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        overView.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        invent_root.getChildren().add(overView);

        Image vic_image = new Image("file:Images/victory.png");
        ImageView vic_view = new ImageView(vic_image);
        vic_view.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        vic_view.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        vic_root.getChildren().add(vic_view);




        pz2_root.getChildren().add(medium);
        pz2_root.getChildren().add(medium.getBack());
        pz2_root.getChildren().add(medium.getEarth().getEarthView());
      //  pz2_root.getChildren().add(medium.getUsa().getView());
       // pz2_root.getChildren().add(medium.getSafe().getSafeView());
        //pz2_root.getChildren().add(medium.getTable().getTableView());

        pz1_root.getChildren().add(easy);
        pz1_root.getChildren().add(easy.getSafe().getSafeView());
        pz1_root.getChildren().add(easy.getDoor().getDoorView());
        pz1_root.getChildren().add(easy.getPaper().getPaperView());
        pz1_root.getChildren().add(easy.getFlag().getView());

        pz3_root.getChildren().add(hard);

        vbox = new VBox();
        vbox.setTranslateX(1536 - 300);
        vbox.setTranslateY(816 - 100);

        Font thefont = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 22);
        output.setTextFill(Color.RED);
        output.setFont(thefont);

        vbox.getChildren().add(output);
        pz1_root.getChildren().add(vbox);


        vbox1 = new VBox();
        vbox1.setTranslateX(1536 - 300);
        vbox1.setTranslateY(816 - 100);

        Font thefont1 = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 22);
        output_med.setTextFill(Color.RED);
        output_med.setFont(thefont1);

        vbox1.getChildren().add(output_med);
        pz2_root.getChildren().add(vbox1);


        vbox2 = new VBox();
        vbox2.setTranslateX(1536 - 300);
        vbox2.setTranslateY(816 - 100);

        Font thefont2 = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 22);
        output_hard.setTextFill(Color.RED);
        output_hard.setFont(thefont2);

        vbox2.getChildren().add(output_hard);
        pz3_root.getChildren().add(vbox2);


        primaryStage.setScene(pz1_scene);

        primaryStage.setMaximized(true);
        primaryStage.setFullScreen(true);

        primaryStage.show();


        ObservableList<Node> collection = FXCollections.observableArrayList(pz2_root.getChildren());
        Collections.swap(collection,0,1);
        pz2_root.getChildren().setAll(collection);




        easy.getYes().getImageYes().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                inventory.getStage().show();
                inventory.getStage().setMaximized(true);
                inventory.getStage().setFullScreen(true);
            }
        });

        medium.getYes().getImageYes().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                inventory.getStage().show();
                inventory.getStage().setMaximized(true);
                inventory.getStage().setFullScreen(true);

            }
        });

        hard.getYes().getImageYes().setOnMouseClicked(new EventHandler<MouseEvent>() {
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
                if(easy.getGameTime().isGame_over() || medium.getGameTime().isGame_over() || hard.getGameTime().isGame_over()){
                    primaryStage.setScene(over_scene);
                    primaryStage.setMaximized(true);
                    primaryStage.setFullScreen(true);
                    stop();
                }
                if(easy.getDoor().nextRoom()){
                    PauseTransition pause = new PauseTransition(Duration.seconds(5));
                    pause.setOnFinished(eventP -> {
                        primaryStage.setScene(pz2_scene);
                        primaryStage.setMaximized(true);
                        primaryStage.setFullScreen(true);
                        pz2_root.setCursor(Cursor.DEFAULT);
                        inventory.setWorked(false);
                        medium.getDoor().setLocked(true);
                        medium.getDoor().setRoom(false);
                        stop();
                    });
                    pause.play();
                    output.setText("Congrats! Going \ninto next room...");
                    inventory.removeItem(easy.getKey().getImageView());
                    inventory.defaultCursor();

                    String musicFile = "Sound/Solved.mp3";     // For example
                    Media sound = new Media(new File(musicFile).toURI().toString());
                    MediaPlayer mediaPlayer = new MediaPlayer(sound);
                    mediaPlayer.play();
                    stop();
                }
            }
        };
        timer.start();

        AnimationTimer timer2 = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(easy.getGameTime().isGame_over() || medium.getGameTime().isGame_over() || hard.getGameTime().isGame_over()){
                    primaryStage.setScene(over_scene);
                    primaryStage.setMaximized(true);
                    primaryStage.setFullScreen(true);
                    stop();
                }
                if(medium.getDoor().nextRoom()){
                    PauseTransition pause = new PauseTransition(Duration.seconds(5));
                    pause.setOnFinished(eventP -> {
                        primaryStage.setScene(pz3_scene);
                        primaryStage.setMaximized(true);
                        primaryStage.setFullScreen(true);
                        inventory.removeItem(medium.getPaper3().getPaperView());
                    });
                    pause.play();
                    output.setText("Congrats! Going \ninto next room...");
                    inventory.removeItem(medium.getKey().getImageView());
                    inventory.defaultCursor();

                    String musicFile = "Sound/Solved.mp3";     // For example
                    Media sound = new Media(new File(musicFile).toURI().toString());
                    MediaPlayer mediaPlayer = new MediaPlayer(sound);
                    mediaPlayer.play();
                    stop();
                }
            }
        };
        timer2.start();

        AnimationTimer timer3 = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(easy.getGameTime().isGame_over() || medium.getGameTime().isGame_over() || hard.getGameTime().isGame_over()){
                    primaryStage.setScene(over_scene);
                    primaryStage.setMaximized(true);
                    primaryStage.setFullScreen(true);
                    stop();
                }
                if(hard.getDoor().nextRoom()){
                    PauseTransition pause = new PauseTransition(Duration.seconds(5));
                    pause.setOnFinished(eventP -> {
                        primaryStage.setScene(vic_scene);
                        primaryStage.setMaximized(true);
                        primaryStage.setFullScreen(true);

                        String musicFile = "Sound/Hooray.mp3";     // For example
                        Media sound = new Media(new File(musicFile).toURI().toString());
                        MediaPlayer mediaPlayer = new MediaPlayer(sound);
                        mediaPlayer.play();

                        inventory.removeItem(medium.getPaper3().getPaperView());
                    });
                    pause.play();
                    output.setText("Congrats! Going \ninto next room...");
                    inventory.removeItem(medium.getKey().getImageView());
                    inventory.defaultCursor();
                    stop();
                }

            }
        };
        timer3.start();

    }

    public Scene getPz1_scene(){
        return pz1_scene;
    }



    public static void main(String[] args) {
        launch(args);
    }
}
