import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

public class FrenchFlag extends Pane {

    private Image flag_image;
    private ImageView flag_view;
    private boolean action;

    public FrenchFlag(Label output, boolean cross){
        action = false;
        flag_image = new Image("file:Images/french_flag.jpg");
        flag_view = new ImageView(flag_image);
        flag_view.setScaleY(.4);
        flag_view.setScaleX(.4);
        flag_view.setTranslateX(400);
       // flag_view.setTranslateY(200);
        flag_view.setStyle("-fx-background-color: transparent;");

        flag_view.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(!cross) {
                    output.setText("Nothing in Flag");
                    action = false;
                }
                else{
                    action = true;
                }
            }
        });
        flag_view.toBack();
        getChildren().add(flag_view);

    }

    public ImageView getView() {
        return flag_view;
    }

    public boolean getAction(){
        return action;
    }
}
