package josh;

//import javafx.scene.Parent;
//import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//import javafx.scene.text.*;
import javafx.stage.Stage;

import java.util.Random;

public class Assignment9 extends Application{
    static final int WIDTH = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 50;
    static final int HEIGHT = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 50;
    static final Color BG_COLOR = new Color(0.1, 0.1, 0.1, 1);
    static Random rand = new Random();
    
    @Override
    public void start(Stage stage) throws Exception {
        /*
        //Test that everything is working
        Parent root = FXMLLoader.load(Assignment9.class.getResource("scene.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        */

        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT, BG_COLOR);
        Image icon = new Image(Assignment9.class.getResourceAsStream("duckhaert.png"));
        stage.setTitle("Josh Johnson: Generative Art");
        stage.getIcons().add(icon);
        
        //this does take forever to render because I generate multiple layers
        //I could probably speed this up by finding a way to write pixels to an image then simply displaying the image instead of drawing 10s of millions of rectangles
        for(int i = 0 ; i < 5; ++i){
            //Noise noise = new Noise(WIDTH, HEIGHT, 80);
            
            double offset = rand.nextDouble(0, HEIGHT);
            for(int x = 0; x < WIDTH; ++x) {
                for(int y = 0; y < HEIGHT; ++y) {
                    //double temp = noise.at(x, y)/255.;
                    double temp = BetterNoise.noise((x + offset) / offset, (y + offset) / offset)+ 0.2;
                    if(temp > 1) temp = 1;
                    if(temp < 0) temp = 0;
                    Rectangle rect = new Rectangle(x, y, 1, 1);
                    rect.setFill(new Color(temp, temp, temp, 0.2));
                    //System.out.printf("%.3f\n", temp);
                    root.getChildren().add(rect);
                }
            }
        }
        
        
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.setFullScreen(true);
        stage.show();
        stage.setAlwaysOnTop(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
