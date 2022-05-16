package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojo.User;

import org.apache.commons.validator.routines.EmailValidator;

import dal.dao.UserDAO;
import helper.ViewLoader;





//otel çalisan kayit yeri
public class UserRegisterController extends BaseController{
    @FXML
    private TextField txt_UserMail;

    @FXML
    private TextField txt_UserName;

    @FXML
    private PasswordField txt_UserPsswrd;

private String name;
private String password;
private String mail;


private boolean isBlank(){

    // isBlank sadece bos olunca calisir
    return password.isBlank() ||
            mail.isBlank() ||
            name.isBlank();
}
private void showAlert(String msg){
    new Alert(Alert.AlertType.WARNING,msg).showAndWait();

}


private boolean validInputs(){

     
    if(isBlank()){
        showAlert("Tüm alanlar dolu olmalıdır!");
        return false;
    }

    EmailValidator emailValidator = EmailValidator.getInstance();

    var emailIsValid = emailValidator.isValid(mail);

    if(!emailIsValid){
        showAlert("Geçersiz Email !");
        return false;
    }

    return true;
}


    @FXML
    void UserRegisterOnClick(ActionEvent event) {

        this.name = txt_UserName.getText();
        this.password = txt_UserPsswrd.getText();
        this.mail = txt_UserMail.getText();//bitti
       

        boolean isValid = validInputs();

        if(isValid){

            UserDAO customerDAO = new UserDAO();

            User user = new User(name,password,mail);

            System.out.println("User: "+user);

            var result = customerDAO.insert(user);

            if(result != 0){

                showAlert("Kayıt Eklendi!");

                var stage = (Stage) txt_UserName.getScene().getWindow();
                var loginWindow = ViewLoader.load("Login",new UserLoginController());
                stage.setScene(new Scene(loginWindow));
            }

            else {
                showAlert("Kayıt eklenemedi!");
            }

        }


        
    }
    
}