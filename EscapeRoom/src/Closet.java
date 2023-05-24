import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Closet extends Pane {

    private Image closet;
    private ImageView closet_view;
    private Image open;
    private boolean open_door;
    private boolean next;


    public Closet(Label output){
        closet = new Image("file:Images/ClosetClose.jpg");
        open = new Image("file:Images/CLosetOpen.jpg");
        closet_view = new ImageView(closet);
        closet_view.setScaleX(.2);
        closet_view.setScaleY(.2);
        closet_view.setX(420);
        closet_view.setY(150);
        getChildren().add(closet_view);

        open_door = false;
        next = false;

        closet_view.setOnMouseClicked(e ->{
            if(open_door){
                System.out.println("Hello Closet");
                closet_view.setImage(open);
                closet_view.setTranslateX(-140);
                output.setText("Closet Opened!\n Note Added to Inventory!");
                next = true;
            }
            else{
                output.setText("Close Locked");
            }
        });
    }

    public void setOpen_door(boolean set){
        open_door = set;
    }

    public boolean getNext(){
        return next;
    }
}
