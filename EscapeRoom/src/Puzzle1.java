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

public class Puzzle1 extends Room{

    private String solution;
    private String question;
    private Safe safe;
    private Paper paper;
    private Table table;

    public Puzzle1() {
        super();
        safe = new Safe();
        safe.setSolution("1776");
        paper = new Paper();
        table = new Table();
        table.setTranslateX(800);
        table.setTranslateY(500);
        table.setScaleX(4);
        table.setScaleY(4);
        getChildren().add(safe);
        getChildren().add(paper);
        getChildren().add(table);

/*
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(!safe.checkLock()){
                    Inventory.addItem("file:Images/key.png");
                }
            }
        };

 */
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

    public Table getTable() {
        return table;
    }
}
