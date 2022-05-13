package controller;

import dal.dao.UserDAO;
import helper.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController extends BaseController {


    @FXML
    public TextField txt_userName;

    @FXML
    public PasswordField txt_password;


    public LoginController(UserDAO userDAO) {
        super(userDAO);
    }

    @FXML
    public void btnLoginClick(ActionEvent actionEvent) {


    }


}
