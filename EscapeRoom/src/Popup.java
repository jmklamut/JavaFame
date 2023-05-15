import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.image.*;



public class Popup extends Stage{

    private Pane parent;

    public Popup(Pane parent) {
        this.parent = parent;
    }

    public void display()
    {
        //popupwindow = new Stage();

        this.initModality(Modality.APPLICATION_MODAL);
        this.setTitle("Note One");


        Label label1= new Label("Hello! Welcome to Frenchies Game!\n"+ "" +
                "You are currently in the first room of my game!\n" + "You will be able to escape if you're smart enough\n" +
                "The only clue I will give you is this:\n "+
                "The safe contains escape.\n"+
                " Look around the room to find clues.\n"+
                "Don't take too long");

        Button button1= new Button("Close");
        button1.setOnAction(e -> this.close());


        VBox layout= new VBox(10);

        StackPane stack = new StackPane();

        Image note = new Image("file:Images/HandNote.png");
        ImageView noteView = new ImageView(note);
        noteView.setScaleX(.5);
        noteView.setScaleY(.5);

        BorderPane pane = new BorderPane();
        pane.setCenter(noteView);

        layout.getChildren().addAll(label1, button1);
        layout.setAlignment(Pos.CENTER);

        stack.getChildren().addAll(noteView, layout);

        Scene scene1= new Scene(stack, 400, 300);

        this.setScene(scene1);
      //  this.initOwner((Stage)parent);
        this.showAndWait();
        //this.show();
    }

}
