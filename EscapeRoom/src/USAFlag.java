import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class USAFlag extends Pane {

    private Image usa_image;
    private ImageView usa_view;
    private boolean action;

    public USAFlag(Label output, boolean ham){
        usa_image = new Image("file:Images/usa_flag.jpg");
        usa_view = new ImageView(usa_image);
        usa_view.setScaleY(.7);
        usa_view.setScaleX(.7);
        usa_view.setTranslateX(700);
        usa_view.setTranslateY(150);
        usa_view.setStyle("-fx-background-color: transparent;");
        usa_view.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(!ham) {
                    output.setText("Nothing in Flag");
                    action = false;
                }
                else{
                    action = true;
                }

            }
        });
        getChildren().add(usa_view);

    }

    public Image getImage(){
        return usa_image;
    }
    public ImageView getView(){
        return usa_view;
    }

    public boolean getAction(){
        return action;
    }
}
