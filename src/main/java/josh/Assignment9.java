package josh;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

//combines my scuffed af implementation of Perlin Noise, with Perlin's actual implementation to make some pretty marble like textures
public class Assignment9 extends Application{
    static final int WIDTH = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    static final int HEIGHT = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    static final int FRAMES = 14;
    static final Color BG_COLOR = new Color(0.1, 0.1, 0.1, 1);
    static Random rand = new Random();
    
    @Override
    public void start(Stage stage) throws Exception {

        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT, BG_COLOR);
        Image icon = new Image(Assignment9.class.getResourceAsStream("duckhaert.png"));
        stage.setTitle("Josh Johnson: Generative Art");
        stage.getIcons().add(icon);
        
        
        double sums[][] = new double[WIDTH][HEIGHT];
        for(int i = 0; i < FRAMES + (FRAMES & 1); ++i){
            Noise noise = new Noise(WIDTH, HEIGHT, 160 / (i + 1) + 1);
            double offset = rand.nextDouble(0, HEIGHT);
            
            for(int x = 0; x < WIDTH; ++x) {
                for(int y = 0; y < HEIGHT; ++y) {
                    double temp = BetterNoise.noise(x / offset + 0.69, y / offset + 0.69);
                    if(temp > 1) temp = 1;
                    if(temp < 0) temp = 0;
                    sums[x][y] += temp;
                    temp = noise.at(x, y)/510.;
                    if(temp > 1) temp = 1;
                    if(temp < 0) temp = 0;
                    sums[x][y] += temp;

                }
            }
        }

        WritableImage raster = new WritableImage(WIDTH, HEIGHT);
        PixelWriter pw = raster.getPixelWriter();
        
        for(int x = 0; x < sums.length; ++x) {
            for(int y = 0; y < sums[x].length; ++y) {
                sums[x][y] /= FRAMES;
                pw.setColor(x, y, Color.gray(sums[x][y]));
            }
        }
        root.getChildren().add(new ImageView(raster));
        
        
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
