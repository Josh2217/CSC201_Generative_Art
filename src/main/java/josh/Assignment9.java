package josh;

//import javafx.scene.Parent;
//import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Assignment9 extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        /*
        //Test that everything is working
        Parent root = FXMLLoader.load(Assignment9.class.getResource("scene.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        */

        Group root = new Group();
        Scene scene = new Scene(root, 1280, 720, new Color(0.1, 0.1, 0.1, 1));
        
        Image icon = new Image(Assignment9.class.getResourceAsStream("duckhaert.png"));
        Text text = new Text(100., 100., "Josh Johnson");
        text.setFont(new Font("Consolas", 48));
        text.setFill(Color.WHITE);
        root.getChildren().add(text);

        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.setTitle("Josh Johnson: Generative Art");
        stage.setAlwaysOnTop(true);
        stage.show();
        stage.setAlwaysOnTop(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
