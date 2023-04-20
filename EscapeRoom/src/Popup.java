import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;


public class Popup {

    public static void display()
    {
        Stage popupwindow = new Stage();

        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Note One");


        Label label1= new Label("Hello! Welcome to Frenchies Game!\n"+ "" +
                "You are currently in the first room of my game!\n" + "You will be able to escape if you're smart enough\n" +
                "The only clue I will give you is this:\n ");

        Button button1= new Button("Close");
        button1.setOnAction(e -> popupwindow.close());

        VBox layout= new VBox(10);
        layout.getChildren().addAll(label1, button1);
        layout.setAlignment(Pos.CENTER);

        Scene scene1= new Scene(layout, 300, 250);

        popupwindow.setScene(scene1);
        popupwindow.showAndWait();

    }

}
