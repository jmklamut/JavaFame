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



public class Popup {


    private static Label label1;
    private static ImageView noteView;

    public Popup(){
        label1.setText("Ah, greetings!\n You find yourself trapped within this confined room. "+
                "\nHowever fear not, for your escape hinges on your wits. \n" +
                "I am Frenchy, the enigmatic villain who \norchestrates this game. "+
                "Can you rise to the challenge? \nThe room holds the answers you seek, \nbut time is of the essence. "+
                "\n\nLet the pursuit of freedom commence!");
    }


    public static void display(int number)
    {
        Stage popupwindow = new Stage();

        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Note One");


        label1= new Label();
        switch (number){
            case 1: label1.setText("Ah, greetings!\n You find yourself trapped within this confined room. "+
                    "\nHowever fear not, for your escape hinges on your wits. \n" +
                    "I am Frenchy, the enigmatic villain who \norchestrates this game. "+
                    "Can you rise to the challenge? \nThe room holds the answers you seek, \nbut time is of the essence. "+
                    "\n\nLet the pursuit of freedom commence!");
            break;
            case 2: label1.setText("Safe Riddle:\n The combination is 8 numbers long. \n"+
                    "There are two 7s, two 1s, one 6, and one 8.\n The first number is a 1 the last is a 9" +
                    "\nHint: Dates of Freedom = Independence + Revolution");
            break;
            case 3: label1.setText("You made it to Room 2!\n You really know your French/American History!\n" +
                    "You'll find this room much harder\n" + "Don't forget you're on the clock :-)");
            break;
            case 4: label1.setText("To find the first clue, hang the globe on the hook\n");
            break;
            case 5: label1.setText("The safe password = \n FrenchAmerican");
            break;
            case 6: label1.setText("Congrats! \nYou made it to the last room!"+ "\n Eat the hamburger and baguette,"+
                   "\nthan open the chest!"+ "\nHint: Try clicking the flags");
            break;
            case 7: label1.setText("You collected a key! \nCheck Inventory");
            break;
            default:
                System.out.println("Didn't work");
        }

        Font thefont = Font.font("Comic Sans MS", 12);
        label1.setTextFill(Color.BLACK);
        label1.setFont(thefont);
        label1.setAlignment(Pos.CENTER);
        label1.setTextAlignment(TextAlignment.CENTER);
        label1.setTranslateX(8);
        label1.setTranslateY(-15);


        Button button1= new Button("Close");
        button1.setOnAction(e -> popupwindow.close());


        VBox layout= new VBox(10);

        StackPane stack = new StackPane();

        Image note = new Image("file:Images/HandNote.png");
        noteView = new ImageView(note);
        noteView.setScaleX(.5);
        noteView.setScaleY(.5);

        BorderPane pane = new BorderPane();
        pane.setCenter(noteView);

        layout.getChildren().addAll(label1, button1);
        layout.setAlignment(Pos.CENTER);

        stack.getChildren().addAll(noteView, layout);

        Scene scene1= new Scene(stack, 400, 300);

        popupwindow.setScene(scene1);

        popupwindow.showAndWait();

    }

    public Label getLabel(){
        return label1;
    }

    public static ImageView getNoteView(){
        return noteView;
    }


}
