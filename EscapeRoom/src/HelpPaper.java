import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class HelpPaper extends Pane {

    private String folder = "file:Images/papers/";
    private Image[] papers;             // maybe an array of image: each image would be the help for one puzzle
    // change the image depending on which puzzle the player is currently on
    // => have a boolean for each puzzle (like "isClicked") that's when set to
    // True, would make the help (or instructions) of the selected puzzle.
    private ImageView[] paperView;      // will probably be the same as image

    public HelpPaper() {
        super();
        papers = new Image[16] ;            // set randomly to 16, may be more or less paper
        paperView = new ImageView[16] ;     // set randomly to 16, may be more or less paperView


        String im0url = folder + "paper_0";
        papers[0] = new Image(im0url) ;
        paperView[0] = new ImageView(papers[0]);

        String im1url = folder + "paper_1";
        papers[1] = new Image(im1url) ;
        paperView[1] = new ImageView(papers[1]);

        String im2url = folder + "paper_2";
        papers[2] = new Image(im2url) ;
        paperView[2] = new ImageView(papers[2]);

        String im3url = folder + "paper_3";
        papers[3] = new Image(im3url) ;
        paperView[3] = new ImageView(papers[3]);

        String im4url = folder + "paper_4";
        papers[4] = new Image(im4url) ;
        paperView[4] = new ImageView(papers[4]);

        String im5url = folder + "paper_5";
        papers[5] = new Image(im5url) ;
        paperView[5] = new ImageView(papers[5]);

        String im6url = folder + "paper_6";
        papers[6] = new Image(im6url) ;
        paperView[6] = new ImageView(papers[6]);

        String im7url = folder + "paper_7";
        papers[7] = new Image(im7url) ;
        paperView[7] = new ImageView(papers[7]);

        String im8url = folder + "paper_8";
        papers[8] = new Image(im8url) ;
        paperView[8] = new ImageView(papers[8]);

        String im9url = folder + "paper_9";
        papers[9] = new Image(im9url) ;
        paperView[9] = new ImageView(papers[9]);

        String im10url = folder + "paper_10";
        papers[10] = new Image(im10url) ;
        paperView[10] = new ImageView(papers[10]);

        String im11url = folder + "paper_11";
        papers[11] = new Image(im11url) ;
        paperView[11] = new ImageView(papers[11]);

        String im12url = folder + "paper_12";
        papers[12] = new Image(im12url) ;
        paperView[12] = new ImageView(papers[12]);

        String im13url = folder + "paper_13";
        papers[13] = new Image(im13url) ;
        paperView[13] = new ImageView(papers[13]);

        String im14url = folder + "paper_14";
        papers[14] = new Image(im14url) ;
        paperView[14] = new ImageView(papers[14]);

        String im15url = folder + "paper_15";
        papers[15] = new Image(im15url) ;
        paperView[15] = new ImageView(papers[15]);

    }

    public Image getPaper(int paper){
        return papers[paper];
    }

    public ImageView getPaperView(int view){
        return paperView[view];
    }




}