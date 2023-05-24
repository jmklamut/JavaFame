import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Chest extends Pane {

    private Image chest_open;
    private Image chest_closed;
    private ImageView chest_view;
    private boolean food;
    private boolean next;

    public Chest(Label output){
        food = false;
        next = false;
        chest_open = new Image("file:Images/chest_open.png");
        chest_closed = new Image("file:Images/chest_closed.png");
        chest_view = new ImageView(chest_closed);
        chest_view.setScaleX(.5);
        chest_view.setScaleY(.5);
        chest_view.setTranslateX(100);
        chest_view.setTranslateY(600);
        getChildren().add(chest_view);

        chest_view.setOnMouseClicked(e ->{
            if(food){
                output.setText("Chest Opened");
                chest_view.setImage(chest_open);
                chest_view.setTranslateX(100-25);
                chest_view.setTranslateY(600-25);
                next = true;
            }
            else{
                output.setText("Locked Chest");
            }
        });
    }

    public void setFood(boolean set){
        food = set;
    }

    public boolean getNext(){
        return next;
    }
}
