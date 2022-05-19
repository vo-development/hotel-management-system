package controller;

import auth.CurrentCustomer;
import dal.dao.CustomerDAO;
import helper.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojo.Customer;

public class CustomerLoginController extends BaseController {


    @FXML
    public TextField txt_mail;

    @FXML
    public PasswordField txt_password;

    @FXML
    public Button btn_login;

    @FXML
    public Button btn_register;

    private CustomerDAO customerDAO = new CustomerDAO();


    private void showErrorMessage(){
        new Alert(Alert.AlertType.ERROR,"Yanlış E posta yada Parola").showAndWait();
    }

    @FXML
    public void btnLoginClick(ActionEvent actionEvent) {

        var source = actionEvent.getSource();
        var stage = (Stage) txt_mail.getScene().getWindow();


        if(source.equals(btn_register)){
            var registerController = new CustomerRegisterController();
            var registerWindow = ViewLoader.load("CustomerRegister",registerController);
            stage.setScene(new Scene(registerWindow));
        }

        else{

            var mail = txt_mail.getText();
            var password = txt_password.getText();

            var user = customerDAO.findByMail(mail);

            if(user != null){

                if(user.getPassword().equals(password)){

                    CurrentCustomer.setCustomer(user);
                    var mainWindow = ViewLoader.load("CustomerMain", new CustomerMainController());
                    stage.setScene(new Scene(mainWindow));
                }

                else {
                    showErrorMessage();
                }

            }

            else {
                showErrorMessage();
            }



        }

    }


}
