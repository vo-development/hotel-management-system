package controller;

import helper.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginController extends BaseController {

    @FXML
    private Button btn_Custumer;

    @FXML
    void btnOnClick(ActionEvent event) {
        var source = event.getSource();
        var stage = (Stage) btn_Custumer.getScene().getWindow();

        if (source.equals(btn_Custumer)) {
            var controller = new CustomerLoginController();
            var loginWindow = ViewLoader.load("CustomerLogin", controller);
            stage.setScene(new Scene((Parent) loginWindow));
        }

        else {

            var loginWindow = ViewLoader.load("UserLogin", new UserLoginController());
            stage.setScene(new Scene(loginWindow));
        }

    }

}
