package controller;

import dal.dao.UserDAO;
import helper.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
    private CheckBox chckbx_clsnGrs;

    @FXML
    public void btnLoginClick(ActionEvent actionEvent) {

        var source = actionEvent.getSource();
        var stage = (Stage) txt_userName.getScene().getWindow();


        if(source.equals(btn_register)&&!chckbx_clsnGrs.isSelected()){
            var registerController = new CustomerRegisterController();
            var registerWindow = ViewLoader.load("CustomerRegister",registerController);
            stage.setScene(new Scene((Parent) registerWindow));
        }
else if ( chckbx_clsnGrs.isSelected() &&source.equals(btn_register)){//burasi eksik yada hata


    var userLoadingController = new UserController();
            var UserWindow = ViewLoader.load("user",new UserController());
            stage.setScene(new Scene(UserWindow));
}
        else{

            var mainWindow = ViewLoader.load("Main", new MainController());
            stage.setScene(new Scene(mainWindow));
        }



    }


}
