import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Hamburger extends Pane {

    private Image ham_image;
    private ImageView ham_view;
    private boolean food;
    private boolean in;

    public Hamburger(Inventory inventory, Label output){
        food = false;
        in = false;
        ham_image = new Image("file:Images/Hamburger.jpg");
        ham_view = new ImageView(ham_image);
        ham_view.setTranslateY(-200);
        ham_view.setTranslateX(500);
        ham_view.setScaleX(.3);
        ham_view.setScaleY(.3);
        getChildren().add(ham_view);

        ham_view.setOnMouseClicked(e ->{
            if(!in) {
                getChildren().remove(ham_view);
                inventory.addItem(ham_view);
                ham_view.setX(-450);
                ham_view.setY(-650);
                output.setText("Go to inventory \nto eat");
            }
            else if(in){
                inventory.removeItem(ham_view);
                food = true;
                /*
                String musicFile = "file:Sound/crunch.mp3";     // For example
                Media sound = new Media(new File(musicFile).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
                 */
                AudioClip note = new AudioClip(this.getClass().getResource("crunch.wav").toString());
                note.play();
            }
            in = true;
        });
    }

    public ImageView getView(){
        return ham_view;
    }

    public Image getImage(){
        return ham_image;
    }

    public boolean getFood(){
        return food;
    }
}
