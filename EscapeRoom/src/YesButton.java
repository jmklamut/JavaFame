import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class YesButton extends Pane{

    private boolean display_inventory;
    private String inventory_button;
    private Image button;
    private ImageView buttonView;

    public YesButton(){
        display_inventory = false;
        inventory_button = "file:Images/yes.png";
        button = new Image(inventory_button);
        buttonView = new ImageView(button);
        buttonView.setX(500);
        buttonView.setY(500);
        buttonView.setScaleX(.1);
        buttonView.setScaleY(.1);
        getChildren().add(buttonView);
        /*
        buttonView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //Inventory.displayInventory();
                display_inventory = true;
            }
        });
         */
    }

    public boolean isDisplay_inventory() {
        return display_inventory;
    }

    public void setDisplay_inventory(boolean display_inventory) {

        this.display_inventory = display_inventory;
    }

    public ImageView getImageYes(){
        return buttonView;
    }

}
