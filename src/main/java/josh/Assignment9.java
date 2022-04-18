package josh;

//import javafx.scene.Parent;
//import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
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
        Scene scene = new Scene(root, new Color(0.8, 0.8, 0.8, 0.8));
        stage.setScene(scene);


        stage.setTitle("Assignment 9");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
