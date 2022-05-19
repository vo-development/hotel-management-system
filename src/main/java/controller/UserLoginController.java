package controller;

import auth.AuthUser;
import auth.CurrentAuthUser;
import dal.dao.UserDAO;
import helper.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojo.User;


public class UserLoginController extends BaseController{


    @FXML
    private TextField txt_id;

    @FXML
    private PasswordField txt_pass;

    private UserDAO userDAO = new UserDAO();

    private void showErrorMessage(){
        new Alert(Alert.AlertType.ERROR,"Yanlış E posta yada Parola").showAndWait();
    }

    @FXML
    void btnOnClick(ActionEvent event) {

        var userId = Integer.parseInt(txt_id.getText());

        var password = txt_pass.getText();

        User user =  userDAO.findById(userId);

        if(user != null){
            if(user.getPassword().equals(password)){


                CurrentAuthUser.setAuthUser(user);


                var stage = (Stage) txt_id.getScene().getWindow();

                var content = ViewLoader.load("UserMain",new UserMainController());

                stage.setScene(new Scene(content));

            }
            else
                showErrorMessage();
        }

        else
            showErrorMessage();







    }




}
