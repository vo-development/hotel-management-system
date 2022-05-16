package controller;

import helper.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class UserLoginController extends BaseController{


    @FXML
    private TextField txt_id;

    @FXML
    private PasswordField txt_pass;

    @FXML
    void btnOnClick(ActionEvent event) {
        var stage = (Stage) txt_id.getScene().getWindow();

        var content = ViewLoader.load("UserMain",new UserMainController());

        stage.setScene(new Scene(content));
    }




}
