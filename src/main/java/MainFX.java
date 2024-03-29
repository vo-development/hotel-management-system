import controller.CustomerLoginController;
import controller.LoginController;
import dal.dao.UserDAO;
import helper.ViewLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {

    @Override
    public void start(Stage stage) {

        LoginController controller = new LoginController();

        Parent parent = ViewLoader.load("Login", controller);

        stage.setScene(new Scene(parent));
        stage.setTitle("Login Window");
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }

}