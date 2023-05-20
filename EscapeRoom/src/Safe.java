import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.*;
import javafx.scene.control.Label;


public class Safe extends Pane {

    private boolean isLocked;
    private String solution;
    private String image;
    private Image safe;
    private ImageView safeView;
    private Key key;


    public Safe() {
        super();
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
        getChildren().add(safeView);
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