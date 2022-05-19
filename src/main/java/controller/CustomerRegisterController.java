package controller;

import dal.dao.CustomerDAO;
import helper.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.stage.Stage;
import org.apache.commons.validator.routines.EmailValidator;

import pojo.Customer;


public class CustomerRegisterController extends BaseController {

//buda degisiklik yaptim ama ise yaramadi zaten hepsi true donuyor NOT: BİR DOST NOT2:sorun cozuldu dostlar sagolsun...
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

    private  String name;
    private  String password;
    private  String mail;//bitti
    private  String phone;//bitti
    private  String address;
    private  String tcNo;//bitti(son rakam haric)


    private boolean isBlank(){

        // isBlank sadece bos olunca calisir
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

        Pattern kontrolPhone=Pattern.compile("5[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]");
        Matcher phoneVeri=kontrolPhone.matcher(phone);

        if(!phoneVeri.matches()){
            showAlert("Geçersiz numara!");
            return false;
        }

//son rakam sadece sifir olabiliyor sonra kontrol et
        Pattern KontrolTc=Pattern.compile("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]0");
        Matcher TcVeri=KontrolTc.matcher(tcNo);
        if(!TcVeri.matches()){
            showAlert("Geçersiz tc!");
            return false;
        }

        return true;
    }

    @FXML
    void registerOnClick(ActionEvent event) {

        this.name = txt_name.getText();
        this.password = pwd_pass.getText();
        this.mail = txt_mail.getText();//bitti
        this.phone = txt_phone.getText();
        this.address = txt_address.getText();//bitti
        this.tcNo = txt_tc.getText();

        boolean isValid = validInputs();

        if(isValid){

            CustomerDAO customerDAO = new CustomerDAO();

            Customer customer = new Customer(name,password,mail,phone,tcNo,address);

            System.out.println("Customer: "+customer);

            var result = customerDAO.insert(customer);

            if(result != 0){

                showAlert("Kayıt Eklendi!");

                var stage = (Stage) txt_name.getScene().getWindow();
                var loginWindow = ViewLoader.load("CustomerLogin",new CustomerLoginController());
                stage.setScene(new Scene(loginWindow));
            }

            else {
                showAlert("Kayıt eklenemedi!");
            }

        }


    }

}