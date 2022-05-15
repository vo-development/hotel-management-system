package controller;

import helper.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomerLoginController extends BaseController {


    @FXML
    public TextField txt_userName;

    @FXML
    public PasswordField txt_password;

    @FXML
    public Button btn_login;

    @FXML
    public Button btn_register;



    @FXML
    public void btnLoginClick(ActionEvent actionEvent) {

        var source = actionEvent.getSource();
        var stage = (Stage) txt_userName.getScene().getWindow();


        if(source.equals(btn_register)){
            var registerController = new CustomerRegisterController();
            var registerWindow = ViewLoader.load("CustomerRegister",registerController);
            stage.setScene(new Scene(registerWindow));
        }

        else{

            var mainWindow = ViewLoader.load("CustomerMain", new CustomerMainController());
            stage.setScene(new Scene(mainWindow));
        }

    }


}
