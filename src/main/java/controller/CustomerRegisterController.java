package controller;

import dal.dao.CustomerDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.apache.commons.validator.routines.EmailValidator;
import pojo.Customer;


public class CustomerRegisterController extends BaseController {


    @FXML
    private PasswordField pwd_pass;

    @FXML
    private TextField txt_address;

    @FXML
    private TextField txt_mail;

    @FXML
    private TextField txt_phone;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_tc;

    private final String name;
    private final String password;
    private final String mail;
    private final String phone;
    private final String address;
    private final String tcNo;


    public CustomerRegisterController(){
        this.name = txt_name.getText();
        this.password = pwd_pass.getText();
        this.mail = txt_mail.getText();
        this.phone = txt_phone.getText();
        this.address = txt_address.getText();
        this.tcNo = txt_tc.getText();
    }


    private boolean isBlank(){
        return password.isBlank() ||
                address.isBlank() ||
                mail.isBlank() ||
                phone.isBlank() ||
                tcNo.isBlank() ||
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
    void registerOnClick(ActionEvent event) {

        boolean isValid = validInputs();


        if(isValid){

            CustomerDAO customerDAO = new CustomerDAO();

            Customer customer = new Customer(name,password,mail,phone,tcNo,address);

            var result = customerDAO.insert(customer);

            if(result)
                showAlert("Kayıt Eklendi!");
            else {
                showAlert("Kayıt eklenemedi!");
            }

        }


    }

}