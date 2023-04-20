import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

public class Puzzle1 extends Pane{

    private String solution;
    private String question;
    private Safe safe;
    private Paper paper;

    public Puzzle1(){
        safe = new Safe();
        safe.setSolution("1776");
        paper = new Paper();

    }

    public String displayQuestion(){
        return question;
    }

    public String displaySolution(){
        return solution;
    }

    public Safe getSafe(){
        return safe;
    }

    public Paper getPaper() {return paper; }

}
