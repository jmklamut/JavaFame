import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static java.lang.Thread.sleep;


public class Safe extends Pane {

    private boolean isLocked;
    private String solution;
    private String image;
    private Image safe;
    private ImageView safeView;
    private Key key;


    public Safe(Label output) {
        key = new Key();
        isLocked = true;
        image = "file:Images/Safe.png";
        solution = "";
        safe = new Image(image);
        safeView = new ImageView(safe);
        safeView.setX(775);
        safeView.setY(292);
        safeView.setScaleX(.2);
        safeView.setScaleY(.2);
        safeView.setDisable(false);
        getChildren().add(safeView);
        safeView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                StackPane pane_word = new StackPane();
                pane_word.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
                Canvas canvas = new Canvas(750,80);
                canvas.setLayoutX(100);
                GraphicsContext gc = canvas.getGraphicsContext2D();
                gc.setFill(Color.BLUE);
                Font thefont = Font.font("Times New Roman", FontWeight.BOLD, 20);
                gc.setFont(thefont);
                gc.fillText("Enter the Key Code Here",75, 75);
                gc.strokeText("Enter the Key Code Here", 75, 75);
                TextField password = new TextField();
                password.setPromptText("Enter Code Here");
                pane_word.getChildren().addAll(password, canvas);
                pane_word.setTranslateX(300);
                getChildren().add(pane_word);
                password.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if(!password.getText().equals(solution)) {
                            gc.clearRect(0,0,750,80);
                            gc.fillText("Your password is incorrect!",75, 75);
                            gc.strokeText("Your password is incorrect!", 75, 75);
                            System.out.println("Your password is incorrect!");
                            changeLock(true);
                            isLocked = true;
                    } else {
                            try{
                                changeLock(false);
                                isLocked = false;
                                output.setText("Safe has been unlocked!");
                                gc.clearRect(0,0,750,80);
                                gc.fillText("Safe Unlocked! Check Inventory!",75, 75);
                                gc.strokeText("Safe Unlocked! Check Inventory!", 75, 75);
                                System.out.println("Safe Unlocked! Check Inventory!");
                                sleep(3000);
                                pane_word.getChildren().remove(canvas);
                                pane_word.getChildren().remove(password);
                            }
                            catch(Exception e){
                                System.out.println("Don't work");
                            }
                    }
                    password.clear();
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

    public ImageView getSafeView(){
        return safeView;
    }

    public void runningSafe(){
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                System.out.println(l);
            }
        };
        timer.start();
    }

    public boolean checkLock() {
        return isLocked;
    }

    public void changeLock(boolean lock){
        isLocked = lock;
    }
}