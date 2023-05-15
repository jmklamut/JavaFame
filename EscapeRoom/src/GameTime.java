import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;

import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.image.*;
import java.awt.*;

import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;

public class GameTime extends Pane{
    private Integer seconds;
    private Timer countdown;
    private Canvas canvas;
    private TimerTask timerTask;
    private boolean gameover;

    public GameTime(){
        seconds = 10;
        countdown = new Timer();
        gameover = false;
        //display = new Label(seconds.toString());
        //System.out.println(display.getText());
        canvas = new Canvas(150,150);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.moveTo(0,0);
        gc.setFill(Color.BLUE);
        Font thefont = Font.font("Times New Roman", FontWeight.BOLD, 20);
        gc.setFont(thefont);
        gc.fillText("Time +"+seconds.toString(), 75, 75);
        gc.strokeText("Time+" + seconds.toString(), 75, 75);


        timerTask = new TimerTask() {
            @Override
            public void run() {
                if(0 < seconds) {
                    Platform.runLater(() ->gc.clearRect(0,0,150,150));
                    Platform.runLater(() ->gc.fillText("Time:" + seconds.toString(), 75, 75));
                    seconds--;
                }
                else{
                    countdown.cancel();
                    gameover = true;

                }
            }
        };
        countdown.scheduleAtFixedRate(timerTask,1000,1000);
        getChildren().add(canvas);
    }

    public Timer getTimer(){
        return countdown;
    }

    public Canvas getCanvas(){
        return canvas;
    }

    public boolean isGameover() {
        return gameover;
    }
}


