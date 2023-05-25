import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import javafx.scene.paint.Color;
import javafx.scene.text.*;

import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.canvas.*;

public class GameTime extends Pane{
    private Integer seconds;
    private Timer countdown;
    private Canvas canvas;
    private TimerTask timerTask;
    private boolean game_over;

    public GameTime(){
        seconds = 300;
        countdown = new Timer();
        game_over = false;
        //display = new Label(seconds.toString());
        //System.out.println(display.getText());
        canvas = new Canvas(300,150);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.moveTo(0,0);
        gc.setFill(Color.WHITE);
        Font thefont = Font.font("Times New Roman", FontWeight.BOLD, 30);
        gc.setFont(thefont);
        gc.fillText("Timer +"+seconds.toString(), 75, 75);
        gc.strokeText("Timer+" + seconds.toString(), 75, 75);


        timerTask = new TimerTask() {
            @Override
            public void run() {
                if(0 < seconds) {
                    Platform.runLater(() ->gc.clearRect(0,0,300,150));
                    Platform.runLater(() ->gc.fillText("Timer: " + seconds.toString(), 75, 75));

                    seconds--;
                }
                else{
                    countdown.cancel();
                    game_over = true;

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

    public boolean isGame_over() {
        return game_over;
    }


}


