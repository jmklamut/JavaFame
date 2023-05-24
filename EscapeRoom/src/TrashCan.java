import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

public class TrashCan extends Pane {

    private Image image;
    private ImageView image_view;

    public TrashCan(Label output){
        image = new Image("file:Images/trash_can.png");
        image_view = new ImageView(image);
        image_view.setTranslateY(Screen.getPrimary().getVisualBounds().getHeight()/2 + 100);
        image_view.setTranslateX(Screen.getPrimary().getVisualBounds().getWidth()/2);
        getChildren().add(image_view);

        image_view.setOnMouseClicked(e ->{
            output.setText("Nothing in the \ntrash");
        });

    }
}
