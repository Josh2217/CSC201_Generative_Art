package josh;

//import javafx.scene.Parent;
//import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
//import javafx.scene.text.*;
import javafx.stage.Stage;

public class Assignment9 extends Application{
    static final int WIDTH = 1280;
    static final int HEIGHT = 720;
    static final Color BG_COLOR = new Color(0.1, 0.1, 0.1, 1);
    
    @Override
    public void start(Stage stage) throws Exception {
        /*
        //Test that everything is working
        Parent root = FXMLLoader.load(Assignment9.class.getResource("scene.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        */

        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        Image icon = new Image(Assignment9.class.getResourceAsStream("duckhaert.png"));
        stage.setTitle("Josh Johnson: Generative Art");
        stage.getIcons().add(icon);

        for(int i = 0; i < 5; ++i){
            Noise noise = new Noise(WIDTH, HEIGHT, 80);
            for(int x = 0; x < WIDTH; ++x) {
                for(int y = 0; y < HEIGHT; ++y) {
                    double temp = noise.at(x, y)/255.;
                    Rectangle rect = new Rectangle(x, y, 1, 1);
                    rect.setFill(new Color(temp, temp, temp, 0.6));
                    //System.out.printf("%.3f\n", temp);
                    root.getChildren().add(rect);
                }
            }
        }

        
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.show();
        stage.setAlwaysOnTop(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
